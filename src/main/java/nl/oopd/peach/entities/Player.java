package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements IBehaviour, KeyListener, SceneBorderTouchingWatcher, Newtonian {

    //sets the speed for the player
    private double PLAYER_SPEED = 4;

    public Player(Coordinate2D location) {
        super("images/player_character.png", location, new Size(100, 200));

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(PLAYER_SPEED, 270d);
            setCurrentFrameIndex(45);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(PLAYER_SPEED, 90d);
            setCurrentFrameIndex(45);
        } else if (pressedKeys.contains(KeyCode.SPACE)) {
            setMotion(PLAYER_SPEED, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(PLAYER_SPEED, 0d);
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
    public void doDamage() {
    }


    public void jump() {

    }
}
