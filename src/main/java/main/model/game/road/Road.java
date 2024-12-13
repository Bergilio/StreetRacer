package main.model.game.road;

import main.model.Position;
import main.model.game.elements.*;
import main.model.game.elements.collidable.Collidable;
import main.model.game.elements.collidable.Fuel;
import main.model.game.elements.collidable.Obstacle;

import java.util.ArrayList;
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

        this.playerCar = new PlayerCar(10, 16, 20);

        this.obstacles = createObstacles();
        this.fuels = createFuels();
        this.limits = createLimits();
    }

    public List<Obstacle> createObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(3, 2));
        obstacles.add(new Obstacle(10, 14));
        obstacles.add(new Obstacle(3, 6));
        return obstacles;
    }

    public List<Fuel> createFuels() {
        List<Fuel> fuels = new ArrayList<>();
        fuels.add(new Fuel(3, 14));
        fuels.add(new Fuel(17, 6));
        fuels.add(new Fuel(17, 2));
        return fuels;
    }

    public List<RoadLimit> createLimits() {
        List<RoadLimit> limits = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            limits.add(new RoadLimit(0, i));
            limits.add(new RoadLimit(19, i));
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

/*
    public boolean isCollidable(Position position) {
        for (Collidable collidable : collidables) {
            if (collidable.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

*/

    public List<Collidable> getAllCollidables() {
        List<Collidable> allCollidables = new ArrayList<>();
        allCollidables.addAll(fuels);
        allCollidables.addAll(obstacles);
        return allCollidables;
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
