package main.controller.menu;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
import main.Game;
import main.State.GameState;
import main.config.GameConfig;
import main.controller.Controller;
import main.model.game.road.Road;
import main.model.menu.Menu;
import main.Gui.ACTION;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu model) {
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
                    game.setState(new GameState(new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT)));
                    break;
                }else if (curSelect == 1) {
                    break;
                } else {
                    game.setState(null);
                    break;
                }
        }
    }
}
