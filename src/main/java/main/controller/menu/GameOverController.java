package main.controller.menu;

import main.Game;
import main.config.GameConfig;
import main.model.game.road.Road;
import main.model.menu.GameOver;
import main.model.menu.Menu;
import main.state.game.GameState;
import main.state.menu.MenuState;

public class GameOverController extends DefaultMenuController<GameOver> {

    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    protected void firstSelection(Game game) {
        game.setState(new GameState(new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT)));
    }

    @Override
    protected void secondSelection(Game game) {
        game.setState(new MenuState(new Menu()));
    }


}
