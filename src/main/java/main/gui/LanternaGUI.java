package main.gui;

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
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q')) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;

        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.ESC;

        return ACTION.NONE;
    }


    @Override
    public void drawPlayerCar(Position position, int width, int height) {
        drawBigElement(position.getX(), position.getY(), width, height, "#FFD700");
    }

    @Override
    public void drawObstacle(Position position, int width, int height) {
        drawBigElement(position.getX(), position.getY(), width, height, "#0000FF");
    }

    @Override
    public void drawFuel(Position position, int width, int height) {
        drawBigElement(position.getX(), position.getY(), width, height, "#CC0000");
    }

    @Override
    public void drawLimit(Position position) {
        drawText(position, "|", "#FFFFFF");
    }

    @Override
    public void drawBigElement(int x, int y, int w, int h, String color) {
        for (int i = y; i < y + h; i++) {
            for (int j = x; j < x + w; j++) {
                drawBackground(j, i, color);
            }
        }
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textGraphics = getTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), text);

    }

    @Override
    public void drawBackground(int x, int y, String color) {
        TextGraphics textGraphics = getTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(x, y, " ");
    }

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

    public TextGraphics getTextGraphics() {
        return this.screen.newTextGraphics();
    }
}

