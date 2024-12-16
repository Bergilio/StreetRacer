package main.state.menu;

import main.controller.Controller;
import main.controller.menu.GameOverController;
import main.model.menu.DefaultMenu;
import main.model.menu.GameOver;
import main.viewer.Viewer;
import main.viewer.menu.GameOverViewer;

public class GameOverState extends DefaultMenuState{

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<DefaultMenu> getViewer() {
        return new GameOverViewer((GameOver) getModel());
    }

    @Override
    protected Controller<DefaultMenu> getController() {
        return new GameOverController((GameOver) getModel());
    }
}
