package main.model.menu;

import java.util.Arrays;

public class Pause extends DefaultMenu{
    public Pause() {
        super("Pause Menu", Arrays.asList("Resume Game", "Go to Menu", "Quit"), 0);
    }
}
