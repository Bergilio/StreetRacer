package trafficracer.controller.scoreMenu;

import trafficracer.model.score.ScoreMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.state.menu.MenuState;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class ScoreMenuControllerTest {

    private ScoreMenuController controller;
    private ScoreMenu scoreMenuMock;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        scoreMenuMock = mock(ScoreMenu.class);
        gameMock = mock(Game.class);
        controller = new ScoreMenuController(scoreMenuMock);
    }

    @Test
    void testEsc() throws IOException {
        controller.update(gameMock, ACTION.ESC, 0);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    void testQuit() throws IOException {
        controller.update(gameMock, ACTION.QUIT, 0);
        verify(scoreMenuMock).setListOfScores(new ArrayList<>());
    }


}
