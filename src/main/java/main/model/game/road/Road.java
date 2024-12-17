package main.model.game.road;

import main.config.GameConfig;
import main.model.Position;
import main.model.game.elements.*;
import main.model.game.elements.collidable.Fuel;
import main.model.game.elements.collidable.Obstacle;
import main.model.game.elements.collidable.RoadLimit;
import main.model.game.road.creator.FuelCreator;
import main.model.game.road.creator.ObstacleCreator;

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


    public Road(int width, int height) {
        this.width = width;
        this.height = height;

        this.playerCar = new PlayerCar(GameConfig.PLAYER_START_X, GameConfig.PLAYER_START_Y,
                                       GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);

        this.dashLines = createDashLines();
        this.obstacles = createObstacles();
        this.fuels = createFuels();
        this.limits = createLimits();
    }

    private List<Obstacle> createObstacles() {
        ObstacleCreator obstacleCreator = new ObstacleCreator(this.width, this.height, this.playerCar);
        return obstacleCreator.createElements();
    }

    private List<Fuel> createFuels() {
        FuelCreator fuelCreator = new FuelCreator(this.width, this.height, this.playerCar, this.obstacles);
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
                dashLines.add(new RoadLimit(GameConfig.ROAD_WIDTH / 3, i));
                dashLines.add(new RoadLimit((GameConfig.ROAD_WIDTH * 2) / 3, i));
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
