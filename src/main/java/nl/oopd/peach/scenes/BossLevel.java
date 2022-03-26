package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class BossLevel extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundImage("images/GameLevel_background.jpg");
        setBackgroundAudio("audio/BossFight_music.mp3");

    }

    @Override
    public void setupEntities() {

    }
}
