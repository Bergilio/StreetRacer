package trafficracer.state.game;

import trafficracer.model.game.road.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.Game;
import trafficracer.controller.Controller;
import trafficracer.controller.game.RoadController;
import trafficracer.gui.ACTION;
import trafficracer.gui.GUI;
import trafficracer.viewer.Viewer;
import trafficracer.viewer.game.GameViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameStateTest {
    private Game game;
    private GUI gui;
    private Road road;
    private RoadController roadController;
    private GameViewer gameViewer;
    private GameState gameState;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        gui = mock(GUI.class);
        road = mock(Road.class);
        roadController = mock(RoadController.class);
        gameViewer = mock(GameViewer.class);
        gameState = new GameState(road) {
            @Override
            protected Viewer<Road> getViewer() {
                return gameViewer;
            }

            @Override
            protected Controller<Road> getController() {
                return roadController;
            }
        };
    }

    @Test
    void test1() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ACTION action = ACTION.UP;
        when(gui.getNextAction()).thenReturn(action);
        gameState.update(game, gui, 100L);
        verify(roadController).update(game, action, 100L);
        verify(gameViewer).draw(gui);
    }
    @Test
    void test2() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        ACTION action = ACTION.DOWN;
        when(gui.getNextAction()).thenReturn(action);
        gameState.update(game, gui, 100L);

        verify(roadController).update(game, action, 100L);

        verify(gameViewer).draw(gui);
    }
}
