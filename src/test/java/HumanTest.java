import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class HumanTest {

    private Human human;

    @Before
    public void beforeEachTest() {
        human = new Human("Miguel", 100,10, "Fire wave");
    }

    @Test
    public void testHumanAttributes() {


        // Test initial attributes
        assertEquals("Miguel", human.getName(), "Name should be 'Miguel'.");
        assertEquals(100, human.getHealth(), "Health should be initialized to 100.");
        assertEquals(10, human.getArmor(), "Armor should be initialized to 10.");
        assertEquals("Fire wave", human.specialAbility(),"Special ability should be fire wave");
    }

    @Test
    public void testTakeDamage() {
        // Simulate taking damage
        human.takeDamage(20); // Armor should reduce damage by 10
        assertEquals(90, human.getHealth(), "Health should be reduced to 90 after damage.");

        human.takeDamage(5); // Damage is less than armor
        assertEquals(90, human.getHealth(), "Health should remain 90 when damage is less than armor.");
    }

    @Test
    public void testSpecialAbility() {
        // Check special ability output (optional if purely console-based)
        assertEquals("Fire wave",human.specialAbility());
    }
}