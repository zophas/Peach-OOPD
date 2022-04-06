package nl.oopd.peach;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import nl.oopd.peach.entities.Player;
//import nl.oopd.peach.scenes.BossLevel;
import nl.oopd.peach.scenes.EndScene;
import nl.oopd.peach.scenes.GameLevel;
import nl.oopd.peach.scenes.PauseScreen;
import nl.oopd.peach.scenes.StartScene;


public class Peach extends YaegerGame {

    public Player princessPeach = new Player("images/Peach.png" ,new Coordinate2D(1280 / 2, 720 / 2 - 30), this);
    
    //constants for screen size and Game Title
    private final String GAMETITLE = "Peach - A Mario Sequel";
    private final Size SIZE = new Size(1280, 720);

    //constants for scenes
    public final int STARTSCENE = 0, GAMESCENE = 1, PAUSESCREEN = 3, ENDSCENE = 4;

    
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
        addScene(STARTSCENE, new StartScene(this));
        addScene(GAMESCENE, new GameLevel(this));
        addScene(PAUSESCREEN, new PauseScreen(this));
        addScene(ENDSCENE, new EndScene(this));
    }

    @Override
    public void setActiveScene(int id){
        super.setActiveScene(id);
    }

    
}
