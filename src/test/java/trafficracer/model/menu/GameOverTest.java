package trafficracer.model.menu;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverTest {
    private GameOver gameOver;

    @BeforeEach
    void setup() {
        gameOver = new GameOver(0, 154);
    }

    @Test
    void testGetReasonSize() {
        assertEquals(3, gameOver.getReasonsSize());
    }

    @Test
    void testGetScore() {
        assertEquals(154, gameOver.getScore());
    }

    @Property
    void testGetReason(@ForAll @IntRange(min = 0, max = 2) int reason) {
        gameOver = new GameOver(reason, 154);

        if (reason == 0) {
            assertEquals("You Quit", gameOver.getReason());
        }
        else if (reason == 1) {
            assertEquals("Ran out of fuel", gameOver.getReason());
        }
        else {
            assertEquals("Collided with another car", gameOver.getReason());
        }
    }
}
