package nl.oopd.peach;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.oopd.peach.scenes.GameLevel;
import nl.oopd.peach.scenes.StartScene;

public class Main extends YaegerGame {

    private final String GAMETITLE = "Peach - A Mario Sequel";
    private final Size SIZE = new Size(1280, 720);

<<<<<<< Updated upstream:src/main/java/nl/oopd/peach/Main.java
=======

    //constants for scenes
    private final int START = 0;
    private final int GAME = 1;
    private final int BOSS = 2;

>>>>>>> Stashed changes:src/main/java/nl/oopd/peach/Peach.java

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
<<<<<<< Updated upstream:src/main/java/nl/oopd/peach/Main.java
        addScene(0, new StartScene());
        addScene(1, new GameLevel());
=======
        addScene(START, new StartScene(this));
        addScene(GAME, new GameLevel());
        addScene(BOSS, new BossLevel());
>>>>>>> Stashed changes:src/main/java/nl/oopd/peach/Peach.java
    }

    @Override
    public void setActiveScene(int id){
        super.setActiveScene(id);
    }
}
