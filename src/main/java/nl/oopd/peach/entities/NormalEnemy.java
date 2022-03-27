package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class NormalEnemy extends DynamicSpriteEntity implements IBehaviour, SceneBorderCrossingWatcher {

    int score;

    public NormalEnemy(Coordinate2D location, int score) {
        super("images/normal_enemy.png", location, new Size(100,200));
        this.score = score;

        setMotion(2, 270d);
    }

    @Override
    public void doDamage() {
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}