package main.viewer.menu;

import main.gui.GUI;
import main.config.GameConfig;
import main.model.Position;
import main.model.menu.DefaultMenu;
import main.viewer.Viewer;

public class DefaultMenuViewer<T extends DefaultMenu> extends Viewer<T> {

    public DefaultMenuViewer(T model) {
        super(model);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y), getModel().getMenuName(), "#FF00FF");

        for (int i = 0; i < getModel().getOptionsSize(); i++) {
            StringBuilder string = new StringBuilder();
            if (getModel().getCurrentSelection() == i) {
                string.append("<");
            }

            string.append(getModel().getOption(i));

            if (getModel().getCurrentSelection() == i) {
                string.append(">");
            }

            gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + i + 2), string.toString(), "#FF00FF");
        }
    }
}
