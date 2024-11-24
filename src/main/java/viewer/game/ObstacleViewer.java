package viewer.game;

import Gui.GUI;
import model.game.elements.Obstacle;


public class ObstacleViewer implements ElementViewer<Obstacle> {
    public void draw(Obstacle obstacle, GUI gui) {
        gui.drawObstacle(obstacle.getPosition());
    }
}
