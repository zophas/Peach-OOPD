package nl.oopd.peach.entities;

import java.util.HashSet;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import nl.oopd.peach.Peach;
import nl.oopd.peach.scenes.GameScene;


public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, UpdateExposer, Collider, Collided {
    public final double UP = 180d;
    public final double DOWN = 360d;
    public final double LEFT = 270d;
    public final double RIGHT = 90d;
    
    public int constraintY = 720 - 127;

    public int gameWon;

    GameScene currentroom;
    private Peach peach;
    public int health, score;
    private final int GAMEWON = 25;
   
    private final int HEALTHREMOVENORMALENEMY = 5, SCORENENEMY = 1, HEALTHREMOVESPECIALENEMY = 10, SCORESPECIALENEMY = 3, HEALTHBONUSFOOD = 10, SCOREPENALTYFOOD = 2;

    //sets the speed for the player
    private final double PLAYER_SPEED = 4;
 
    //private int attack = 1;
    static int height = 200;
    static int width = 80;
   
    public Player(String resource,Coordinate2D location, Peach peach) {
        super(resource, location, new Size(width, height), 1, 4);
        this.peach = peach;

        score = 0;
        health = 25;

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(PLAYER_SPEED, LEFT);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(PLAYER_SPEED, RIGHT);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(PLAYER_SPEED, UP);
            setCurrentFrameIndex(3);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(PLAYER_SPEED, DOWN);
            setCurrentFrameIndex(4);
        } else if (pressedKeys.contains(KeyCode.ESCAPE)) {
            peach.setActiveScene(peach.PAUSESCREEN);
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

    /**
     * Als score 25 is zet hij game op gewonnen en veranderd active scene naar endScene
     * @author Timoy van Balkom
     */
    public void gameWon() {
        if (score >= GAMEWON) {
            gameWon = 1;
            peach.setActiveScene(peach.ENDSCENE);
            System.out.println("check" + gameWon);
        }
    }

    /**
     * Als de health of score minder dan 0 is dan zet deze functie de activescene op endScene
     * @author Timoy van Balkom
     */
    public void isDying() {
        if (health <= 0) {
            peach.setActiveScene(peach.ENDSCENE);
            gameWon = 0;
        } 

        if (score < 0) {
            peach.setActiveScene(peach.ENDSCENE);
            gameWon = 0;
        }
    }

    enum Side {
        BOTTOM
    }

    /**
     * Zet de locatie van de anchorpoint naar constraint wanneer de boundary geraakt is.
     * @author Amy Dorland
     */

    public void groundBoundary() {
        Set<Side> touchingSide = touchingBottom();
        if(touchingSide.contains(Side.BOTTOM)) {
            setAnchorLocationY(constraintY);
        }
    }

    /**
     * Controleert of constraintY groter is dan de anchorlocation
     * Als dat zo is, wordt bottom toegevoegd aan de set sides.
     * @return
     * @author Amy Dorland
     */

    private Set<Side> touchingBottom() {
        Set<Side> sides = new HashSet<>();

        if(getAnchorLocation().getY() >= constraintY) {
            sides.add(Side.BOTTOM);
        }

        return sides;
    }

    @Override
    public void onCollision(Collider collider) {
        var playerHurt = new SoundClip("audio/player_hurt.mp3");
        var playerHealth = new SoundClip("audio/Healthbonus_sound.mp3");
        
        if(collider instanceof NormalEnemy){
            health -= HEALTHREMOVENORMALENEMY;
            score += SCORENENEMY;
            playerHurt.play();
        } else if(collider instanceof SpecialEnemy){
            health -= HEALTHREMOVESPECIALENEMY;
            score += SCORESPECIALENEMY;
            playerHurt.play();
        } else if (collider instanceof HealthBonus) {
            health += HEALTHBONUSFOOD;
            score -= SCOREPENALTYFOOD;
            playerHealth.play();
        }

        currentroom.updateHealth();
        currentroom.updateScore();
        
        System.out.println("Health: " + health);
        System.out.println("Score: " + score);
        isDying();
        gameWon();
    }


    /**
     * Zet de currentroom naar de gameLevel die als parameter wordt meegegeven.
     * Hiermee kun je de gamelevel meegeven om de tekst realtime te updaten
     * @author Timoy van Balkom
     * @param gameScene
     */
    public void setCurrentRoom(GameScene gameScene) {
        currentroom = gameScene;
    }

    /**
     * Reset de score en health wanneer de game opnieuw gestart wordt.
     * @author Timoy van Balkom
     */
    public void resetGame() {
        score = 0;
        health = 25;
        gameWon = 0;
    }

    @Override
    public void explicitUpdate(long timestamp) {
        groundBoundary();
    }

}
