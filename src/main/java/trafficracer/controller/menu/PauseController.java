package trafficracer.controller.menu;

import trafficracer.Game;
import trafficracer.state.game.GameState;
import trafficracer.state.menu.MenuState;
import trafficracer.model.menu.Menu;
import trafficracer.model.menu.Pause;

public class PauseController extends DefaultMenuController<Pause> {
    public PauseController(Pause model) {
        super(model);
    }

    @Override
    public void firstSelection(Game game) {
        game.setState(new GameState( getModel().getRoad()));
    }

    @Override
    public void secondSelection(Game game) {
        game.setState(new MenuState(new Menu()));
    }

}
