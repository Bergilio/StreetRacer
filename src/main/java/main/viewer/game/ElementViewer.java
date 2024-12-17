package main.viewer.game;

import main.gui.GUI;
import main.model.game.elements.Element;

import java.io.IOException;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui) throws IOException;
}
