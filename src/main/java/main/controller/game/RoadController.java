package main.controller.game;

import main.Game;
import main.config.GameConfig;
import main.controller.game.collidable.LineController;
import main.gui.ACTION;
import main.model.menu.GameOver;
import main.state.menu.GameOverState;
import main.state.menu.PauseState;
import main.controller.game.collidable.FuelController;
import main.controller.game.collidable.ObstacleController;
import main.controller.game.score.ScoreController;
import main.model.game.road.Road;
import main.model.menu.Pause;

import java.io.IOException;

public class RoadController extends GameController {
    private final PlayerCarController playerCarController;
    private final ObstacleController obstacleController;
    private final FuelController fuelController;
    private final ScoreController scoreController;
    private final LineController lineController;

    public RoadController(Road road) {
        super(road);

        this.playerCarController = new PlayerCarController(road);
        this.obstacleController = new ObstacleController(road);
        this.fuelController = new FuelController(road);
        this.scoreController = new ScoreController(road);
        this.lineController = new LineController(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
        if (checkGameOver(action)) {
            this.scoreController.update(game, action, time);

            int reasonNumber = getReasonNumber(action);
            game.setState(new GameOverState(new GameOver(reasonNumber, getModel().getPlayerCar().getPoints())));
        }
        else if (checkPause(action)) {
            game.setState(new PauseState(new Pause(getModel())));
        }
        else {
            this.playerCarController.update(game, action, time);
            this.obstacleController.update(game, action, time);
            this.fuelController.update(game, action, time);
            this.lineController.update(game, action, time);
        }

    }

    private boolean checkGameOver(ACTION action) {
        return action == ACTION.QUIT || getModel().getPlayerCar().getFuel() == 0 || getModel().getPlayerCar().getCollided();
    }

    private boolean checkPause(ACTION action) {
        return action == ACTION.ESC;
    }

    private int getReasonNumber(ACTION action) {
        if (action == ACTION.QUIT) return GameConfig.REASON_QUIT;
        else if (getModel().getPlayerCar().getFuel() == 0) return GameConfig.REASON_FUEL;
        else return GameConfig.REASON_COLLISION;
    }
}
