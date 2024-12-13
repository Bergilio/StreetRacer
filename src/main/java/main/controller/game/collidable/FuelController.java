package main.controller.game.collidable;

import main.Game;
import main.model.Position;
import main.model.game.elements.collidable.Fuel;
import main.model.game.road.Road;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FuelController extends CollidableController<Fuel> {

    public FuelController(Road road) {
        super(road);
    }

    @Override
    protected Iterator<Fuel> getElementsIterator() {
        return getModel().getFuels().iterator();
    }

    @Override
    protected void updateElement(Game game, Fuel fuel) {
        moveFuel(fuel, fuel.getPosition().getDown());

        if (fuel.getPosition().equals(getModel().getPlayerCar().getPosition())) {
            increaseFuel();
        }
    }

    @Override
    protected boolean shouldRemoveElement(Fuel fuel) {
        return fuel.getPosition().getY() >= 20 || fuel.getPosition().equals(getModel().getPlayerCar().getPosition());
    }

    @Override
    protected Fuel generateElement() {
        Random random = new Random();
        int x = random.nextInt(getModel().getWidth() - 2) + 1;
        int y = 0;
        return new Fuel(x, y);
    }

    @Override
    protected void addElements(List<Fuel> fuels) {
        List<Fuel> newFuels = getModel().getFuels();
        newFuels.addAll(fuels);
        getModel().setFuels(newFuels);
    }

    private void moveFuel(Fuel fuel, Position position) {
        fuel.setPosition(position);
    }

    private void increaseFuel() {
        getModel().getPlayerCar().setFuel(getModel().getPlayerCar().getFuel() + 5);
    }


}
