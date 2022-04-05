package nl.oopd.peach.scenes;

import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.Health;
import nl.oopd.peach.entities.HealthBonus;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.Player;
import nl.oopd.peach.entities.SpecialEnemy;
import nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap.GroundTileMap;
import nl.oopd.peach.entities.buttons.PauseButton;

public class GameLevel extends DynamicScene implements TileMapContainer, Health {
    private Peach peach;
    static boolean gameWon = false;
    public Player princessPeach;
    int newHealth = 25;
    

    public ArrayList<HealthBonus> healthFood = new ArrayList<>();

    private final int PAUSESCREEN = 3;
    
    private int buttonSize = 30;
    private final int GAP = 100;
    private final int NORMALENEMYPOS = 100;
    private final int SPECIALENEMYPOS = 150;

    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_Background.png";
    private final String GAMESCENE_MUSIC = "audio/GameScene_music.mp3";
    private final String HEALTH_FOOD = "images/health.png";
    public int health;
    static int highScore;
    private final String SCORE  = "Score: ";
    static int score = 0;
    private String scoreString = String.valueOf(score);
    private final String LIVES = "Health: ";
    
    private ArrayList<TextEntity> texts = new ArrayList<>();
   
    
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
        Coordinate2D pauseBttn = new Coordinate2D(0, 0);
        Coordinate2D scoreTxt = new Coordinate2D(0 + GAP, 0);
        Coordinate2D scorePos = new Coordinate2D(0 + GAP * 2, 0);
        Coordinate2D livesTxt = new Coordinate2D(0 + GAP, buttonSize);
        Coordinate2D livesPos = new Coordinate2D(0 + GAP * 2, buttonSize);

        PauseButton pauseButton = new PauseButton(pauseBttn, peach, PAUSESCREEN, buttonSize);
        addEntity(pauseButton);

        princessPeach = new Player("images/Peach.png" ,new Coordinate2D(getWidth() / 2, getHeight() / 2 - 30), peach);
        addEntity(princessPeach);

        var goomba = new NormalEnemy("images/normal_Enemy_Two.png", new Coordinate2D(getWidth() / 2, getHeight() - NORMALENEMYPOS), new Size(125, 50), 1, 2);
        addEntity(goomba);

        var special = new SpecialEnemy("images/special_Enemy04.png", new Coordinate2D(getWidth() / 2 - 300, getHeight() - SPECIALENEMYPOS), new Size(200, 100), 1, 4);
        addEntity(special);

        var healthFood = new HealthBonus(HEALTH_FOOD, new Coordinate2D(getWidth() / 2, getHeight() / 2 - 100), new Size(100, 200));
       addEntity(healthFood);
        
        String livesString = String.valueOf(newHealth);

        texts.add(createText(scoreTxt, SCORE, FontWeight.BOLD, buttonSize, Color.WHITE));
        texts.add(createText(scorePos, scoreString, FontWeight.BOLD, buttonSize, Color.WHITE));
        texts.add(createText(livesTxt, LIVES, FontWeight.BOLD, buttonSize, Color.RED));
        texts.add(createText(livesPos, livesString, FontWeight.BOLD, buttonSize, Color.RED));
        
        for (TextEntity entity : texts) {
            addEntity(entity);
        }

        
    
            
        
    }


     @Override
    public void setupTileMaps() {
        TileMap GroundTileMap = new GroundTileMap();
        
        addTileMap(GroundTileMap);
    }


public TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
    TextEntity newtext = new TextEntity(position, text);
    newtext.setFill(textColor);
    newtext.setAnchorPoint(AnchorPoint.TOP_LEFT);
    newtext.setFont(Font.font("Roboto", font, fontSize));

    return newtext;
    }



public static boolean getGameWon() {
    return gameWon;
    
}

public static int getScore() {
    return score;
}



public static int getHighScore() {
    if (score > highScore) {
        highScore = score;
    }
    return highScore;
}

@Override
public double getWidth() {
    // TODO Auto-generated method stub
    return 0;
}

@Override
public double getHeight() {
    // TODO Auto-generated method stub
    return 0;
}

@Override
public void changeHealth(int health) {
    newHealth = health;
}
}

