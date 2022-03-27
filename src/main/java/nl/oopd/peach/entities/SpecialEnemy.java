package nl.oopd.peach.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SpecialEnemy extends NormalEnemy{

    public SpecialEnemy(String resource,Coordinate2D location,int score, Size size, int rows, int columns) {
        super(resource,location, score,size, rows, columns);
    }
}
