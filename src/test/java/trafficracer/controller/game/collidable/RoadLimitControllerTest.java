package trafficracer.controller.game.collidable;

import trafficracer.model.Position;
import trafficracer.model.game.elements.collidable.RoadLimit;
import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.config.GameConfig;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoadLimitControllerTest {
    private RoadLimitController roadLimitController;
    private RoadLimit roadLimit;
    private Road road;

    @BeforeEach
    void setUp() {
        road = new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT);
        roadLimitController = new RoadLimitController(road);

        roadLimit = new RoadLimit(10, 0);
        road.getDashLines().add(roadLimit);
    }

    @Test
    void testShouldRemoveElement() {
        int roadHeight = GameConfig.ROAD_HEIGHT;
        roadLimit.setPosition(new Position(10, roadHeight + 1));
        assertTrue(roadLimitController.shouldRemoveElement(roadLimit));
        roadLimit.setPosition(new Position(10, roadHeight - 1));
        assertFalse(roadLimitController.shouldRemoveElement(roadLimit));
    }

    @Test
    void testUpdate() throws IOException {
        Position initialPosition = new Position(10, 5);
        roadLimit.setPosition(initialPosition);
        assertEquals(5, roadLimit.getPosition().getY());
        roadLimitController.updateElement(new Game(), roadLimit);
        assertEquals(6, roadLimit.getPosition().getY());
    }

    @Test
    void testGenerate() {
        RoadLimit newLimit = roadLimitController.generateElement();
        assertEquals(0, newLimit.getPosition().getY());
        assertTrue(newLimit.getPosition().getX() == GameConfig.ROAD_WIDTH / 3 || newLimit.getPosition().getX() == (GameConfig.ROAD_WIDTH / 3) * 2 + 1); // X deve ser uma das duas posições válidas
    }

    @Test
    void testIsPositionValid() {
        RoadLimit existingLimit = new RoadLimit(10, 10);
        List<RoadLimit> existingLimits = List.of(existingLimit);
        RoadLimit newLimit = new RoadLimit(10, 10);
        assertFalse(roadLimitController.isPositionValid(newLimit, existingLimits));
        newLimit = new RoadLimit(15, 10);
        assertTrue(roadLimitController.isPositionValid(newLimit, existingLimits));
    }
}
