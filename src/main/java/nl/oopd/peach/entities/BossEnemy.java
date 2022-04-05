package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
public class BossEnemy extends NormalEnemy{

 private int score;
 private Size bossSize;

   public BossEnemy(String resource,Coordinate2D location, Size bossSize, int rows, int columns) {
       super(resource,location, bossSize, rows,columns);
       this.bossSize = bossSize;

       this.score = score;
   }
 }