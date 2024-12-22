package trafficracer.viewer.game;

import trafficracer.gui.GUI;
import trafficracer.model.game.elements.collidable.Fuel;

public class FuelViewer implements ElementViewer<Fuel> {
    @Override
    public void draw(Fuel fuel, GUI gui) {
        gui.drawFuel(fuel.getPosition(), fuel.getWidth(), fuel.getHeight());
    }
}
