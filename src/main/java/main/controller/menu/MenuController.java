package main.controller.menu;

import main.Game;
import main.State.GameState;
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
        switch (action) {
            case ONE:
                game.setState(new GameState(new Road(20, 20)));
                break;
            case TWO:
                break;
            case THREE:
                game.setState(null);
                break;
        }
    }
}
