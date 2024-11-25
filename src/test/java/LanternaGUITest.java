

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import main.Gui.LanternaGUI;
import main.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {

    private LanternaGUI gui;
    private Screen screen;

    @BeforeEach
    void setUp() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        gui= new LanternaGUI(20,20);

    }



    @Test //teste passa
    void testDrawChar() throws Exception {

        int x = 5, y = 5;
        char c = 'A';
        String color = "#FF0000";
        gui.drawChar(x, y, c, color);

    }


    @Test //passa
    void drawCar() throws IOException {
        TextGraphics tg = Mockito.mock(TextGraphics.class);
        LanternaGUI gui = Mockito.spy(new LanternaGUI(20, 20));
        Mockito.doReturn(tg).when(gui).getTextGraphics();
        gui.drawPlayerCar(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "C");
    }
}