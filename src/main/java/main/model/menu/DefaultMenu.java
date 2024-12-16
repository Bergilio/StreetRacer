package main.model.menu;

import java.util.List;

public abstract class DefaultMenu {
    protected final List<String> options;
    private int currentSelection;

    public DefaultMenu(List<String> options, int currentSelection) {
        this.options = options;
        this.currentSelection = currentSelection;
    }

    public int getCurrentSelection() {
        return currentSelection;
    }

    public void setCurrentSelection(int currentSelection) {
        this.currentSelection = currentSelection;
    }

    public String getOption(int i) {
        return this.options.get(i);
    }

    public int getOptionsSize() {
        return this.options.size();
    }

}
