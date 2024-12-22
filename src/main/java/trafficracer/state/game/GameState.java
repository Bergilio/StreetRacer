package trafficracer.state.game;

import trafficracer.controller.Controller;
import trafficracer.controller.game.RoadController;
import trafficracer.model.game.road.Road;
import trafficracer.state.State;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.game.GameViewer;

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
