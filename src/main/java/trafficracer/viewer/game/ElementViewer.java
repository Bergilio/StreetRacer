package trafficracer.viewer.game;

import trafficracer.gui.GUI;
import trafficracer.model.game.elements.Element;

import java.io.IOException;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui) throws IOException;
}
