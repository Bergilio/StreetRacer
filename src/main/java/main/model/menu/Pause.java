package main.model.menu;

import main.model.game.road.Road;

import java.util.Arrays;

public class Pause extends DefaultMenu{
    protected final Road road;

    public Pause(Road road) {
        super("Pause Menu", Arrays.asList("Resume Game", "Go to Menu", "Quit"), 0);
        this.road = road;
    }

    public Road getRoad() {
        return this.road;
    }
}
