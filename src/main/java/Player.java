public abstract class Player {
    protected String name;
    int health;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;

    }


    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(name + " takes " + damage + " damage. Health is now " + health);
    }

    public abstract void useAbility();
}
