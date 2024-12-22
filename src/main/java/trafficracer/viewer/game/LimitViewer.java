package trafficracer.viewer.game;


import trafficracer.gui.GUI;
import trafficracer.model.game.elements.collidable.RoadLimit;

public class LimitViewer implements ElementViewer<RoadLimit> {
    @Override
    public void draw(RoadLimit roadLimit, GUI gui) {
        gui.drawLimit(roadLimit.getPosition());
    }
}
