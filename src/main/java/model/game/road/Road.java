package model.game.road;

import model.Position;
import model.game.elements.Fuel;
import model.game.elements.Obstacle;
import model.game.elements.PlayerCar;
import model.game.elements.RoadLimit;

import java.util.List;

public class Road {
    private int width;
    private int height;

    private PlayerCar playerCar;

    private List<Obstacle> obstacles;
    private List<Fuel> fuels;
    private List<RoadLimit> limits;

    public Road(int width, int height) {
        this.width = width;
        this.height = height;
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
