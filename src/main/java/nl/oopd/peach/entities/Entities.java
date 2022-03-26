package nl.oopd.peach.entities;

public abstract class Entities implements IBehaviour {

    int health, speed, damage, score;

    public Entities(int health, int damage, int speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public void doDamage() {
    }
}

