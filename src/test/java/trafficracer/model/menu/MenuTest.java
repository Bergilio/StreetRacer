package trafficracer.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;
    private List<String> option;

    @BeforeEach
    void setup() {
        menu = new Menu();
        option = Arrays.asList("Start Game", "Top Scores", "Quit");
    }

    @Test
    void testMenuName() {
        assertEquals("Menu", menu.getMenuName());
    }

    @Test
    void testGetAndSetCurrentSelection() {
        int selection = menu.getCurrentSelection();
        assertEquals(0, selection);

        menu.setCurrentSelection(selection + 1);
        assertEquals(selection + 1, menu.getCurrentSelection());
    }

    @Test
    void testGetOptionSize() {
        assertEquals(3, menu.getOptionsSize());
    }

    @Test
    void testGetOption() {
        for (int i = 0; i < menu.getOptionsSize(); i++) {
            assertEquals(option.get(i), menu.getOption(i));
        }
    }
}
