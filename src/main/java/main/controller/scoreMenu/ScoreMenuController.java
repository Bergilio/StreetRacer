package main.controller.scoreMenu;

import main.Game;
import main.gui.ACTION;
import main.state.menu.MenuState;
import main.config.GameConfig;
import main.controller.Controller;
import main.model.menu.Menu;
import main.model.score.ScoreMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreMenuController extends Controller<ScoreMenu> {

    public ScoreMenuController(ScoreMenu model) {
        super(model);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {

        List<Integer> scores = getModel().getListOfScores();
        Collections.sort(scores, Collections.reverseOrder());

        if (scores.size() > GameConfig.MAX_SCORES) {
            scores.remove(scores.size() - 1);
            getModel().setListOfScores(scores);
        }

        switch (action) {
            case ESC:
                game.setState(new MenuState(new Menu()));
                break;
            case QUIT:
                scores = new ArrayList<>();
                getModel().setListOfScores(scores);
                break;
        }
    }
}
