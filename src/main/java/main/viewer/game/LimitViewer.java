package main.viewer.game;


import main.gui.GUI;
import main.model.game.elements.RoadLimit;

public class LimitViewer implements ElementViewer<RoadLimit> {
    @Override
    public void draw(RoadLimit roadLimit, GUI gui) {
        gui.drawLimit(roadLimit.getPosition());
    }
}
