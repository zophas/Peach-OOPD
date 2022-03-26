package nl.oopd.peach;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.oopd.peach.scenes.GameLevel;
import nl.oopd.peach.scenes.StartScene;

public class Main extends YaegerGame {

    private final String GAMETITLE = "Peach - A Mario Sequel";
    private final Size SIZE = new Size(1280, 720);


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
        addScene(0, new StartScene());
        addScene(1, new GameLevel());
    }

    @Override
    public void setActiveScene(int id){
        super.setActiveScene(id);
    }
}
