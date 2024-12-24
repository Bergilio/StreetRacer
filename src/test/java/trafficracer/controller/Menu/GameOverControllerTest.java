package trafficracer.controller.Menu;

import trafficracer.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import trafficracer.Game;
import trafficracer.controller.menu.GameOverController;
import trafficracer.state.game.GameState;
import trafficracer.state.scoreMenu.ScoreMenuState;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameOverControllerTest {
    private GameOverController controller;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        GameOver gameOverMock = mock(GameOver.class);
        controller = new GameOverController(gameOverMock);
        gameMock = mock(Game.class);
    }

    @Test
    void testFirstSelection() {
        controller.firstSelection(gameMock);
        ArgumentCaptor<GameState> captor = ArgumentCaptor.forClass(GameState.class);
        verify(gameMock).setState(captor.capture());

    }

    @Test
    void testSecondSelection() throws IOException {
        controller.secondSelection(gameMock);
        ArgumentCaptor<ScoreMenuState> captor = ArgumentCaptor.forClass(ScoreMenuState.class);
        verify(gameMock).setState(captor.capture());

    }
}
