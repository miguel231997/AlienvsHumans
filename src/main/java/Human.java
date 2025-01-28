public class Human extends Player{

    private int armor;
    private String specialSkill;

    public Human(String name, int health, int armor, String specialSkill) {
        super(name, health);
        this.armor = armor;
        this.specialSkill = specialSkill;
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(0, damage - armor);
        super.takeDamage(reducedDamage);
        System.out.print(name + " reduces damage by " + armor + " using armor.");

    }

    @Override
    public void useAbility() {
        System.out.println(name + " uses special skill: " + specialSkill);
    }

    public void eatFood(String food) {
        System.out.println(name + " eats " + food + " and gains a buff.");
    }
}
