package trafficracer.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.controller.Controller;
import trafficracer.gui.ACTION;
import trafficracer.gui.GUI;
import trafficracer.viewer.Viewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class StateTest {
    private Game game;
    private GUI gui;
    private Controller<Object> controller;
    private Viewer<Object> viewer;
    private State<Object> state;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        gui = mock(GUI.class);
        controller = mock(Controller.class);
        viewer = mock(Viewer.class);

        state = new State<Object>(new Object()) {
            @Override
            protected Viewer<Object> getViewer() {
                return viewer;
            }

            @Override
            protected Controller<Object> getController() {
                return controller;
            }
        };
    }

    @Test
    void testUpdate() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ACTION action = ACTION.UP;

        when(gui.getNextAction()).thenReturn(action);
        state.update(game, gui, 100L);

        verify(controller).update(game, action, 100L);
        verify(viewer).draw(gui);
    }
}
