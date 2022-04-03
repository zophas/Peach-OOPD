package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.Player;
import nl.oopd.peach.entities.SpecialEnemy;
import nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap.GroundTileMap;

public class GameLevel extends DynamicScene implements TileMapContainer {

    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_Background.png";
    private final String GAMESCENE_MUSIC = "audio/GameScene_music.mp3";
    private Peach peach;

    public GameLevel(Peach peach){
        this.peach = peach;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(GAMELEVEL_BACKGROUND);
        setBackgroundAudio(GAMESCENE_MUSIC);
    }

    @Override
    public void setupEntities() {
        var princessPeach = new Player("images/Peach.png" ,new Coordinate2D(getWidth() / 2, getHeight() / 2 - 30));
        addEntity(princessPeach);

        var goomba = new NormalEnemy("images/normal_Enemy_Two.png", new Coordinate2D(getWidth() / 2, 675), 1, new Size(125, 50), 1, 2);
        addEntity(goomba);

        var special = new SpecialEnemy("images/special_Enemy04.png", new Coordinate2D(getWidth() / 2 - 100, 630), 3, new Size(200, 100), 1, 4);
        addEntity(special);

    }


     @Override
    public void setupTileMaps() {
        TileMap GroundTileMap = new GroundTileMap();
        
        addTileMap(GroundTileMap);
    }
}

