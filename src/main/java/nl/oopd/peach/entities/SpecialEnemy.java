package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SpecialEnemy extends NormalEnemy implements IBehaviour{

    private final double specialEnemySpeed = 3.5;
    private final double specialEnemyDirection = 270;
    private final long specialEnemyFPS = 120;

    public SpecialEnemy(String resource,Coordinate2D location,int score, Size specialEnemySize, int rows, int columns) {
        super(resource,location, score,specialEnemySize, rows, columns);

        setMotion(specialEnemySpeed, specialEnemyDirection);
        setAutoCycle(specialEnemyFPS);
    }
   
}
