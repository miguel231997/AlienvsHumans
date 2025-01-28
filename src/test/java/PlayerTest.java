import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    class PlayerTest {

        @Test
        void testHumanPlayerAttributes() {
            Player Miguel = new Human("Miguel", 100,100, "Fire wave");
            assertEquals(100, Miguel.getHealth(), "Health should be initialized to 100.");
            assertEquals("Miguel", Miguel.getName(), "Name should be 'Miguel'.");
        }
        @Test
        void testAlienPlayerAttribute() {
            Player Goku = new Alien("Goku", 100, "Sayain", "Kamehaaa");
            assertEquals(100, Goku.getHealth());
            assertEquals("Goku", Goku.getName());
        }
}