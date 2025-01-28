import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Environment environment = new Environment();

        System.out.println("Welcome to the Game!");

        // Create Players
        Human human = new Human("Miguel", 100, 10, "Fire Wave");
        Alien alien = new Alien("Zorg", 120, "Martian", "Plasma Blast");

        // Add Players to the Environment
        environment.addPlayer(human);
        environment.addPlayer(alien);

        System.out.println("\n--- Game Setup ---");
        environment.listPlayers();

        // Game Loop
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\n--- Game Menu ---");
            System.out.println("1. List Players");
            System.out.println("2. Attack");
            System.out.println("3. Use Ability");
            System.out.println("4. Exit Game");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // List all players in the environment
                    environment.listPlayers();
                    break;
                case 2:
                    // Perform an attack
                    System.out.println("Who will attack? (1: Human, 2: Alien): ");
                    int attackerChoice = scanner.nextInt();
                    while (attackerChoice != 1 && attackerChoice != 2) {
                        System.out.println("Invalid choice. Please enter 1 (Human) or 2 (Alien): ");
                        attackerChoice = scanner.nextInt();
                    }
                    Player attacker = (attackerChoice == 1) ? human : alien;

                    System.out.println("Who will be attacked? (1: Human, 2: Alien): ");
                    int targetChoice = scanner.nextInt();
                    while (targetChoice != 1 && targetChoice != 2) {
                        System.out.println("Invalid choice. Please enter 1 (Human) or 2 (Alien): ");
                        targetChoice = scanner.nextInt();
                    }
                    Player target = (targetChoice == 1) ? human : alien;

                    if (attacker != target) {
                        System.out.print("Enter damage amount: ");
                        int damage = scanner.nextInt();
                        environment.attack(attacker, target, damage);
                        gameRunning = checkWinConditions(human, alien); // Check if the game should end
                    } else {
                        System.out.println("A player cannot attack themselves!");
                    }
                    break;
                case 3:
                    // Use an ability
                    System.out.println("Who will use their ability? (1: Human, 2: Alien): ");
                    int abilityChoice = scanner.nextInt();
                    while (abilityChoice != 1 && abilityChoice != 2) {
                        System.out.println("Invalid choice. Please enter 1 (Human) or 2 (Alien): ");
                        abilityChoice = scanner.nextInt();
                    }
                    Player abilityUser = (abilityChoice == 1) ? human : alien;

                    System.out.println("Who is the target? (1: Human, 2: Alien): ");
                    int abilityTargetChoice = scanner.nextInt();
                    Player abilityTarget = (abilityTargetChoice == 1) ? human : alien;

                    if (abilityUser != abilityTarget) {
                        environment.useAbility(abilityUser, abilityTarget);
                        gameRunning = checkWinConditions(human, alien); // Check if the game should end
                    } else {
                        System.out.println("A player cannot use their ability on themselves!");
                    }
                    break;
                case 4:
                    // Exit the game
                    System.out.println("Exiting the game. Thank you for playing!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Method to check win/lose conditions
    private static boolean checkWinConditions(Human human, Alien alien) {
        if (human.getHealth() <= 0) {
            System.out.println("Game Over! Zorg (Alien) wins!");
            return false; // End the game
        } else if (alien.getHealth() <= 0) {
            System.out.println("Game Over! Miguel (Human) wins!");
            return false; // End the game
        }
        return true; // Continue the game}
    }
}

