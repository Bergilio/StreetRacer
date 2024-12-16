package main.state.menu;

import main.controller.Controller;
import main.controller.menu.MenuController;
import main.model.menu.Menu;
import main.viewer.Viewer;
import main.viewer.menu.MenuViewer;

public class MenuState extends DefaultMenuState<Menu> {

    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
