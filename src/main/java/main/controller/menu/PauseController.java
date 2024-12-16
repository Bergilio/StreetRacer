package main.controller.menu;

import main.Game;
import main.state.game.GameState;
import main.state.menu.MenuState;
import main.model.menu.Menu;
import main.model.menu.Pause;

public class PauseController extends DefaultMenuController<Pause> {
    public PauseController(Pause model) {
        super(model);
    }

    @Override
    protected void firstSelection(Game game) {
        game.setState(new GameState( getModel().getRoad()));
    }

    @Override
    protected void secondSelection(Game game) {
        game.setState(new MenuState(new Menu()));
    }

}
