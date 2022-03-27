package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class NormalEnemy extends DynamicSpriteEntity implements IBehaviour, SceneBorderCrossingWatcher, Collider
{

   private int score;
   private Size size;

    public NormalEnemy(String resource,Coordinate2D location, int score, Size size, int rows, int columns) {
        super(resource, location, size,rows, columns);

        this.score = score;
        this.size = size;

        setMotion(3, 270d);
    }

    @Override
    public void doDamage() {
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }
}