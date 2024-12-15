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
        int divisionOfRoad = this.roadHeight / GameConfig.CAR_HEIGHT;
        int positionReference = 0;

        for (int i = 0; i < divisionOfRoad; i++) {
            elements.addAll(generateElementsForDivision(positionReference));
            positionReference += GameConfig.CAR_HEIGHT;
        }

        return elements;
    }


    // Will have to make it abstract and define it in each class that extends as the logic differs slightly
    protected boolean isPositionValid(Position position, int width, int height, List<? extends Collidable> collidables) {
        if (checkCollision(this.playerCar, position, width, height)) {
            return false;
        }

        for (Collidable collidable : collidables) {
            if (checkCollision(collidable, position, width, height)) {
                return false;
            }
        }
        return true;
    }

    protected abstract List<T> generateElementsForDivision(int positionReference);

    protected abstract boolean checkCollision(Element element, Position position, int w, int h);

}
