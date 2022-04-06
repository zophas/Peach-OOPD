package nl.oopd.peach.entities;

import java.util.Random;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class HealthBonus extends DynamicSpriteEntity implements IBehaviour, SceneBorderCrossingWatcher {
       
    public HealthBonus(String resource, Coordinate2D initialLocation, Size healthFoodSize) {
        super(resource, initialLocation, healthFoodSize);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Player) {
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int)(getSceneWidth() - getWidth())),
                new Random().nextInt((int)(getSceneHeight() - getHeight()))
        ));
        }
        
    }

    @Override
    public void setAnchorLocationX(double x) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAnchorLocationY(double y) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Coordinate2D getAnchorLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transferCoordinatesToNode() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setAnchorPoint(AnchorPoint anchorPoint) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AnchorPoint getAnchorPoint() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void isDying() {
        // TODO Auto-generated method stub
        
    }
   
}
