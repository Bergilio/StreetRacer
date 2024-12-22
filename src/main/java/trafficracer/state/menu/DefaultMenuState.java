package trafficracer.state.menu;

import trafficracer.controller.Controller;
import trafficracer.model.menu.DefaultMenu;
import trafficracer.state.State;
import trafficracer.viewer.Viewer;

public abstract class DefaultMenuState<T extends DefaultMenu> extends State<T> {

    public DefaultMenuState(T model) {
        super(model);
    }

    @Override
    protected abstract Viewer<T> getViewer();

    @Override
    protected abstract Controller<T> getController();

}
