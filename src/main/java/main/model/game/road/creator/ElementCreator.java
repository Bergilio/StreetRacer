package main.model.game.road.creator;

import main.config.GameConfig;
import main.model.Position;
import main.model.game.elements.Element;
import main.model.game.elements.PlayerCar;
import main.model.game.elements.collidable.Collidable;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementCreator<T extends Collidable> {
    protected final int roadWidth;
    protected final int roadHeight;
    protected final PlayerCar playerCar;

    public ElementCreator(int roadWidth, int roadHeight, PlayerCar playerCar) {
        this.roadWidth = roadWidth;
        this.roadHeight = roadHeight;
        this.playerCar = playerCar;
    }

    public List<T> createElements() {
        List<T> elements = new ArrayList<>();
        int divisionOfRoad = this.roadHeight / (GameConfig.CAR_HEIGHT * 2);
        int positionReference = 0;

        for (int i = 0; i < divisionOfRoad; i++) {
            elements.addAll(generateElementsForDivision(positionReference));
            positionReference += GameConfig.CAR_HEIGHT * 2;
        }

        return elements;
    }

    protected boolean checkCollision(Element element, Position position, int w, int h) {
        return element.collides(position, w, h);
    }

    protected abstract boolean isPositionValid(Position position, int width, int height, List<T> collidables);

    protected abstract List<T> generateElementsForDivision(int positionReference);


}
