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
import javafx.scene.text.Text;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.Player;
import nl.oopd.peach.entities.SpecialEnemy;
import nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap.GroundTileMap;
import nl.oopd.peach.entities.buttons.PauseButton;

public class GameLevel extends DynamicScene implements TileMapContainer {
    private Peach peach;

    private final int PAUSESCREEN = 3;
    
    private int buttonSize = 30;
    private final int GAP = 100;
    private final int NORMALENEMYPOS = 137;
    private final int SPECIALENEMYPOS = 187;

    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_Background.png";
    private final String GAMESCENE_MUSIC = "audio/GameScene_music.mp3";
    
    
    private final String SCORE  = "Score: ";
    public int score = 0;
    
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

        PauseButton pauseButton = new PauseButton(pauseBttn, peach, PAUSESCREEN, buttonSize);
        addEntity(pauseButton);

        texts.add(createText(scoreTxt, SCORE, FontWeight.BOLD, buttonSize, Color.WHITE));
        
        for (TextEntity entity : texts) {
            addEntity(entity);
        }

        var princessPeach = new Player("images/Peach.png" ,new Coordinate2D(getWidth() / 2, getHeight() / 2 - 30));
        addEntity(princessPeach);

        var goomba = new NormalEnemy("images/normal_Enemy_Two.png", new Coordinate2D(getWidth() / 2, getHeight() - NORMALENEMYPOS),1, new Size(125, 50), 1, 2);
        addEntity(goomba);

        var special = new SpecialEnemy("images/special_Enemy04.png", new Coordinate2D(getWidth() / 2 - 100, getHeight() - SPECIALENEMYPOS), 3, new Size(200, 100), 1, 4);
        addEntity(special);

    }


     @Override
    public void setupTileMaps() {
        TileMap GroundTileMap = new GroundTileMap();
        
        addTileMap(GroundTileMap);
    }


TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
    TextEntity newtext = new TextEntity(position, text);
    newtext.setFill(textColor);
    newtext.setAnchorPoint(AnchorPoint.TOP_LEFT);
    newtext.setFont(Font.font("Roboto", font, fontSize));

    return newtext;
    }

void createScore(Coordinate2D position, int score, FontWeight font, int fontSize, Color textColor) {
    
}
}

