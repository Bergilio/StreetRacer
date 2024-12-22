package trafficracer.model.menu;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficracer.model.game.road.Road;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PauseTest {

    @Test
    void testGetRoad() {
        Road mockRoad = Mockito.mock(Road.class);
        Pause pauseMenu = new Pause(mockRoad);

        assertEquals(mockRoad, pauseMenu.getRoad());
    }
}
