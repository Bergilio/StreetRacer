package trafficracer.controller.game;

import trafficracer.model.Position;
import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.gui.ACTION;

import static org.mockito.Mockito.*;

public class PlayerCarControllerTest {
    private Road roadMock;
    private PlayerCar playerCarMock;
    private PlayerCarController controller;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        roadMock = mock(Road.class);
        playerCarMock = mock(PlayerCar.class);
        gameMock = mock(Game.class);

        when(roadMock.getPlayerCar()).thenReturn(playerCarMock);
        controller = new PlayerCarController(roadMock);
    }

    @Test
    void testMoveLeft() {
        Position leftPosition = new Position(5, 10);
        Position newLeftPosition = new Position(4,10);
        when(playerCarMock.getPosition()).thenReturn(leftPosition);
        when(roadMock.isLimit(leftPosition)).thenReturn(false);
        when(roadMock.isLimit(newLeftPosition)).thenReturn(false);
        controller.update(gameMock, ACTION.LEFT, 0);


        verify(playerCarMock).setPosition(newLeftPosition);
    }

    @Test
    void testMoveRight() {
        Position currentPosition = new Position(10, 10);
        Position newRightPosition = new Position(11, 10);
        when(playerCarMock.getPosition()).thenReturn(currentPosition);
        when(roadMock.isLimit(currentPosition)).thenReturn(false);
        when(roadMock.isLimit(newRightPosition)).thenReturn(false);
        controller.update(gameMock, ACTION.RIGHT, 0);
        verify(playerCarMock).setPosition(newRightPosition);
    }

    @Test
    void testSpendFuelAndIncreasePoints() {
        long currentTime = 5000;
        controller.update(gameMock, null, currentTime + GameConfig.SPEED_DECIDER + 1);
        verify(playerCarMock).spendFuel();
        verify(playerCarMock).increasePoints();
    }

    @Test
    void testNoMovementBeyondLimits() {
        Position leftPosition = new Position(0, 10);
        Position newPosition = new Position (-1,10);
        when(playerCarMock.getPosition()).thenReturn(leftPosition);
        when(roadMock.isLimit(leftPosition)).thenReturn(false);
        when(roadMock.isLimit(newPosition)).thenReturn(true);
        controller.update(gameMock, ACTION.LEFT, 0);
        verify(playerCarMock, never()).setPosition(any());
    }
}
