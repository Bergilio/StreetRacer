package main.model.game.road;

import main.model.Position;
import main.model.game.elements.*;
import main.model.game.elements.collidable.Collidable;
import main.model.game.elements.collidable.Fuel;
import main.model.game.elements.collidable.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Road {
    private int width;
    private int height;

    private PlayerCar playerCar;

    private List<Obstacle> obstacles;
    private List<Fuel> fuels;
    private List<RoadLimit> limits;

    private Random random;

    public Road(int width, int height) {
        this.width = width;
        this.height = height;

        this.random = new Random();

        this.playerCar = new PlayerCar(10, 16, 20);

        this.obstacles = createObstacles(6);
        this.fuels = createFuels(4);
        this.limits = createLimits();
    }

    public List<Obstacle> createObstacles(int numberOfObstacles) {
        List<Obstacle> obstacles = new ArrayList<>();
        int properDistribution = 8;

        for (int i = 0; i < numberOfObstacles; i++) {
            int x = random.nextInt(width - 2) + 1;
            int y = properDistribution - random.nextInt(1);

            boolean overlap = false;
            for (Obstacle obstacle : obstacles) {
                if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                    overlap = true;
                    break;
                }
            }

            if (!overlap) {
                obstacles.add(new Obstacle(x, y));
                properDistribution -= 2;
            } else {
                i--;
            }
        }

        return obstacles;
    }

    public List<Fuel> createFuels(int numberOfFuels) {
        List<Fuel> fuels = new ArrayList<>();
        int properDistribution = 6;

        for (int i = 0; i < numberOfFuels; i++) {
            int x = random.nextInt(width - 2) + 1;
            int y = properDistribution - random.nextInt(1);

            boolean overlap = false;
            for (Fuel fuel : fuels) {
                if (fuel.getPosition().getX() == x && fuel.getPosition().getY() == y) {
                    overlap = true;
                    break;
                }
            }

            for (Obstacle obstacle: this.obstacles) {
                if (obstacle.getPosition().getX() == x && obstacle.getPosition().getY() == y) {
                    overlap = true;
                    break;
                }
            }

            if (!overlap) {
                fuels.add(new Fuel(x, y));
                properDistribution -= 2;
            } else {
                i--;
            }
        }

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


    public boolean isCollidable(Position position, List<Collidable> collidables) {
        for (Collidable collidable : collidables) {
            if (collidable.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

/*
    public List<Collidable> getAllCollidables() {
        List<Collidable> allCollidables = new ArrayList<>();
        allCollidables.addAll(fuels);
        allCollidables.addAll(obstacles);
        return allCollidables;
    }
*/


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
