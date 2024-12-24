package trafficracer;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import trafficracer.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficracer.gui.LanternaGUI;

import java.io.IOException;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(50, 50);
        gui.screen = screen;  // Set the mocked screen
    }

    @Test
    void testDrawPlayerCar() throws IOException {
        Position position = new Position(25, 20);
        gui.drawPlayerCar(position, 5, 5);
        Mockito.verify(screen, Mockito.atLeastOnce()).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }

    @Test
    void testDrawObstacle() throws IOException {
        Position position = new Position(10, 10);
        gui.drawObstacle(position, 3, 2);
        Mockito.verify(screen, Mockito.atLeastOnce()).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }


    @Test
    void testDrawText() {
        Position position = new Position(1, 1);
        gui.drawText(position, "Test Text", "#FF0000");
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Test Text");
    }

    @Test
    void testDrawBigElement() {
        int x = 10, y = 10, width = 3, height = 2;
        String color = "#00FF00"; // Green
        gui.drawBigElement(x, y, width, height, color);
        Mockito.verify(tg, Mockito.atLeastOnce()).setForegroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.atLeastOnce()).setBackgroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.atLeastOnce()).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }


    @Test
    void testClear() throws IOException {
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
