package trafficracer.controller;

import java.io.IOException;

import trafficracer.Game;
import trafficracer.Sound;
import trafficracer.gui.ACTION;



public abstract class Controller<T> extends Sound {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void update(Game game, ACTION action, long time) throws IOException;
}
