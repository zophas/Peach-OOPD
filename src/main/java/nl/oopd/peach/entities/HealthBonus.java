package nl.oopd.peach.entities;

import java.util.Random;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class HealthBonus extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided {
       
    public HealthBonus(String resource, Coordinate2D initialLocation, Size healthFoodSize) {
        super(resource, initialLocation, healthFoodSize);
        //TODO Auto-generated constructor stub
    }

    public void onCollision(Collider collider) {
        if(collider instanceof Player) {
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int)(getSceneWidth() - getWidth())),
                new Random().nextInt((int)(getSceneHeight() - getHeight()))
        ));
        }
        
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}
