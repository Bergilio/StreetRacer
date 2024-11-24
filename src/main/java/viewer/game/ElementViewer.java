package viewer.game;

import Gui.GUI;
import model.game.elements.Element;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui);
}
