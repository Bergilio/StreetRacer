package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.controller.Controller;
import main.model.Position;
import main.model.game.road.Road;

public class PlayerCarController extends GameController {

    public PlayerCarController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (action == ACTION.RIGHT) moveRight();
        if (action == ACTION.LEFT) moveLeft();
    }

    public void moveLeft() {
        movePlayerCar(getModel().getPlayerCar().getPosition().getLeft());
    }

    public void moveRight() {
        movePlayerCar(getModel().getPlayerCar().getPosition().getRight());
    }

    public void movePlayerCar(Position position) {
        if ()
    }
}
