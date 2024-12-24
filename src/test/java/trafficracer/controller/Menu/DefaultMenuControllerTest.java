package trafficracer.controller.Menu;

import trafficracer.model.menu.DefaultMenu;
import trafficracer.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.controller.menu.DefaultMenuController;
import trafficracer.gui.ACTION;
import trafficracer.state.menu.MenuState;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DefaultMenuControllerTest {
    private DefaultMenuController controller;
    private Game gameMock;
    private DefaultMenu menuMock;

    @BeforeEach
    void setUp() {

        menuMock = mock(DefaultMenu.class);
        when(menuMock.getCurrentSelection()).thenReturn(0);
        controller = new DefaultMenuController<>(menuMock) {
            @Override
            protected void firstSelection(Game game) {

                game.setState(new MenuState((Menu) menuMock));
            }

            @Override
            protected void secondSelection(Game game){
                game.setState(new MenuState((Menu) menuMock));
            }
        };
        gameMock = mock(Game.class); // Mock do jogo
    }

    @Test
    void testUpAction() throws IOException {
        controller.update(gameMock, ACTION.UP, 0);
        verify(menuMock).setCurrentSelection(2);
    }

    @Test
    void testDownAction() throws IOException {
        controller.update(gameMock, ACTION.DOWN, 0);
        verify(menuMock).setCurrentSelection(1);
    }

    /*@Test
    void testFirstSelection() throws IOException {
        when(menuMock.getCurrentSelection()).thenReturn(1);
        controller.update(gameMock, ACTION.SELECT, 0);
        ArgumentCaptor<MenuState> captor = ArgumentCaptor.forClass(MenuState.class);
        verify(gameMock).setState(captor.capture());
    }

    @Test
    void testSecondSelection() throws IOException {
        when(menuMock.getCurrentSelection()).thenReturn(1);

        controller.update(gameMock, ACTION.SELECT, 0);
        ArgumentCaptor<MenuState> captor = ArgumentCaptor.forClass(MenuState.class);
        verify(gameMock).setState(captor.capture());
        assert captor.getValue() instanceof MenuState;

    }*/

    @Test
    void testNullSelection() throws IOException {
        when(menuMock.getCurrentSelection()).thenReturn(3);
        controller.update(gameMock, ACTION.SELECT, 0);

        verify(gameMock).setState(null);
    }
}
