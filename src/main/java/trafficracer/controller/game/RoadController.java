package trafficracer.controller.game;

import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.controller.game.collidable.RoadLimitController;
import trafficracer.gui.ACTION;
import trafficracer.model.menu.GameOver;
import trafficracer.state.menu.GameOverState;
import trafficracer.state.menu.PauseState;
import trafficracer.controller.game.collidable.FuelController;
import trafficracer.controller.game.collidable.ObstacleController;
import trafficracer.model.game.road.Road;
import trafficracer.model.menu.Pause;

import java.io.IOException;

public class RoadController extends GameController {
    private final PlayerCarController playerCarController;
    private final ObstacleController obstacleController;
    private final FuelController fuelController;
    private final FileOfScoresController scoreController;
    private final RoadLimitController roadLimitController;

    public RoadController(Road road) {
        super(road);

        this.playerCarController = new PlayerCarController(road);
        this.obstacleController = new ObstacleController(road);
        this.fuelController = new FuelController(road);
        this.roadLimitController = new RoadLimitController(road);
        this.scoreController = new FileOfScoresController(road);
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
            this.roadLimitController.update(game, action, time);
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
