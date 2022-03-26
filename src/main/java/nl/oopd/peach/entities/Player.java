package nl.oopd.peach.entities;

import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.Node;

import java.util.Optional;

public class Player extends Entities {


    public Player(int health, int speed, int damage) {
        super(health,speed, damage);
    }

    @Override
    public void doDamage(){

    }
}
