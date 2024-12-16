package main.viewer.game;

import main.gui.GUI;
import main.model.game.elements.Element;

public interface ElementViewer <T extends Element> {
    void draw(T element, GUI gui) ;
}
