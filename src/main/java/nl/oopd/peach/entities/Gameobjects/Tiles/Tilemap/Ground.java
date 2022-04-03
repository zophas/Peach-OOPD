package nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;



public class Ground extends SpriteEntity {
    private Size tile;

    public Ground(Coordinate2D initialLocation, Size tile, String resource)
    {
        super(resource, initialLocation,tile);
    }
}
