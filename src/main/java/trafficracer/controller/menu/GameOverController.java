package trafficracer.controller.menu;

import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.model.game.road.Road;
import trafficracer.model.menu.GameOver;
import trafficracer.model.menu.Menu;
import trafficracer.state.game.GameState;
import trafficracer.state.menu.MenuState;

public class GameOverController extends DefaultMenuController<GameOver> {

    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void firstSelection(Game game) {
        game.setState(new GameState(new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT)));
    }

    @Override
    public void secondSelection(Game game) {
        game.setState(new MenuState(new Menu()));
    }


}
