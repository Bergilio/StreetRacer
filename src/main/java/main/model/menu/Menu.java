package main.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu extends DefaultMenu{
    public Menu() {
        super("Menu", Arrays.asList("Start Game", "Top Scores", "Quit"), 0);
    }
}
