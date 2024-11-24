package viewer.menu;

import Gui.GUI;
import model.Position;
import model.menu.Menu;
import viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FF00FF");

        for (int i = 0; i < getModel().getOptionsSize(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getOption(i), "#FF00FF");
        }
    }

}
