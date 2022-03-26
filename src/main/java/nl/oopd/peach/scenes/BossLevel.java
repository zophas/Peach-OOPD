package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;

public class BossLevel extends DynamicScene {
    private final String BOSSLEVEL_BACKGROUND = "images/BossLevel_background.jpg";
    private final String BOSSLEVEL_MUSIC = "audio/BossFight_music.mp3";


    @Override
    public void setupScene() {
        setBackgroundImage(BOSSLEVEL_BACKGROUND);
        setBackgroundAudio(BOSSLEVEL_MUSIC);

    }

    @Override
    public void setupEntities() {

    }
}
