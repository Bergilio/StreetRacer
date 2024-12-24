package trafficracer.viewer.menu;


import trafficracer.model.Position;
import trafficracer.model.menu.DefaultMenu;
import trafficracer.model.menu.GameOver;
import trafficracer.model.menu.Menu;
import trafficracer.model.menu.Pause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficracer.config.GameConfig;
import trafficracer.gui.GUI;

import static org.mockito.Mockito.*;

class MenuViewerTest {
        private GUI gui;
        private DefaultMenu defaultMenu;
        private GameOver gameOver;
        private Menu menu;
        private Pause pause;
        @BeforeEach
        void setUp() {
            gui = mock(GUI.class);
            defaultMenu = mock(DefaultMenu.class);
            when(defaultMenu.getMenuName()).thenReturn("Menu");
            when(defaultMenu.getOptionsSize()).thenReturn(3);
            when(defaultMenu.getOption(0)).thenReturn("Start Game");
            when(defaultMenu.getOption(1)).thenReturn("Top Scores");
            when(defaultMenu.getOption(2)).thenReturn("Quit");
            when(defaultMenu.getCurrentSelection()).thenReturn(1);
            gameOver = mock(GameOver.class);
            when(gameOver.getMenuName()).thenReturn("Game Over");
            when(gameOver.getOptionsSize()).thenReturn(3);
            when(gameOver.getOption(0)).thenReturn("Try again");
            when(gameOver.getOption(1)).thenReturn("Go to menu");
            when(gameOver.getOption(2)).thenReturn("Quit");
            when(gameOver.getCurrentSelection()).thenReturn(0);
            when(gameOver.getReason()).thenReturn("Ran out of fuel");
            when(gameOver.getScore()).thenReturn(150);

        }
    @Test
    void testDefaultMenuViewerDraw() {
        // Arrange
        DefaultMenuViewer<DefaultMenu> viewer = new DefaultMenuViewer<>(defaultMenu);
        // Act
        viewer.drawElement(gui);
        // Assert
        verify(gui).drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y), "Menu", "#FF00FF");
        verify(gui).drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + 2), "Start Game", "#FF00FF");
        verify(gui).drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + 3), "<Top Scores>", "#FF00FF");
        verify(gui).drawText(new Position(GameConfig.MENU_START_X, GameConfig.MENU_START_Y + 4), "Quit", "#FF00FF");
    }

}