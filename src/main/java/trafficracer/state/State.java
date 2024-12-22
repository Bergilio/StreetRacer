package trafficracer.state;

import trafficracer.Game;
import trafficracer.gui.ACTION;
import trafficracer.gui.GUI;
import trafficracer.controller.Controller;
import trafficracer.viewer.Viewer;

import java.io.IOException;


public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void update(Game game, GUI gui, long time) throws IOException {
        ACTION action = gui.getNextAction();
        controller.update(game, action, time);
        viewer.draw(gui);
    }
}
