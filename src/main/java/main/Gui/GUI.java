package main.Gui;
import main.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawPlayerCar(Position position, int width, int height);

    void drawLimit(Position position);

    void drawObstacle(Position position, int width, int height);

    void drawFuel(Position position, int width, int height);

    void drawBigElement(int x, int y, int w, int h, String color);

    void drawText(Position position, String text, String color);

    void drawBackground(int x, int y, String color);

    void clear();

    void close() throws IOException;

    void refresh() throws IOException;

}
