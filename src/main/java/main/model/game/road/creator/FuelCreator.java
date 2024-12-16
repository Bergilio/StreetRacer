package main.model.game.road.creator;

import main.config.GameConfig;
import main.model.Position;
import main.model.game.elements.Element;
import main.model.game.elements.PlayerCar;
import main.model.game.elements.collidable.Fuel;
import main.model.game.elements.collidable.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuelCreator extends ElementCreator<Fuel> {
    private final List<Obstacle> obstacles;
    private final Random random;

    public FuelCreator(int roadWidth, int roadHeight, PlayerCar playerCar, List<Obstacle> obstacles) {
        super(roadWidth, roadHeight, playerCar);
        this.random = new Random();
        this.obstacles = obstacles;
    }

    @Override
    protected List<Fuel> generateElementsForDivision(int positionReference) {
        List<Fuel> newElements = new ArrayList<>();

        for (int i = 0; i < GameConfig.NUMBER_OF_FUELS_PER_DIVISION; i++) {
            int x = random.nextInt(this.roadWidth - 2 - GameConfig.FUEL_WIDTH) + 1;
            int y = positionReference;
            Fuel fuel = new Fuel(x, y, GameConfig.FUEL_WIDTH, GameConfig.FUEL_HEIGHT);

            Position position = new Position(x, y);
            if (!isPositionValid(position, GameConfig.FUEL_WIDTH, GameConfig.FUEL_HEIGHT, newElements)) {
                i--;
                continue;
            }

            newElements.add(fuel);
        }

        return newElements;
    }

    @Override
    protected boolean isPositionValid(Position position, int width, int height, List<Fuel> newElements) {
        if (checkCollision(this.playerCar, position, width, height)) {
            return false;
        }

        for (Fuel fuel : newElements) {
            if (checkCollision(fuel, position, width, height)) {
                return false;
            }
        }

        for (Obstacle obstacle : this.obstacles) {
            if (checkCollision(obstacle, position, width, height)) {
                return false;
            }
        }

        return true;
    }
}
