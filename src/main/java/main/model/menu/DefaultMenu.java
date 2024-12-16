package main.model.menu;

import java.util.List;

public abstract class DefaultMenu {
    protected final String menuName;
    protected final List<String> options;
    protected int currentSelection;

    public DefaultMenu(String menuName, List<String> options, int currentSelection) {
        this.menuName = menuName;
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

    public String getMenuName() {
        return menuName;
    }

}
