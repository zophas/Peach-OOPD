package nl.oopd.peach;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.oopd.peach.scenes.BossLevel;
import nl.oopd.peach.scenes.GameLevel;
import nl.oopd.peach.scenes.StartScene;

public class Peach extends YaegerGame {

    //constants for screen size and Game Title
    private final String GAMETITLE = "Peach - A Mario Sequel";
    private final Size SIZE = new Size(1280, 720);

    //constants for scenes
    private final int START = 0;
    private final int GAME = 1;
    private final int BOSS = 2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle(GAMETITLE);
        setSize(SIZE);
    }

    @Override
    public void setupScenes()
    {
        addScene(START, new StartScene(this));
        addScene(GAME, new GameLevel(this));
        addScene(BOSS, new BossLevel(this));
    }

    @Override
    public void setActiveScene(int id){
        super.setActiveScene(id);
    }
}
