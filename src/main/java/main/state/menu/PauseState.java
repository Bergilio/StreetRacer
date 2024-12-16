package main.state.menu;

import main.controller.Controller;
import main.controller.menu.PauseController;
import main.model.game.road.Road;
import main.model.menu.DefaultMenu;
import main.model.menu.Pause;
import main.viewer.Viewer;
import main.viewer.menu.PauseViewer;

public class PauseState extends DefaultMenuState{
    private final Road road;

    public PauseState(Pause model, Road road) {
        super(model);
        this.road = road;
    }

    @Override
    protected Viewer<DefaultMenu> getViewer() {
        return new PauseViewer((Pause) getModel());
    }

    @Override
    protected Controller<DefaultMenu> getController() {
        return new PauseController((Pause) getModel());
    }

    public Road getRoad() {
        return this.road;
    }
}
