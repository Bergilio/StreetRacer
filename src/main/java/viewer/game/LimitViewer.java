package viewer.game;


import Gui.GUI;
import model.game.elements.RoadLimit;

public class LimitViewer implements ElementViewer<RoadLimit> {
    @Override
    public void draw(RoadLimit roadLimit, GUI gui) {
        gui.drawLimit(roadLimit.getPosition());
    }
}
