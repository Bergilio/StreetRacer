package trafficracer.controller.game;

import trafficracer.model.game.elements.PlayerCar;
import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.state.State;
import trafficracer.state.menu.GameOverState;
import trafficracer.state.menu.PauseState;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class RoadControllerTest {

    private RoadController roadController;
    private Game gameMock;
    private Road roadMock;

        @BeforeEach
        public void setUp() {
            roadMock = mock(Road.class);
            gameMock = mock(Game.class);
            roadController = new RoadController(roadMock);
        }

    @Test
    void testQuit() throws IOException {
        PlayerCar playerCarMock = mock(PlayerCar.class);
        when(playerCarMock.getFuel()).thenReturn(10);
        when(playerCarMock.getCollided()).thenReturn(false);
        Road roadMock = mock(Road.class);
        when(roadMock.getPlayerCar()).thenReturn(playerCarMock);
        Game gameMock = mock(Game.class);
        RoadController roadController = new RoadController(roadMock);
        roadController.update(gameMock, ACTION.QUIT, 0);
        ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);
        verify(gameMock).setState((State) captor.capture());
        assertTrue(captor.getValue() instanceof GameOverState);
    }

    @Test
    void testPause() throws IOException {
        PlayerCar playerCarMock = mock(PlayerCar.class);
        when(playerCarMock.getFuel()).thenReturn(10);
        when(playerCarMock.getCollided()).thenReturn(false);
        Road roadMock = mock(Road.class);
        when(roadMock.getPlayerCar()).thenReturn(playerCarMock);
        Game gameMock = mock(Game.class);
        RoadController roadController = new RoadController(roadMock);
        roadController.update(gameMock, ACTION.ESC, 0);
        ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);
        verify(gameMock).setState((State) captor.capture());
        assertTrue(captor.getValue() instanceof PauseState);
    }
}





