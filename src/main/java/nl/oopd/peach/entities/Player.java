public class Player {
    int health, speed, damage;

    public Player(int health, int speed, int damage) {
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    void doDamage(){};
}