package nl.oopd.peach.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import nl.oopd.peach.Peach;



public class Player extends DynamicSpriteEntity implements IBehaviour, KeyListener, SceneBorderTouchingWatcher, Newtonian, Health {    
    private Peach peach;
    public int health = Health.health;
    //sets the speed for the player
    private final double PLAYER_SPEED = 4;
 
    private int attack = 1;
    static int height = 200;
    static int width = 80;
   
    public Player(String resource,Coordinate2D location, Peach peach) {
        super(resource, location, new Size(width, height), 1, 4);
        this.peach = peach;
      

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
            setMotion(PLAYER_SPEED, 270d);
            setCurrentFrameIndex(1);

        } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
            setMotion(PLAYER_SPEED, 90d);
            setCurrentFrameIndex(2);

        } else if (pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.SPACE) || pressedKeys.contains(KeyCode.W)) {

            setMotion(PLAYER_SPEED, 180d);
            setCurrentFrameIndex(3);

        } else if (pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)) {
            setMotion(PLAYER_SPEED, 360d);
            setCurrentFrameIndex(4);

   


        } else if (pressedKeys.isEmpty()) {
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
       
        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void isDying() {
        if (health <= 0) {
            peach.setActiveScene(4);
        }
    }

    @Override
    public void onCollision(Collider collider) {

        // var playerSound = new SoundClip("audio/player_hurt.mp3");

        // setAnchorLocation(new Coordinate2D(
        //         new Random().nextInt((int)(getSceneWidth() - getWidth())),
        //         new Random().nextInt((int)(getSceneHeight() - getHeight()))
        // ));
        // System.out.println("You Collided!");
        // System.out.println("Health: " + health);
        // playerSound.play();

        // health-= 5;
        System.out.println("Health: " + health);
        isDying();
    }

    // public static int getHealth() {
    //     return health;
    // }

    @Override
    public void doDamage() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void changeHealth(int health) {
        // TODO Auto-generated method stub
        
    }

  


}
