package main.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;

    public Menu() {
        this.options = Arrays.asList("[1] Start Game", "[2] Controls", "[3] Quit");
    }

    public int getOptionsSize() {
        return this.options.size();
    }

    public String getOption(int index) {
        return this.options.get(index);
    }
}
