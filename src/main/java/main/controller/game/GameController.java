package main.controller.game;

import main.controller.Controller;
import main.model.game.road.Road;

public abstract class GameController extends Controller<Road> {

    public GameController(Road road) {
        super(road);
    }
}
