package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class BossEnemy extends DynamicCompositeEntity {

 private int score;

   public BossEnemy(Coordinate2D location, int score) {
       super(location);

       this.score = score;
   }

    @Override
    protected void setupEntities() {

    }


}