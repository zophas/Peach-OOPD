package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class NormalEnemy extends DynamicSpriteEntity implements IBehaviour,SceneBorderCrossingWatcher {
  
    private Size enemySize;
    private int newXPos = 1280;
    private int newYPos = 620;

    private final double ENEMYSPEED = 3;
    private final double ENEMYDIRECTION = 270d;
    private final long ENEMYINTERVAL = 180;

    public NormalEnemy(String resource, Coordinate2D location, Size enemySize, int rows, int columns) {
        super(resource, location, enemySize, rows, columns);

        this.enemySize = enemySize;

        setMotion(ENEMYSPEED, ENEMYDIRECTION);
        setAutoCycle(ENEMYINTERVAL);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Player) {
        Coordinate2D enemyPos = new Coordinate2D(newXPos, newYPos);
        setAnchorLocation(enemyPos);
        }
    }

    @Override
    public void isDying() {
        // TODO Auto-generated method stub
        
    }
   
}



