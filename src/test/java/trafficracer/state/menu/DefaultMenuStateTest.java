package trafficracer.state.menu;

import trafficracer.model.menu.DefaultMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trafficracer.Game;
import trafficracer.controller.Controller;
import trafficracer.gui.ACTION;
import trafficracer.gui.GUI;
import trafficracer.viewer.Viewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DefaultMenuStateTest {
    @Mock
    private DefaultMenu mockMenu;

    @Mock
    private Controller<DefaultMenu> mockController;

    @Mock
    private Viewer<DefaultMenu> mockViewer;

    @Mock
    private Game mockGame;

    @Mock
    private GUI mockGui;

    private DefaultMenuState<DefaultMenu> menuState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        menuState = new DefaultMenuState<DefaultMenu>(mockMenu) {
            @Override
            protected Viewer<DefaultMenu> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<DefaultMenu> getController() {
                return mockController;
            }
        };
    }

    @Test
    void testUpdate() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        ACTION action = ACTION.UP;

        when(mockGui.getNextAction()).thenReturn(action);


        menuState.update(mockGame, mockGui, 100L);

        verify(mockController).update(mockGame, action, 100L);

        verify(mockViewer).draw(mockGui);
    }
}
