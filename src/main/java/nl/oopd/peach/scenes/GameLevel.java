package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {
    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_background.jpg";
    private final String GAMESCENE_MUSIC = "audio/GameScene_music.mp3";


    @Override
    public void setupScene() {
        setBackgroundImage(GAMELEVEL_BACKGROUND);
        setBackgroundAudio(GAMESCENE_MUSIC);
    }

    @Override
    public void setupEntities() {

    }
}
