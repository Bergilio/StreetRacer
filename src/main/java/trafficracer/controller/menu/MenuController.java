package trafficracer.controller.menu;

import trafficracer.Game;
import trafficracer.state.game.GameState;
import trafficracer.state.scoreMenu.ScoreMenuState;
import trafficracer.config.GameConfig;
import trafficracer.model.game.road.Road;
import trafficracer.model.menu.Menu;
import trafficracer.model.score.ScoreMenu;

import java.io.IOException;

public class MenuController extends DefaultMenuController<Menu> {

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
