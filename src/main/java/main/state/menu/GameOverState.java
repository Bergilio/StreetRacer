package main.state.menu;

import main.controller.Controller;
import main.controller.menu.GameOverController;
import main.model.menu.GameOver;
import main.viewer.Viewer;
import main.viewer.menu.GameOverViewer;

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
