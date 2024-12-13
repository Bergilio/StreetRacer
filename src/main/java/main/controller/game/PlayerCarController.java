package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.model.Position;
import main.model.game.road.Road;

public class PlayerCarController extends GameController {
    private long last;
    private long speedDecider;

    public PlayerCarController(Road road) {
        super(road);

        this.last = 0;
        this.speedDecider = 500;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (action == ACTION.RIGHT) moveRight(game);
        if (action == ACTION.LEFT) moveLeft(game);

        if (time - this.last > this.speedDecider) {
            spendFuel(game);

            this.last = time;
        }
    }

    public void moveLeft(Game game) {
        movePlayerCar(getModel().getPlayerCar().getPosition().getLeft(), game);
    }

    public void moveRight(Game game) {
        movePlayerCar(getModel().getPlayerCar().getPosition().getRight(), game);
    }

    public void spendFuel(Game game) {
        getModel().getPlayerCar().setFuel(getModel().getPlayerCar().getFuel() - 1);
    }

    public void movePlayerCar(Position position, Game game) {
        if (!getModel().isLimit(position)) {
            getModel().getPlayerCar().setPosition(position);
        }
    }
}
