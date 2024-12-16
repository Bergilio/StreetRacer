package main.state.menu;

import main.controller.Controller;
import main.model.menu.DefaultMenu;
import main.state.State;
import main.viewer.Viewer;

public abstract class DefaultMenuState extends State<DefaultMenu> {

    public DefaultMenuState(DefaultMenu model) {
        super(model);
    }

    @Override
    protected abstract Viewer<DefaultMenu> getViewer();

    @Override
    protected abstract Controller<DefaultMenu> getController();

}
