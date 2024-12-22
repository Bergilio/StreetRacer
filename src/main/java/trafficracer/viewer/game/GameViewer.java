package trafficracer.viewer.game;

import trafficracer.gui.GUI;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.Element;
import trafficracer.model.game.road.Road;
import trafficracer.viewer.Viewer;

import java.io.IOException;
import java.util.List;


public class GameViewer extends Viewer<Road> {

    public GameViewer(Road road) {
        super(road);
    }

    @Override
    protected void drawElement(GUI gui) throws IOException {
        drawElement(gui, getModel().getLimits(), new LimitViewer());
        drawElement(gui, getModel().getDashLines(), new LimitViewer());
        drawElement(gui, getModel().getObstacles(), new ObstacleViewer());
        drawElement(gui, getModel().getFuels(), new FuelViewer());
        drawElement(gui, getModel().getPlayerCar(), new PlayerCarViewer());

        gui.drawText(new Position(0, 0), "FUEL = " + getModel().getPlayerCar().getFuel(), "#FF00FF");
        gui.drawText(new Position(GameConfig.ROAD_WIDTH - 12, 0), "SCORE = " + getModel().getPlayerCar().getPoints(), "#FF00FF");
    }

    private <T extends Element> void drawElement(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }
}
