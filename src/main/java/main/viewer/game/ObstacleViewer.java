package main.viewer.game;

import main.gui.GUI;
import main.model.game.elements.collidable.Obstacle;

import java.io.IOException;


public class ObstacleViewer implements ElementViewer<Obstacle> {
    public void draw(Obstacle obstacle, GUI gui) throws IOException {
        gui.drawObstacle(obstacle.getPosition(), obstacle.getWidth(), obstacle.getHeight());

    }
}
