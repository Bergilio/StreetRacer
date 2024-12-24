package trafficracer;

import trafficracer.gui.LanternaGUI;
import trafficracer.state.menu.MenuState;
import trafficracer.state.State;
import trafficracer.config.GameConfig;
import trafficracer.model.menu.Menu;

import java.io.IOException;


public class Game {
    private static Game instance;
    private final LanternaGUI gui;
    private State state;

    private Game() throws IOException {
        this.gui = new LanternaGUI(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
        this.state = new MenuState(new Menu());
    }

    public static Game getInstance() throws IOException {
        if (instance == null) {
            synchronized (Game.class) {
                if (instance == null) {
                    instance = new Game();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws IOException {
        Game.getInstance().start();
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
