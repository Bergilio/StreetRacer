package main.state.scoreMenu;

import main.controller.Controller;
import main.controller.scoreMenu.ScoreMenuController;
import main.model.score.ScoreMenu;
import main.state.State;
import main.viewer.Viewer;
import main.viewer.scoreMenu.ScoreMenuViewer;

public class ScoreMenuState extends State<ScoreMenu> {

    public ScoreMenuState(ScoreMenu scoreMenu) {
        super(scoreMenu);
    }

    protected Viewer<ScoreMenu> getViewer() {
        return new ScoreMenuViewer(getModel());
    }

    protected Controller<ScoreMenu> getController() {
        return new ScoreMenuController(getModel());
    }
}
