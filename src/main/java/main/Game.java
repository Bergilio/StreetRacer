package main;

import main.Gui.LanternaGUI;
import main.State.MenuState;
import main.State.State;
import main.config.GameConfig;
import main.model.menu.Menu;

import java.io.IOException;


public class Game {
    private final LanternaGUI gui;
    private State state;

    private Game() throws IOException {
        this.gui = new LanternaGUI(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {

        int FPS = 60;
        int frameTime = 1000/ FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.update(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }

    public State getState() {
        return this.state;
    }
}
