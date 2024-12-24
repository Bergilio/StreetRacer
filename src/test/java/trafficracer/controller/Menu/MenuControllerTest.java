package trafficracer.controller.Menu;

import trafficracer.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import trafficracer.Game;
import trafficracer.controller.menu.MenuController;
import trafficracer.state.game.GameState;
import trafficracer.state.scoreMenu.ScoreMenuState;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuControllerTest {

    private MenuController controller;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        Menu menuMock = mock(Menu.class);
        controller = new MenuController(menuMock);
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
