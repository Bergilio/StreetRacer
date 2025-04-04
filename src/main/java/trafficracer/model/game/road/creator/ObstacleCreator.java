package trafficracer.model.game.road.creator;

import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.elements.collidable.Obstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleCreator extends ElementCreator<Obstacle> {
    private final Random random;

    public ObstacleCreator(int roadWidth, int roadHeight, PlayerCar playerCar) {
        super(roadWidth, roadHeight, playerCar);
        this.random = new Random();
    }

    @Override
    protected List<Obstacle> generateElementsForDivision(int positionReference) {
        List<Obstacle> newElements = new ArrayList<>();

        for (int i = 0; i < GameConfig.NUMBER_OF_OBSTACLES_PER_DIVISION; i++) {
            int x = random.nextInt(this.roadWidth - 1 - GameConfig.CAR_WIDTH) + 1;
            int y = positionReference;
            Obstacle obstacle = new Obstacle(x, y, GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);

            Position position = new Position(x, y);
            if (!isPositionValid(position, GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT, newElements)) {
                i--;
                continue;
            }

            newElements.add(obstacle);
        }

        return newElements;
    }

    @Override
    protected boolean isPositionValid(Position position, int width, int height, List<Obstacle> newElements) {
        if (checkCollision(this.playerCar, position, width, height + GameConfig.CAR_HEIGHT / 2)) {
            return false;
        }

        for (Obstacle obstacle : newElements) {
            if (checkCollision(obstacle, position, width, height)) {
                return false;
            }
        }
        return true;
    }
}
