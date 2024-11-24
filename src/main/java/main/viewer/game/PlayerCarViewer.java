package main.viewer.game;

import main.Gui.GUI;
import main.model.game.elements.PlayerCar;

public class PlayerCarViewer implements ElementViewer<PlayerCar> {
    @Override
    public void draw(PlayerCar playerCar, GUI gui) {
        gui.drawPlayerCar(playerCar.getPosition());
    }
}
