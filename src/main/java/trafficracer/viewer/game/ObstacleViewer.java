package trafficracer.viewer.game;

import trafficracer.gui.GUI;
import trafficracer.model.game.elements.collidable.Obstacle;

import java.io.IOException;


public class ObstacleViewer implements ElementViewer<Obstacle> {
    public void draw(Obstacle obstacle, GUI gui) throws IOException {
        gui.drawObstacle(obstacle.getPosition(), obstacle.getWidth(), obstacle.getHeight());

    }
}
