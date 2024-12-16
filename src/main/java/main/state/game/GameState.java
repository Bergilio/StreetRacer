package main.state.game;

import main.controller.Controller;
import main.controller.game.RoadController;
import main.model.game.road.Road;
import main.state.State;
import main.viewer.Viewer;
import main.viewer.game.GameViewer;

public class GameState extends State<Road> {

    public GameState(Road road) {
        super(road);
    }

    @Override
    protected Viewer<Road> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Road> getController() {
        return new RoadController(getModel());
    }
}
