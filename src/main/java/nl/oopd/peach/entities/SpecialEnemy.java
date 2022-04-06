package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SpecialEnemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
 
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
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }

    public void onCollision(Collider collider) {

        if(collider instanceof Player) {
            Coordinate2D enemyPos = new Coordinate2D(newXPos, newYPos);
            setAnchorLocation(enemyPos);
        }
    }


}

