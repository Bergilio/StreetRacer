package main.controller.game.collidable;

import main.Game;
import main.State.MenuState;
import main.model.Position;
import main.model.game.elements.collidable.Obstacle;
import main.model.game.road.Road;
import main.model.menu.Menu;

import java.util.Iterator;

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
        return obstacle.getPosition().getY() >= 20;
    }

    private void moveObstacle(Game game, Obstacle obstacle, Position position) {
        obstacle.setPosition(position);

        if (obstacle.getPosition().equals(getModel().getPlayerCar().getPosition())) {
            game.setState(new MenuState(new Menu()));
        }
    }

}
