package main.controller.game;


import main.Game;
import main.Gui.ACTION;
import main.model.Position;
import main.model.game.elements.Obstacle;
import main.model.game.road.Road;

public class ObstacleController extends GameController {
    private long last;

    public ObstacleController(Road road) {
        super(road);

        this.last = 0;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (time - this.last > 500) {
            for (Obstacle obstacle : getModel().getObstacles()) {
                moveObstacle(obstacle, obstacle.getPosition().getDown());
            }
            this.last = time;
        }
    }

    public void moveObstacle(Obstacle obstacle, Position position) {
        obstacle.setPosition(position);
    }
}
