package viewer.game;

import Gui.GUI;
import model.game.elements.Fuel;

public class FuelViewer implements ElementViewer<Fuel> {
    @Override
    public void draw(Fuel fuel, GUI gui) {
        gui.drawFuel(fuel.getPosition());
    }
}
