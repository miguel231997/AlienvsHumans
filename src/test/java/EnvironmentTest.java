import static org.junit.Assert.assertEquals; // Use JUnit 4 assertions
import org.junit.Before;
import org.junit.Test;

public class EnvironmentTest {

    private Environment environment;
    private Human human;
    private Alien alien;

    @Before
    public void setUp() {
        environment = new Environment();
        human = new Human("Miguel", 100, 10, "Fire Wave");
        alien = new Alien("Zorg", 120, "Martian", "Plasma Blast");
    }

    @Test
    public void testAddPlayers() {
        // Add players to the environment
        environment.addPlayer(human);
        environment.addPlayer(alien);

        // Check the number of players in the environment
        assertEquals(2, environment.getPlayers().size());
    }

    @Test
    public void testRemovePlayers() {
        // Add and remove players
        environment.addPlayer(human);
        environment.addPlayer(alien);
        environment.removePlayer(human);

        // Check the number of players in the environment
        assertEquals(1, environment.getPlayers().size());
    }

    @Test
    public void testAttack() {
        // Add players
        environment.addPlayer(human);
        environment.addPlayer(alien);

        // Human attacks Alien
        environment.attack(human, alien, 30);

        // Verify Alien's health after attack
        assertEquals(90, alien.getHealth());
    }

    @Test
    public void testUseAbility() {
        // Add players
        environment.addPlayer(human);
        environment.addPlayer(alien);

        // Human uses ability on Alien
        environment.useAbility(human, alien);

        // Verify Alien's health after ability (50 damage)
        assertEquals(70, alien.getHealth());
    }

    @Test
    public void testListPlayers() {
        // Add players
        environment.addPlayer(human);
        environment.addPlayer(alien);

        // Capture the list of players as a String (simulate `listPlayers` method output)
        String playersList = environment.listPlayersAsString(); // Implement a helper in Environment

        // Expected players list
        String expected = "- Miguel (Health: 100)\n- Zorg (Health: 120)\n";

        // Verify the list output
        assertEquals(expected, playersList);
    }
}