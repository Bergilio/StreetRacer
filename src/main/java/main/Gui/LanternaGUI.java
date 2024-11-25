package main.Gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import main.model.Position;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).createTerminal();
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        Screen s;
        s = new TerminalScreen(terminal);

        s.setCursorPosition(null);
        s.startScreen();
        s.doResizeIfNecessary();

        return s;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();

        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '1') return ACTION.ONE;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '2') return ACTION.TWO;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '3') return ACTION.THREE;

        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;

        return ACTION.NONE;
    }

    @Override
    public void drawChar(int x, int y, char c, String s) {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(s));
        textGraphics.putString(x, y+1, "" + c);
    }

    @Override
    public void drawPlayerCar(Position position) {
        drawChar(position.getX(), position.getY(), 'C', "#FFD700");
    }

    @Override
    public void drawObstacle(Position position) {
        drawChar(position.getX(), position.getY(), 'O', "#0000FF");
    }

    @Override
    public void drawFuel(Position position) {
        drawChar(position.getX(), position.getY(), 'F', "#CC0000");
    }

    @Override
    public void drawLimit(Position position) { drawBackground(position.getX(), position.getY(), "#FFFFFF"); }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawBackground(int x, int y, String color) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(x, y+1, " ");
    }
}

