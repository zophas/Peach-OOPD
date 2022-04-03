package nl.oopd.peach.entities.Gameobjects.Tiles
        ;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Fireball extends DynamicSpriteEntity {

    private final double fireballSpeed = 3.5;
    private final double fireballDirection = 360;
    private final long fireballFPS = 120;

    private Size spriteSize;
    private boolean visible;


    public Fireball(Coordinate2D initialLocation, final Size spriteSize) {
        super("images/orange_fireball.png", initialLocation, 1, 2);

        this.spriteSize = spriteSize;
        setMotion(fireballSpeed, fireballDirection);
    }
}
