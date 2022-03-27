package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.Player;

public class GameLevel extends DynamicScene {
    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_background.png";
    private final String GAMESCENE_MUSIC = "audio/GameScene_music.mp3";


    @Override
    public void setupScene() {
        setBackgroundImage(GAMELEVEL_BACKGROUND);
        setBackgroundAudio(GAMESCENE_MUSIC);
    }

    @Override
    public void setupEntities() {
            var princessPeach = new Player(new Coordinate2D(getWidth() / 2,getHeight() / 2 -30));
            addEntity(princessPeach);

            var goomba = new NormalEnemy(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 30),10);
            addEntity(goomba);
        }
    }

