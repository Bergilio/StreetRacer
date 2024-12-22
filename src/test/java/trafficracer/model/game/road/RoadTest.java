package trafficracer.model.game.road;

import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficracer.config.GameConfig;
import trafficracer.model.Position;
import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.elements.collidable.Fuel;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.elements.collidable.RoadLimit;
import trafficracer.model.game.road.creator.FuelCreator;
import trafficracer.model.game.road.creator.ObstacleCreator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RoadTest {
    private ObstacleCreator mockObstacleCreator;
    private FuelCreator mockFuelCreator;
    private Road road;

    @BeforeEach
    void setup() {
        mockObstacleCreator = Mockito.mock(ObstacleCreator.class);
        mockFuelCreator = Mockito.mock(FuelCreator.class);

        when(mockObstacleCreator.createElements()).thenReturn(List.of(new Obstacle(2, 0, 5, 5),
                                                                      new Obstacle(42, 10, 5, 5),
                                                                      new Obstacle(9, 20, 5, 5),
                                                                      new Obstacle(27, 30, 5, 5),
                                                                      new Obstacle(42, 40, 5, 5)));

        when(mockFuelCreator.createElements()).thenReturn(List.of(new Fuel(45, 0, 2, 1),
                                                                  new Fuel(17, 10, 2, 1),
                                                                  new Fuel(33, 20, 2, 1),
                                                                  new Fuel(23, 30, 2, 1),
                                                                  new Fuel(34, 40, 2, 1)));

        road = new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT, mockObstacleCreator, mockFuelCreator);
    }

    @Test
    void testPlayerCarInitialization() {
        PlayerCar playerCar = road.getPlayerCar();
        assertNotNull(playerCar);
        assertEquals(GameConfig.PLAYER_START_X, playerCar.getPosition().getX());
        assertEquals(GameConfig.PLAYER_START_Y, playerCar.getPosition().getY());
    }

    @Test
    void testRoadLimitInitialization() {
        List<RoadLimit> limits = road.getLimits();
        assertEquals(road.getHeight() * 2, limits.size());

        for (RoadLimit limit : limits) {
            assertTrue(limit.getPosition().getX() == 0 || limit.getPosition().getX() == road.getWidth() - 1);
        }
    }

    @Test
    void testDashLinesInitialization() {
        List<RoadLimit> dashLines = road.getDashLines();
        assertEquals((road.getHeight() * 2) / 4 + 1 , dashLines.size()); // the +1 comes from the fact that in the interval [0, 100], 0 % 4 == 0 (as well as the other 25 numbers in [1, 100]

        for (RoadLimit dashLine : dashLines) {
            assertTrue(dashLine.getPosition().getX() == road.getWidth() / 3 || dashLine.getPosition().getX() == (road.getWidth()* 2) / 3);
        }
    }

    // Generators used in property based testing, so that we have integers do define a position within the road limits, as others are not important in the context of the game
    @Provide
    Arbitrary<Integer> generateX() {
        return Arbitraries.integers().between(0, GameConfig.ROAD_WIDTH - 1);
    }

    @Provide
    Arbitrary<Integer> generateY() {
        return Arbitraries.integers().between(0, GameConfig.ROAD_HEIGHT - 1);
    }


    @Property
    void testIsLimit(@ForAll("generateX") int x, @ForAll("generateY") int y) {
        // Property based testing does not recognize the @BeforeEach method so we have to mock inside this again
        mockObstacleCreator = Mockito.mock(ObstacleCreator.class);
        mockFuelCreator = Mockito.mock(FuelCreator.class);

        when(mockObstacleCreator.createElements()).thenReturn(List.of(new Obstacle(2, 0, 5, 5),
                new Obstacle(42, 10, 5, 5),
                new Obstacle(9, 20, 5, 5),
                new Obstacle(27, 30, 5, 5),
                new Obstacle(42, 40, 5, 5)));

        when(mockFuelCreator.createElements()).thenReturn(List.of(new Fuel(45, 0, 2, 1),
                new Fuel(17, 10, 2, 1),
                new Fuel(33, 20, 2, 1),
                new Fuel(23, 30, 2, 1),
                new Fuel(34, 40, 2, 1)));

        road = new Road(GameConfig.ROAD_WIDTH, GameConfig.ROAD_HEIGHT, mockObstacleCreator, mockFuelCreator);

        Position position = new Position(x, y);
        boolean isLimit = road.isLimit(position);

        if (position.getX() == 0 || position.getX() == GameConfig.ROAD_WIDTH - 1) {
            assertTrue(isLimit);
        } else {
            assertFalse(isLimit);
        }
    }




}
