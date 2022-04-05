package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.BossEnemy;
import nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap.GrassTileMap;
import nl.oopd.peach.entities.Player;


public class BossLevel extends DynamicScene implements TileMapContainer {
    private final String BOSSLEVEL_BACKGROUND = "images/BossLevel_background.png";
    private final String BOSSLEVEL_MUSIC = "audio/BossFight_music.mp3";
    private Peach peach;

    public BossLevel(Peach peach){
        this.peach = peach;
    }


    @Override
    public void setupScene() {
        setBackgroundImage(BOSSLEVEL_BACKGROUND);
        setBackgroundAudio(BOSSLEVEL_MUSIC);

    }

    @Override
    public void setupEntities() {
        var guven = new BossEnemy("images/boss_Enemy.png", new Coordinate2D(getWidth() / 2 , getHeight() - 200), new Size(300, 150), 5, 4);
        addEntity(guven);

        var princessPeach = new Player("images/Peach.png" ,new Coordinate2D(getWidth() / 2, getHeight() / 2 - 30), peach);
        addEntity(princessPeach);
    }

    @Override
    public void setupTileMaps() {
        TileMap GrassTileMap = new GrassTileMap();

        addTileMap(GrassTileMap);
    }
}
