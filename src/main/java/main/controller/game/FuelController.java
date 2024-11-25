package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.model.Position;
import main.model.game.elements.Fuel;
import main.model.game.road.Road;

public class FuelController extends GameController {

    public FuelController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        for (Fuel fuel : getModel().getFuels()) {
            moveFuel(fuel, fuel.getPosition().getDown());
        }
    }

    public void moveFuel(Fuel fuel, Position position) {
        fuel.setPosition(position);
    }
}
