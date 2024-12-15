package main.controller.game;

import main.Game;
import main.Gui.ACTION;
import main.State.MenuState;
import main.controller.game.collidable.FuelController;
import main.controller.game.collidable.ObstacleController;
import main.model.game.road.Road;
import main.model.menu.Menu;

import java.io.IOException;

public class RoadController extends GameController {
    private final PlayerCarController playerCarController;
    private final ObstacleController obstacleController;
    private final FuelController fuelController;

    public RoadController(Road road) {
        super(road);

        this.playerCarController = new PlayerCarController(road);
        this.obstacleController = new ObstacleController(road);
        this.fuelController = new FuelController(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
        if (checkGameOver(action)) {
            game.setState(new MenuState(new Menu()));
        } else {
            this.playerCarController.update(game, action, time);
            this.obstacleController.update(game, action, time);
            this.fuelController.update(game, action, time);
        }

    }

    private boolean checkGameOver(ACTION action) {
        return action == ACTION.QUIT || getModel().getPlayerCar().getFuel() == 0;
    }
}
