package main.viewer.game;

import main.Gui.GUI;
import main.model.game.elements.collidable.Fuel;

public class FuelViewer implements ElementViewer<Fuel> {
    @Override
    public void draw(Fuel fuel, GUI gui) {
        gui.drawFuel(fuel.getPosition());
    }
}
