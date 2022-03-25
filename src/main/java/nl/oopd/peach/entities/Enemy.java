public class Enemy implements IEntities {
    int health, speed, damage, score;

    public Enemy(int health, int damage, int speed, int score) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.score = score;
    }


}