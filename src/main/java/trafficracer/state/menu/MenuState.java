package trafficracer.state.menu;

import trafficracer.controller.Controller;
import trafficracer.controller.menu.MenuController;
import trafficracer.model.menu.Menu;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.menu.MenuViewer;

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
