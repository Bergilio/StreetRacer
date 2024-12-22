package trafficracer.controller.game.collidable;

import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.road.Road;

import java.util.Iterator;
import java.util.List; 
import java.util.Random;

public class ObstacleController extends CollidableController<Obstacle> {

    public ObstacleController(Road road) {
        super(road);
    }

    @Override
    protected Iterator<Obstacle> getElementsIterator() {
        return getModel().getObstacles().iterator();
    }

    @Override
    protected void updateElement(Game game, Obstacle obstacle) {
        moveObstacle(game, obstacle, obstacle.getPosition().getDown());
    }

    @Override
    protected boolean shouldRemoveElement(Obstacle obstacle) {
        return obstacle.getPosition().getY() >= GameConfig.ROAD_HEIGHT;
    }

    @Override
    protected Obstacle generateElement() {
        Random random = new Random();
        int x = random.nextInt(getModel().getWidth() - 1 - GameConfig.CAR_WIDTH) + 1;
        int y = 0;
        return new Obstacle(x, y, GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);
    }

    @Override
    protected void addElements(List<Obstacle> obstacles) {
        List<Obstacle> newObstacles = getModel().getObstacles();
        newObstacles.addAll(obstacles);
        getModel().setObstacles(newObstacles);
    }

    private void moveObstacle(Game game, Obstacle obstacle, Position position) {
        obstacle.setPosition(position);

        if (obstacle.collides(getModel().getPlayerCar().getPosition(), getModel().getPlayerCar().getWidth(), getModel().getPlayerCar().getHeight())) {
            getModel().getPlayerCar().setCollided(true);
        }
    }

}
