package main.controller.menu;

import main.Game;
import main.state.game.GameState;
import main.state.scoreMenu.ScoreMenuState;
import main.config.GameConfig;
import main.model.game.road.Road;
import main.model.menu.Menu;
import main.model.score.ScoreMenu;

import java.io.IOException;

public class MenuController extends DefaultMenuController {

    public MenuController(Menu model) {
        super(model);
    }

    @Override
    protected void firstSelection(Game game) {
        game.setState(new GameState(new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT)));
    }

    @Override
    protected void secondSelection(Game game) throws IOException {
        game.setState(new ScoreMenuState(new ScoreMenu()));
    }
}
