package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.State.MenuState;
import main.model.Position;
import main.model.game.road.Road;
import main.model.menu.Menu;

public class PlayerCarController extends GameController {

    public PlayerCarController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (action == ACTION.RIGHT) moveRight(game);
        if (action == ACTION.LEFT) moveLeft(game);
    }

    public void moveLeft(Game game) {
        movePlayerCar(getModel().getPlayerCar().getPosition().getLeft(), game);
    }

    public void moveRight(Game game) {
        movePlayerCar(getModel().getPlayerCar().getPosition().getRight(), game);
    }

    public void movePlayerCar(Position position, Game game) {
        if (!getModel().isLimit(position)) {
            getModel().getPlayerCar().setPosition(position);
            if (getModel().isObstacle(position)) {
                game.setState(new MenuState(new Menu()));
            }
        }
    }
}
