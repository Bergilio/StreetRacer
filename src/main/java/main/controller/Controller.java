package main.controller;

import java.io.IOException;
import main.Game;
import main.Gui.ACTION;



public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void update(Game game, ACTION action, long time) throws IOException;
}
