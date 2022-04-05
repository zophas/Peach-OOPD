package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class NormalEnemy extends DynamicSpriteEntity implements IBehaviour,SceneBorderCrossingWatcher {

    private int score, health;
    private Size enemySize;

 
    public NormalEnemy(String resource, Coordinate2D location, int score, Size enemySize, int rows, int columns) {
        super(resource, location, enemySize, rows, columns);

        this.score = score;
        this.enemySize = enemySize;

        setMotion(3, 270d);
        setAutoCycle(180);
    }

    @Override
    public void doDamage(){

    }

    @Override
    public void isDying() {
        if(health == 0){
            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }

    @Override
    public void onCollision(Collider collider) {
    }
}



