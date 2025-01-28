public class Alien extends Player{

    private String race;
    private String specialAbility;

    public Alien(String name, int health, String race, String specialAbility) {
        super(name, health);
        this.race = race;
        this.specialAbility = specialAbility;
    }

    @Override
    public void useAbility() {
        System.out.println(name + " use alien ability: " + specialAbility);
    }

    public void regenerate(int amount) {
        this.health += amount;
        System.out.println(name + " regenerates " + amount + " health. Total health: " + health);
    }

    public void mutate() {
        System.out.println(name + " mutates into a stronger form!");
        // Implement mutation logic here (e.g., increasing health or abilities)
    }
}
