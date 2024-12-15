package main.viewer.game;

import main.Gui.GUI;
import main.model.game.elements.collidable.Obstacle;


public class ObstacleViewer implements ElementViewer<Obstacle> {
    public void draw(Obstacle obstacle, GUI gui) {
        gui.drawObstacle(obstacle.getPosition(), obstacle.getWidth(), obstacle.getHeight());
    }
}
