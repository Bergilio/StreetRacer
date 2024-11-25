package main.controller.game;


import main.Game;
import main.Gui.ACTION;
import main.model.Position;
import main.model.game.elements.Obstacle;
import main.model.game.road.Road;

public class ObstacleController extends GameController {

    public ObstacleController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        for (Obstacle obstacle : getModel().getObstacles()) {
            moveObstacle(obstacle, obstacle.getPosition().getDown());
        }
    }

    public void moveObstacle(Obstacle obstacle, Position position) {
        obstacle.setPosition(position);
    }
}
