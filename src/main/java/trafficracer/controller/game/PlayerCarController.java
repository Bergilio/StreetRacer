package trafficracer.controller.game;

import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.road.Road;

public class PlayerCarController extends GameController {
    private long last;
    private long speedDecider;

    public PlayerCarController(Road road) {
        super(road);

        this.last = 0;
        this.speedDecider = GameConfig.SPEED_DECIDER;
    }

    @Override
    public void update(Game game, ACTION action, long time) {
        if (action == ACTION.RIGHT) moveRight(game);
        if (action == ACTION.LEFT) moveLeft(game);

        if (time - this.last > this.speedDecider) {
            spendFuel();
            increasePoints();

            this.last = time;
        }
    }

    private void moveLeft(Game game) {
        movePlayerCar(getModel().getPlayerCar().getPosition().getLeft(), null, game);
    }

    private void moveRight(Game game) {
        Position rightmostPosition = new Position(getModel().getPlayerCar().getPosition().getRight().getX() + GameConfig.CAR_WIDTH - 1,
                                                  getModel().getPlayerCar().getPosition().getRight().getY());

        movePlayerCar(getModel().getPlayerCar().getPosition().getRight(), rightmostPosition, game);
    }

    private void movePlayerCar(Position leftmostPosition, Position rightmostPosition, Game game) {
        if (!getModel().isLimit(leftmostPosition) && !getModel().isLimit(rightmostPosition)) {
            getModel().getPlayerCar().setPosition(leftmostPosition);
        }
    }

    private void spendFuel() {
        getModel().getPlayerCar().spendFuel();
    }

    private void increasePoints() {
        getModel().getPlayerCar().increasePoints();
    }
}
