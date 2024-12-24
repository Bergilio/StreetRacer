package trafficracer.model.game.element;

import trafficracer.model.game.elements.PlayerCar;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerCarTest {

    @Property
    void testSpendFuel(@ForAll int fuel) {
        PlayerCar playerCar = new PlayerCar(5, 10, 3, 4);
        playerCar.setFuel(fuel);
        playerCar.spendFuel();
        assertEquals(fuel - 1, playerCar.getFuel());
    }

    @Property
    void testIncreasePoints(@ForAll int points) {
        PlayerCar playerCar = new PlayerCar(5, 10, 3, 4);
        playerCar.setPoints(points);
        playerCar.increasePoints();
        assertEquals(1 + points, playerCar.getPoints());
    }

    @Test
    void testGetCollided() {
        PlayerCar playerCar = new PlayerCar(5, 10, 3, 4);
        assertFalse(playerCar.getCollided());

        playerCar.setCollided(true);
        assertTrue(playerCar.getCollided());
    }


}
