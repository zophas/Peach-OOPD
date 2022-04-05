package nl.oopd.peach.entities;

import java.util.Random;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SpecialEnemy extends DynamicSpriteEntity implements IBehaviour,SceneBorderCrossingWatcher, Health {
    int newHealth;
 
    private Size enemySize;
    private int newXPos = 1280;
    private int newYPos = 580;
    private final double ENEMYSPEED = 3;
    private final double ENEMYDIRECTION = 270d;
    private final long ENEMYINTERVAL = 180;

 
    public SpecialEnemy(String resource, Coordinate2D location, Size enemySize, int rows, int columns) {
        super(resource, location, enemySize, rows, columns);

        this.enemySize = enemySize;

        setMotion(ENEMYSPEED, ENEMYDIRECTION);
        setAutoCycle(ENEMYINTERVAL);
    }

    @Override
    public void doDamage(){

    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }

    @Override
    public void onCollision(Collider collider) {
        Coordinate2D enemyPos = new Coordinate2D(newXPos, newYPos);
        var playerSound = new SoundClip("audio/player_hurt.mp3");

        setAnchorLocation(enemyPos);
        System.out.println("You Collided with enemy!");
        playerSound.play();

        newHealth-= 10;
        //remove();
    }

    @Override
    public void isDying() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void changeHealth(int health) {
        newHealth = health;
        
    }
}

