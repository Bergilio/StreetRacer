package trafficracer.viewer.game;


import trafficracer.model.Position;
import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.elements.collidable.Fuel;
import trafficracer.model.game.elements.collidable.Obstacle;
import trafficracer.model.game.elements.collidable.RoadLimit;
import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficracer.gui.GUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {

    private GameViewer gameViewer;
    private GUI gui;
    private Road road;


    private Fuel fuel;
    private Obstacle obstacle;
    private PlayerCar playerCar;


    private FuelViewer fuelViewer;
    private ObstacleViewer obstacleViewer;
    private PlayerCarViewer playerCarViewer;

    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
        fuelViewer = new FuelViewer();

        playerCar = new PlayerCar(10, 12, 5, 5);
        List<Obstacle> obstacles = Arrays.asList(
                new Obstacle(5, 6, 2, 3),
                new Obstacle(7, 8, 4, 5)
        );
        List<Fuel> fuels = Arrays.asList(
                new Fuel(1, 2, 3, 4),
                new Fuel(3, 4, 5, 6)
        );

        List<RoadLimit> limits = Arrays.asList(
                new RoadLimit(0, 0),
                new RoadLimit(1, 0)
        );
        List<RoadLimit> dashLines = Arrays.asList(
                new RoadLimit(0, 1),
                new RoadLimit(1, 1)
        );


        road = mock(Road.class);
        when(road.getPlayerCar()).thenReturn(playerCar);
        when(road.getObstacles()).thenReturn(obstacles);
        when(road.getFuels()).thenReturn(fuels);
        when(road.getLimits()).thenReturn(limits);
        when(road.getDashLines()).thenReturn(dashLines);

        gameViewer = new GameViewer(road);
    }

    @Test
    void drawFuels() throws IOException {
        gameViewer.drawElement(gui);
        Mockito.verify(gui, times(1)).drawFuel(new Position(1, 2), 3, 4);
        Mockito.verify(gui, times(1)).drawFuel(new Position(3, 4), 5, 6);

    }

    @Test
    void testDrawFuelViewer() {
        Fuel fuel = new Fuel(7, 8, 3, 2);
        fuelViewer.draw(fuel, gui);
        Mockito.verify(gui, times(1)).drawFuel(new Position(7, 8), 3, 2);
    }

    @Test
    void testLimitViewerDraw() {
        LimitViewer limitViewer = new LimitViewer();
        RoadLimit roadLimit = new RoadLimit(5, 10); // Example position

        limitViewer.draw(roadLimit, gui);

        verify(gui, times(1)).drawLimit(new Position(5, 10)); // Verify the correct position is used
    }

    @Test
    void testObstacleViewerDraw() throws IOException {

        ObstacleViewer obstacleViewer = new ObstacleViewer();
        Obstacle obstacle = new Obstacle(5, 10, 2, 3); // Example position, width, and height


        obstacleViewer.draw(obstacle, gui);


        verify(gui, times(1)).drawObstacle(new Position(5, 10), 2, 3); // Verify position, width, and height
    }

    @Test
    void testPlayerCarViewerDraw() throws IOException {

        PlayerCarViewer playerCarViewer = new PlayerCarViewer();
        PlayerCar playerCar = new PlayerCar(15, 20, 3, 4); // Example position, width, and height

        playerCarViewer.draw(playerCar, gui);

        verify(gui, times(1)).drawPlayerCar(new Position(15, 20), 3, 4); // Verify position, width, and height
    }


    @Test
    void testDrawElement() throws IOException {

        gameViewer.drawElement(gui);


        verify(gui, times(1)).drawFuel(new Position(1, 2), 3, 4);
        verify(gui, times(1)).drawFuel(new Position(3, 4), 5, 6);


        verify(gui, times(1)).drawObstacle(new Position(5, 6), 2, 3);
        verify(gui, times(1)).drawObstacle(new Position(7, 8), 4, 5);


        verify(gui, times(1)).drawPlayerCar(new Position(10, 12), 5, 5);


        verify(gui).drawText(any(Position.class), eq("FUEL = 20"), eq("#FF00FF"));
        verify(gui).drawText(any(Position.class), eq("SCORE = 0"), eq("#FF00FF"));


        verify(gui, times(1)).drawLimit(new Position(0, 0));
        verify(gui, times(1)).drawLimit(new Position(1, 0));

        //the following tests are for the dashlines:

        verify(gui, times(1)).drawLimit(new Position(0, 1));
        verify(gui, times(1)).drawLimit(new Position(1, 1));
    }










}
