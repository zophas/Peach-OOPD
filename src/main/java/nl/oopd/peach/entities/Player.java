package nl.oopd.peach.entities;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import nl.oopd.peach.Peach;
import nl.oopd.peach.scenes.GameLevel;
import nl.oopd.peach.scenes.GameWon;


public class Player extends DynamicSpriteEntity implements IBehaviour, KeyListener, SceneBorderTouchingWatcher, Newtonian {
    
    public int[] constraint = {

    };

    public int gameWon;

    GameLevel currentroom;
    private Peach peach;
    public int health;
    public int score;
   
    //sets the speed for the player
    private final double PLAYER_SPEED = 4;
 
    //private int attack = 1;
    static int height = 200;
    static int width = 80;
   
    public Player(String resource,Coordinate2D location, Peach peach) {
        super(resource, location, new Size(width, height), 1, 4);
        this.peach = peach;
        
        health = 25;
        score = 0;

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

    public void gameWon() {
        if (score >= 50) {
            gameWon = 1;
            peach.setActiveScene(4);
            System.out.println("check" + gameWon);
        }
    }
   

    @Override
    public void isDying() {
        if (health <= 0) {
            peach.setActiveScene(4);
        } 

        if (score < 0) {
            peach.setActiveScene(4);
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof NormalEnemy){
            health -= 5;
            score += 1;
            currentroom.updateHealth();
            currentroom.updateScore();
            System.out.println("You Collided with enemy!");
            var playerSound = new SoundClip("audio/player_hurt.mp3");
            playerSound.play();
        } else if(collider instanceof SpecialEnemy){
            health -= 10;
            score += 3;
            currentroom.updateHealth();
            currentroom.updateScore();
            System.out.println("You Collided with special enemy!");
            var playerSound = new SoundClip("audio/player_hurt.mp3");
            playerSound.play();
        } else if (collider instanceof HealthBonus) {
            health += 10;
            score -= 1;
            currentroom.updateHealth();
            currentroom.updateScore();
            var playerSound = new SoundClip("audio/player_hurt.mp3");
            playerSound.play();
            System.out.println("You got extra health!");
        }
        
        System.out.println("Health: " + health);
        System.out.println("Score: " + score);
        isDying();
        gameWon();
    }

    @Override
    public void doDamage() {
        // TODO Auto-generated method stub
        
    }


    public void setCurrentRoom(GameLevel gameLevel) {
        currentroom = gameLevel;
    }

    public void resetGame() {
        score = 0;
        health = 25;
    }

}
