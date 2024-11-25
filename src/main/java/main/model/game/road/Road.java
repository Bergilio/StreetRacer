package main.model.game.road;

import main.model.Position;
import main.model.game.elements.Fuel;
import main.model.game.elements.Obstacle;
import main.model.game.elements.PlayerCar;
import main.model.game.elements.RoadLimit;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private int width;
    private int height;

    private PlayerCar playerCar = new PlayerCar(10, 18, 20);

    private List<Obstacle> obstacles = createObstacles();
    private List<Fuel> fuels = createFuels();
    private List<RoadLimit> limits = createLimits();

    public Road(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Obstacle> createObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(3, 19));
        obstacles.add(new Obstacle(10, 14));
        obstacles.add(new Obstacle(3, 6));
        return obstacles;
    }

    public List<Fuel> createFuels() {
        List<Fuel> fuels = new ArrayList<>();
        fuels.add(new Fuel(17, 19));
        fuels.add(new Fuel(3, 14));
        fuels.add(new Fuel(17, 6));
        return fuels;
    }

    public List<RoadLimit> createLimits() {
        List<RoadLimit> limits = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            limits.add(new RoadLimit(i, 0));
            limits.add(new RoadLimit(i, 19));
        }
        return limits;
    }

    public boolean isLimit(Position position) {
        for (RoadLimit limit : limits) {
            if (limit.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public boolean isObstacle(Position position) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getPosition().equals(position)) {
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
