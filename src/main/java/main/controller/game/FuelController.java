package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.model.Position;
import main.model.game.elements.Fuel;
import main.model.game.road.Road;

public class FuelController extends GameController {
    private long last;

    public FuelController(Road road) {
        super(road);

        this.last = 0;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (time - this.last > 500) {
            for (Fuel fuel : getModel().getFuels()) {
                moveFuel(fuel, fuel.getPosition().getDown());
            }
            this.last = time;
        }
    }

    public void moveFuel(Fuel fuel, Position position) {
        fuel.setPosition(position);
    }
}
