import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Environment {

    private List<Player> players;

    public Environment() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        System.out.println(player.getName() + " has entered the environment.");
    }

    // Remove a player from the environment
    public void removePlayer(Player player) {
        players.remove(player);
        System.out.println(player.getName() + " has left the environment.");
    }

    public void listPlayers() {
        System.out.println("Players in the environment:");
        for (Player player : players) {
            System.out.println("- " + player.getName() + " (Health: " + player.getHealth() + ")");
        }
    }

    public void attack(Player attacker, Player target, int damage) {
        if (players.contains(attacker) && players.contains(target)) {
            System.out.println(attacker.getName() + " attacks " + target.getName() + " for " + damage + " damage.");
            target.takeDamage(damage);
        } else {
            System.out.println("Attack failed: One or both players are not in the environment.");
        }
    }

    public void useAbility(Player attacker, Player target) {
        if (players.contains(attacker) && players.contains(target)) {
            System.out.println(attacker.getName() + " uses their ability on " + target.getName() + "!");
            attacker.useAbility(); // Display attacker-specific ability message
            target.takeDamage(50); // Deal 50 damage to the target
            System.out.println(target.getName() + " now has " + target.getHealth() + " health.");
        } else {
            System.out.println("One or both players are not in the environment. Ability cannot be used.");
        }
    }

    public String listPlayersAsString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append("- ").append(player.getName())
                    .append(" (Health: ").append(player.getHealth()).append(")\n");
        }
        return sb.toString();
    }
    public Collection<Player> getPlayers() {
        return players; // Return the list of players as a collection
    }
}
