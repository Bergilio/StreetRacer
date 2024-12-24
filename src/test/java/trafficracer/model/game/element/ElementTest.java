package trafficracer.model.game.element;

import trafficracer.model.Position;
import trafficracer.model.game.elements.Element;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    @Test
    void testCollisionFromTheSides() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(6, 10, 5, 5);
        Element element3 = new Element(14, 10, 5, 5);

        assertTrue(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the left
        assertTrue(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from the right
    }

    @Test
    void testCollisionFromTheTopToBelow() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(10, 6, 5, 5);
        Element element3 = new Element(10, 14, 5, 5);

        assertTrue(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the top
        assertTrue(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from below
    }

    @Test
    void testNoCollisionFromTheSides() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(2, 10, 5, 5);
        Element element3 = new Element(17, 10, 5, 5);

        assertFalse(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the left
        assertFalse(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from the right
    }

    @Test
    void testNoCollisionFromTheTopToBelow() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(10, 2, 5, 5);
        Element element3 = new Element(10, 17, 5, 5);

        assertFalse(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the top
        assertFalse(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from below
    }

    @Test
    void testSideAdjacentNoCollision() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(5, 10, 5, 5);
        Element element3 = new Element(15, 10, 5, 5);

        assertFalse(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the left
        assertFalse(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from the right
    }

    @Test
    void testTopBelowAdjacentNoCollision() {
        Element element1 = new Element(10, 10, 5, 5);
        Element element2 = new Element(10, 5, 5, 5);
        Element element3 = new Element(10, 15, 5, 5);

        assertFalse(element1.collides(element2.getPosition(), element2.getWidth(), element2.getHeight())); // tests element from the top
        assertFalse(element1.collides(element3.getPosition(), element3.getWidth(), element3.getHeight())); // tests element from below
    }


    @Property
    void testCollidesManyValues(@ForAll int x1, @ForAll int y1,
                                   @ForAll int w1, @ForAll int h1,
                                   @ForAll int x2, @ForAll int y2,
                                   @ForAll int w2, @ForAll int h2) {
        Element element1 = new Element(x1, y1, w1, h1);
        Position pos2 = new Position(x2, y2);
        boolean expected = (x1 + w1 > x2 && x1 < x2 + w2) && (y1 + h1 > y2 && y1 < y2 + h2);
        assertEquals(expected, element1.collides(pos2, w2, h2));
    }

}
