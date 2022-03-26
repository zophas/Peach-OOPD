package nl.oopd.peach.entities;

import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.Node;
import nl.oopd.peach.entities.IBehaviour;

import java.util.Optional;

public class NormalEnemy extends Entities {

    int score;

    public NormalEnemy(int health, int damage, int speed, int score) {
        super(health, damage, speed);
        this.score = score;
    }

    @Override
    public void doDamage() {

    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }
}