package trafficracer.controller.game;

import trafficracer.controller.Controller;
import trafficracer.model.game.road.Road;

public abstract class GameController extends Controller<Road> {

    public GameController(Road road) {
        super(road);
    }
}
