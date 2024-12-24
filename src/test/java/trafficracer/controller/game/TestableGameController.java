package trafficracer.controller.game;

import trafficracer.model.game.road.Road;
import trafficracer.Game;
import trafficracer.gui.ACTION;

import java.io.IOException;

public class TestableGameController extends GameController {
    public TestableGameController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
    }
}
