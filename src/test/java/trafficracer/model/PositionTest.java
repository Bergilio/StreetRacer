package trafficracer.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {


    @Property
    void testGetLeft(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position left = position.getLeft();
        assertEquals(x - 1, left.getX());
        assertEquals(y, left.getY());
    }

    @Property
    void testGetRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position right = position.getRight();
        assertEquals(x + 1, right.getX());
        assertEquals(y, right.getY());
    }

    @Property
    void testGetDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position down = position.getDown();
        assertEquals(x, down.getX());
        assertEquals(y + 1, down.getY());
    }

    @Property
    void testSameCoordinatesAreEqual(@ForAll int x, @ForAll int y) {
        Position position1 = new Position(x, y);
        Position position2 = new Position(x, y);
        assertTrue(position1.equals(position2) && position2.equals(position1));
    }

    @Property
    void testSamePositionIsEqual(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertTrue(position.equals(position));
    }

    @Property
    void testUnequalPositions(@ForAll int x, @ForAll int y) {
        Position position1 = new Position(x, y);
        Position position2 = new Position(x + 1, y);
        Position position3 = new Position(x, y + 1);

        assertNotEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Property
    void testEqualPositionsHaveSameHashCode(@ForAll int x, @ForAll int y) {
        Position position1 = new Position(x, y);
        Position position2 = new Position(x, y);
        assertEquals(position1.hashCode(), position2.hashCode());
    }
}
