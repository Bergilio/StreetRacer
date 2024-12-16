package main.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver extends DefaultMenu{
    private final List<String> reasons;
    private final int reasonNumber;
    private final int score;

    public GameOver(int reasonNumber, int score) {
        super("Game Over", Arrays.asList("Try again", "Go to Menu", "Quit"), 0);

        this.reasons = new ArrayList<>(Arrays.asList("You Quit", "Ran out of fuel", "Collided with another car"));
        this.reasonNumber = reasonNumber;
        this.score = score;
    }

    public int getReasonsSize() {
        return this.reasons.size();
    }

    public String getReason() {
        return this.reasons.get(this.reasonNumber);
    }

    public int getScore() {
        return this.score;
    }
}
