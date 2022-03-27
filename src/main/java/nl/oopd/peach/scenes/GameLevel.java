package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.Player;
import nl.oopd.peach.entities.SpecialEnemy;

public class GameLevel extends DynamicScene {

    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_Background.png";
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

            var goomba = new NormalEnemy("images/normal_Enemy_Two.png",new Coordinate2D(getWidth() / 2, 640),1, new Size(200,100), 1, 2);
            addEntity(goomba);

        var sunglass_Goomba = new SpecialEnemy("images/special_enemy.png",new Coordinate2D(getWidth() / 2 - 100, 640), 3, new Size(175,75), 1 , 1);
        addEntity(sunglass_Goomba);
        }
    }

