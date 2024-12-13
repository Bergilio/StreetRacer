package main.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int currentSelection = 0;

    public Menu() {

        this.options = Arrays.asList("Start Game", "Controls", "Quit");
    }

    public int getOptionsSize() {
        return this.options.size();
    }

    public String getOption(int index) {
        return this.options.get(index);
    }

    public int getCurrentSelection() {
        return this.currentSelection;
    }

    public void setCurrentSelection(int currentSelection) {
        this.currentSelection = currentSelection;
    }
}
