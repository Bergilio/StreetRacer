package main.state.menu;

import main.controller.Controller;
import main.controller.menu.PauseController;
import main.model.menu.Pause;
import main.viewer.Viewer;
import main.viewer.menu.PauseViewer;

public class PauseState extends DefaultMenuState<Pause>{

    public PauseState(Pause model) {
        super(model);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }

}
