package Gui;
import model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawChar(int x, int y, char c, String s);

    void drawPlayerCar(Position position);

    void drawLimit(Position position);

    void drawObstacle(Position position);

    void drawFuel(Position position);

    void clear();

    void close() throws IOException;

    void refresh() throws IOException;

    void drawText(Position position, String text, String color);
}
