package trafficracer.controller.game.collidable;

import trafficracer.model.Position;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.config.GameConfig;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObstacleControllerTest {
    private ObstacleController obstacleController;
    private Obstacle obstacle;

    @BeforeEach
    void setUp() {
        Road road = new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT);
        obstacleController = new ObstacleController(road);
        obstacle = new Obstacle(10, 0, GameConfig.CAR_WIDTH, GameConfig.CAR_HEIGHT);
    }

    @Test
    void testShouldRemove() {
        int roadHeight = GameConfig.ROAD_HEIGHT;
        obstacle.setPosition(new Position(10, roadHeight));
        assertTrue(obstacleController.shouldRemoveElement(obstacle));

        obstacle.setPosition(new Position(10, roadHeight - 1));
        assertFalse(obstacleController.shouldRemoveElement(obstacle));
    }
}
