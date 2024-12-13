package main.viewer.menu;

import main.Gui.GUI;
import main.model.Position;
import main.model.menu.Menu;
import main.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(7, 5), "Menu", "#FF00FF");

        boolean flag = false;

        for (int i = 0; i < getModel().getOptionsSize(); i++) {
            if (getModel().getCurrentSelection() == i) {
                gui.drawText(new Position(4, 7 + i), "<", "#FF00FF");
                flag = true;
            }

            gui.drawText(new Position(5, 7 + i), getModel().getOption(i), "#FF00FF");

            if (flag) {
                flag = false;
                gui.drawText(new Position(5 + getModel().getOption(i).length(), 7 + i), ">", "#FF00FF");
            }
        }
    }

}
