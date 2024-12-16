package main.state.menu;

import main.controller.Controller;
import main.model.menu.DefaultMenu;
import main.state.State;
import main.viewer.Viewer;

public abstract class DefaultMenuState<T extends DefaultMenu> extends State<T> {

    public DefaultMenuState(T model) {
        super(model);
    }

    @Override
    protected abstract Viewer<T> getViewer();

    @Override
    protected abstract Controller<T> getController();

}
