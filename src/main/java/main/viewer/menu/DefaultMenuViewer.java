package main.viewer.menu;

import main.gui.GUI;
import main.config.GameConfig;
import main.model.Position;
import main.model.menu.DefaultMenu;
import main.viewer.Viewer;

public class DefaultMenuViewer extends Viewer<DefaultMenu> {

    public DefaultMenuViewer(DefaultMenu defaultMenu) {
        super(defaultMenu);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(GameConfig.SCREEN_WIDTH / 2 - 5, GameConfig.SCREEN_HEIGHT - 45), getModel().getMenuName(), "#FF00FF");

        for (int i = 0; i < getModel().getOptionsSize(); i++) {
            StringBuilder string = new StringBuilder();
            if (getModel().getCurrentSelection() == i) {
                string.append("<");
            }

            string.append(getModel().getOption(i));

            if (getModel().getCurrentSelection() == i) {
                string.append(">");
            }

            gui.drawText(new Position(GameConfig.SCREEN_WIDTH / 2 - 8, GameConfig.SCREEN_HEIGHT - 45 + i + 4), string.toString(), "#FF00FF");
        }
    }
}
