package trafficracer.state.menu;

import trafficracer.controller.Controller;
import trafficracer.controller.menu.GameOverController;
import trafficracer.model.menu.GameOver;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.menu.GameOverViewer;

public class GameOverState extends DefaultMenuState<GameOver>{

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
