package main.viewer.scoreMenu;

import main.gui.GUI;
import main.config.GameConfig;
import main.model.Position;
import main.model.score.ScoreMenu;
import main.viewer.Viewer;

public class ScoreMenuViewer extends Viewer<ScoreMenu> {

    public ScoreMenuViewer(ScoreMenu scoreMenu) {
        super(scoreMenu);
    }

    @Override
    protected void drawElement(GUI gui) {
        gui.drawText(new Position(2, GameConfig.SCREEN_HEIGHT - 45), "Top Scores", "#FF00FF");

        for (int i = 0; i < getModel().getListOfScores().size(); i++) {
            StringBuilder string = new StringBuilder();
            string.append("#");
            string.append(i+1);
            string.append(" ");
            string.append(getModel().getListOfScores().get(i));

            gui.drawText(new Position(2, GameConfig.SCREEN_HEIGHT - 45 + i + 4), string.toString(), "#FF00FF");
        }

        gui.drawText(new Position(2, GameConfig.SCREEN_HEIGHT - 45 + getModel().getListOfScores().size() + 6),
                "Press [ESC] to go back to the Menu", "#FF00FF");

        gui.drawText(new Position(2, GameConfig.SCREEN_HEIGHT - 45 + getModel().getListOfScores().size() + 8),
                "Press [Q] to reset the scores", "#FF00FF");
    }
}
