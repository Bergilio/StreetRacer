package trafficracer.controller.game;

import trafficracer.Game;
import trafficracer.config.GameConfig;
import trafficracer.gui.ACTION;
import trafficracer.model.game.road.Road;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOfScoresController extends GameController {

    public FileOfScoresController(Road road) {
        super(road);
    }

    @Override
    public void update(Game game, ACTION action, long time) throws IOException {
        File file = new File(System.getProperty("user.home"), GameConfig.SCORES_FILE);
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(String.valueOf(getModel().getPlayerCar().getPoints()));
            writer.write(" ");
        }
    }
}
