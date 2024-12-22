package trafficracer.state.menu;

import trafficracer.controller.Controller;
import trafficracer.controller.menu.PauseController;
import trafficracer.model.menu.Pause;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.menu.PauseViewer;

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
