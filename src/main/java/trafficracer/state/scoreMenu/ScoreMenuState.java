package trafficracer.state.scoreMenu;

import trafficracer.controller.Controller;
import trafficracer.controller.scoreMenu.ScoreMenuController;
import trafficracer.model.score.ScoreMenu;
import trafficracer.state.State;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.scoreMenu.ScoreMenuViewer;

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
