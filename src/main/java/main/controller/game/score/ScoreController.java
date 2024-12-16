package main.controller.game.score;

import main.Game;
import main.gui.ACTION;
import main.controller.game.GameController;
import main.model.game.road.Road;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreController extends GameController {

    public ScoreController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/pedro/LEIC/LDTS/project-t06g02/src/main/resources/Files/Scores.txt", true));

        writer.write(String.valueOf(getModel().getPlayerCar().getPoints()));
        writer.write(" ");

        writer.close();
    }
}
