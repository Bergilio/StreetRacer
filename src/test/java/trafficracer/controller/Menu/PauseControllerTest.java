package trafficracer.controller.Menu;

import trafficracer.model.menu.Pause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import trafficracer.Game;
import trafficracer.controller.menu.PauseController;
import trafficracer.state.game.GameState;
import trafficracer.state.scoreMenu.ScoreMenuState;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PauseControllerTest {
    private PauseController controller;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        Pause pauseMock = mock(Pause.class);
        controller = new PauseController(pauseMock);
        gameMock = mock(Game.class);
    }

    @Test
    void testFirstSelection() {
        controller.firstSelection(gameMock);
        ArgumentCaptor<GameState> captor = ArgumentCaptor.forClass(GameState.class);
        verify(gameMock).setState(captor.capture());

    }

    @Test
    void testSecondSelection() {
        controller.secondSelection(gameMock);
        ArgumentCaptor<ScoreMenuState> captor = ArgumentCaptor.forClass(ScoreMenuState.class);
        verify(gameMock).setState(captor.capture());

    }
}
