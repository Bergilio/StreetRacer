package trafficracer.controller.menu;

import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.controller.Controller;
import trafficracer.model.menu.DefaultMenu;

import java.io.IOException;

public abstract class DefaultMenuController<T extends DefaultMenu> extends Controller<T> {

    public DefaultMenuController(T model) {
        super(model);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
        int curSelect = getModel().getCurrentSelection();

        switch (action) {
            case UP:
                if (curSelect == 0) curSelect = 2;
                else if (curSelect > 0) curSelect--;
                getModel().setCurrentSelection(curSelect);
                break;

            case DOWN:
                if (curSelect == 2) curSelect = 0;
                else if (curSelect < 2) curSelect++;
                getModel().setCurrentSelection(curSelect);
                break;

            case SELECT:
                if (curSelect == 0) {
                    firstSelection(game);
                    break;
                }else if (curSelect == 1) {
                    secondSelection(game);
                    break;
                } else {
                    game.setState(null);
                    break;
                }
        }
    }

    protected abstract void firstSelection(Game game);

    protected abstract void secondSelection(Game game) throws IOException;
}
