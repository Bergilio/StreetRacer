package main.controller.game.collidable;

import main.Game;
import main.config.GameConfig;
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

        if (fuel.collides(getModel().getPlayerCar().getPosition(), getModel().getPlayerCar().getWidth(), getModel().getPlayerCar().getHeight())) {
            increaseFuel();
        }
    }

    @Override
    protected boolean shouldRemoveElement(Fuel fuel) {
        return fuel.getPosition().getY() >= GameConfig.ROAD_HEIGHT ||
        fuel.collides(getModel().getPlayerCar().getPosition(), getModel().getPlayerCar().getWidth(), getModel().getPlayerCar().getHeight());
    }

    @Override
    protected Fuel generateElement() {
        Random random = new Random();
        int x = random.nextInt(getModel().getWidth() - 1 - GameConfig.FUEL_WIDTH) + 1;
        int y = 0;
        return new Fuel(x, y, GameConfig.FUEL_WIDTH, GameConfig.FUEL_HEIGHT);
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
        if (getModel().getPlayerCar().getFuel() + GameConfig.FUEL_ADITION >= GameConfig.MAX_FUEL) {
            getModel().getPlayerCar().setFuel(GameConfig.MAX_FUEL);
            return;
        }
        getModel().getPlayerCar().setFuel(getModel().getPlayerCar().getFuel() + GameConfig.FUEL_ADITION);
    }


}
