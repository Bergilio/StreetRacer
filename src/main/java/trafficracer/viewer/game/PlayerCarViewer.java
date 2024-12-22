package trafficracer.viewer.game;

import trafficracer.gui.GUI;
import trafficracer.model.game.elements.PlayerCar;

import java.io.IOException;

public class PlayerCarViewer implements ElementViewer<PlayerCar> {
    @Override
    public void draw(PlayerCar playerCar, GUI gui) throws IOException {
        gui.drawPlayerCar(playerCar.getPosition(), playerCar.getWidth(), playerCar.getHeight());
    }
}
