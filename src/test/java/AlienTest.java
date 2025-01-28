import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AlienTest {
    private Alien alien;

    @Before
    public void beforeEachTest() {
        alien = new Alien("Goku", 100, "Sayain", "Kamehaaa");
    }

    @Test
    public void testAlienAttributes() {
        assertEquals("Goku", alien.getName(), "Name should be 'Goku'.");
        assertEquals(100, alien.getHealth(), "Health should be initialized to 100.");
        assertEquals("Sayain", alien.getRace(), "Race should be 'Goku'");
        assertEquals("Kamehaaa", alien.specialAbility(), "Special ability should be Kamehaa");
    }

    @Test
    public void testAlienRegenerate() {
        alien.regenerate(25);
        assertEquals(125, alien.getHealth());
    }

    @Test
    public void testAlienMutate() {
        alien.mutate(10);
        assertEquals(80, alien.getHealth());
    }
}