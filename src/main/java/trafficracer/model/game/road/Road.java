package trafficracer.model.game.road;

import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.elements.collidable.Fuel;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.elements.collidable.RoadLimit;
import trafficracer.model.game.road.creator.FuelCreator;
import trafficracer.model.game.road.creator.ObstacleCreator;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private int width;
    private int height;

    private PlayerCar playerCar;

    private List<Obstacle> obstacles;
    private List<Fuel> fuels;
    private List<RoadLimit> limits;
    private List<RoadLimit> dashLines;

    private ObstacleCreator obstacleCreator;
    private FuelCreator fuelCreator;


    // IMPORTANT: This constructor has the only purpose of allowing dependency injection so that we can test this class
    //            without depending on the ObstacleCreator and FuelCreatorClasses
    public Road(int width, int height, ObstacleCreator obstacleCreator, FuelCreator fuelCreator) {
        this.width = width;
        this.height = height;

        this.playerCar = new PlayerCar(GameConfig.PLAYER_START_X, GameConfig.PLAYER_START_Y,
                GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);

        this.limits = createLimits();
        this.dashLines = createDashLines();

        this.obstacleCreator = obstacleCreator;
        this.obstacles = createObstacles();

        this.fuelCreator = fuelCreator;
        this.fuels = createFuels();
    }


    public Road(int width, int height) {
        this.width = width;
        this.height = height;

        this.playerCar = new PlayerCar(GameConfig.PLAYER_START_X, GameConfig.PLAYER_START_Y,
                                       GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);

        this.limits = createLimits();
        this.dashLines = createDashLines();

        this.obstacleCreator = new ObstacleCreator(this.width, this.height, this.playerCar);
        this.obstacles = createObstacles();

        this.fuelCreator = new FuelCreator(this.width, this.height, this.playerCar, this.obstacles);
        this.fuels = createFuels();

    }

    private List<Obstacle> createObstacles() {
        return obstacleCreator.createElements();
    }

    private List<Fuel> createFuels() {
        return fuelCreator.createElements();
    }

    private List<RoadLimit> createLimits() {
        List<RoadLimit> limits = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            limits.add(new RoadLimit(0, i));
            limits.add(new RoadLimit(this.width - 1, i));
        }
        return limits;
    }

    private List<RoadLimit> createDashLines() {
        List<RoadLimit> dashLines = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            if (i % 4 == 0) {
                dashLines.add(new RoadLimit(this.width / 3, i));
                dashLines.add(new RoadLimit((this.width * 2) / 3, i));
            }
        }
        return dashLines;
    }

    public boolean isLimit(Position position) {
        for (RoadLimit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerCar getPlayerCar() {
        return playerCar;
    }

    public void setPlayerCar(PlayerCar playerCar) {
        this.playerCar = playerCar;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public List<RoadLimit> getDashLines() {
        return dashLines;
    }

    public void setDashLines(List<RoadLimit> dashLines) {
        this.dashLines = dashLines;
    }

    public List<Fuel> getFuels() {
        return fuels;
    }

    public void setFuels(List<Fuel> fuels) {
        this.fuels = fuels;
    }

    public List<RoadLimit> getLimits() {
        return limits;
    }

    public void setLimits(List<RoadLimit> limits) {
        this.limits = limits;
    }


}
