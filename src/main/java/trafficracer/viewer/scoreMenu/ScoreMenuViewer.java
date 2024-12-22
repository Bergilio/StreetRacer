package trafficracer.viewer.scoreMenu;

import trafficracer.gui.GUI;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.score.ScoreMenu;
import trafficracer.viewer.Viewer;

public class ScoreMenuViewer extends Viewer<ScoreMenu> {

    public ScoreMenuViewer(ScoreMenu scoreMenu) {
        super(scoreMenu);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y), "Top Scores", "#FF00FF");

        for (int i = 0; i < getModel().getListOfScores().size(); i++) {
            StringBuilder string = new StringBuilder();
            string.append("#");
            string.append(i+1);
            string.append(" ");
            string.append(getModel().getListOfScores().get(i));

            gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + i + 3), string.toString(), "#FF00FF");
        }

        gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + getModel().getListOfScores().size() + 5),
                "Press [ESC] to go back to the Menu", "#FF00FF");

        gui.drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + getModel().getListOfScores().size() + 7),
                "Press [Q] to reset the scores", "#FF00FF");
    }
}
