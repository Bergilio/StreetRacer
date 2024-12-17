package main.viewer.menu;

import main.config.GameConfig;
import main.gui.GUI;
import main.model.Position;
import main.model.menu.GameOver;

public class GameOverViewer extends DefaultMenuViewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElement(GUI gui) {
        super.drawElement(gui);

        int baseY = GameConfig.MENU_START_Y + getModel().getReasonsSize() + 3;

        gui.drawText(new Position(GameConfig.MENU_START_X, baseY), getModel().getReason(), "#FFA500");

        gui.drawText(new Position(GameConfig.MENU_START_X, baseY + 1),
                "Score: " + getModel().getScore(), "#FFA500");
    }
}
