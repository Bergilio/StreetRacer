package main.viewer.game;

import main.gui.GUI;
import main.config.GameConfig;
import main.model.Position;
import main.model.game.elements.Element;
import main.model.game.road.Road;
import main.viewer.Viewer;

import java.util.List;


public class GameViewer extends Viewer<Road> {

    public GameViewer(Road road) {
        super(road);
    }

    @Override
    protected void drawElement(GUI gui) {
        drawElement(gui, getModel().getLimits(), new LimitViewer());
        drawElement(gui, getModel().getObstacles(), new ObstacleViewer());
        drawElement(gui, getModel().getFuels(), new FuelViewer());
        drawElement(gui, getModel().getPlayerCar(), new PlayerCarViewer());

        gui.drawText(new Position(0, 0), "FUEL = " + getModel().getPlayerCar().getFuel(), "#FF00FF");
        gui.drawText(new Position(GameConfig.ROAD_WIDTH - 12, 0), "POINTS = " + getModel().getPlayerCar().getPoints(), "#FF00FF");
    }

    private <T extends Element> void drawElement(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
