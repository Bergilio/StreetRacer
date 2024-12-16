package main.state.menu;

import main.controller.Controller;
import main.controller.menu.MenuController;
import main.model.menu.DefaultMenu;
import main.model.menu.Menu;
import main.viewer.Viewer;
import main.viewer.menu.MenuViewer;

public class MenuState extends DefaultMenuState {

    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<DefaultMenu> getViewer() {
        return new MenuViewer((Menu) getModel());
    }

    @Override
    protected Controller<DefaultMenu> getController() {
        return new MenuController((Menu) getModel());
    }
}
