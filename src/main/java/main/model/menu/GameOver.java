package main.model.menu;

import java.util.Arrays;

public class GameOver extends DefaultMenu{

    public GameOver() {
        super("Game Over", Arrays.asList("Try again", "Go to Menu", "Quit"), 0);
    }
}
