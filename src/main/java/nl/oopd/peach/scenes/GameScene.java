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
import nl.oopd.peach.entities.HealthBonus;
import nl.oopd.peach.entities.NormalEnemy;
import nl.oopd.peach.entities.SpecialEnemy;
import nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap.GroundTileMap;
import nl.oopd.peach.entities.buttons.PauseButton;

public class GameScene extends DynamicScene implements TileMapContainer {
    private Peach peach;
    TextEntity healthText, scoreText;
   
    public int score, health;

    public ArrayList<HealthBonus> healthFood = new ArrayList<>();
    
    private int buttonSize = 30;

    private final int NORMALENEMYPOS = 100, SPECIALENEMYPOS = 150, NORMALENEMYHEIGHT = 50, NORMALENEMYWIDTH = 125, SPECIALENEMYHEIGHT = 100, SPECIALENEMYWIDTH = 200, HEALTHFOODHEIGHT = 200, HEALTHFOODWIDTH = 100, SPACING = 300;
    private final int GAP = 100, XPOS = 0, YPOS = 0, MULTIPLIYER = 2, DEVIDER = 2;

    private final String GAMELEVEL_BACKGROUND = "images/GameLevel_Background.png", GAMESCENE_MUSIC = "audio/GameScene_music.mp3";
    private final String HEALTH_FOOD = "images/health.png";
    
    private final String SCORE  = "Score: ", LIVES = "Health: ";
    
    private ArrayList<TextEntity> texts = new ArrayList<>();
   
    public GameScene(Peach peach){
        this.peach = peach;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(GAMELEVEL_BACKGROUND);
        setBackgroundAudio(GAMESCENE_MUSIC);
    }

    @Override
    public void setupEntities() {
        Coordinate2D pauseBttn = new Coordinate2D(XPOS, YPOS);
        Coordinate2D scoreTxt = new Coordinate2D(XPOS + GAP, YPOS);
        Coordinate2D scorePos = new Coordinate2D(XPOS + GAP * MULTIPLIYER, YPOS);
        Coordinate2D livesTxt = new Coordinate2D(XPOS+ GAP, buttonSize);
        Coordinate2D livesPos = new Coordinate2D(XPOS + GAP * MULTIPLIYER, buttonSize);

        PauseButton pauseButton = new PauseButton(pauseBttn, peach, peach.PAUSESCREEN, buttonSize);
        addEntity(pauseButton);

        peach.princessPeach.setCurrentRoom(this);
        addEntity(peach.princessPeach);

        var goomba = new NormalEnemy("images/normal_Enemy_Two.png", new Coordinate2D(getWidth() / DEVIDER, getHeight() - NORMALENEMYPOS), new Size(NORMALENEMYWIDTH, NORMALENEMYHEIGHT), 1, 2);
        addEntity(goomba);

        var special = new SpecialEnemy("images/special_Enemy04.png", new Coordinate2D(getWidth() / DEVIDER - SPACING, getHeight() - SPECIALENEMYPOS), new Size(SPECIALENEMYWIDTH, SPECIALENEMYHEIGHT), 1, 4);
        addEntity(special);

        var healthFood = new HealthBonus(HEALTH_FOOD, new Coordinate2D(getWidth() / DEVIDER - SPACING, getHeight() / DEVIDER), new Size(HEALTHFOODWIDTH, HEALTHFOODHEIGHT));
        addEntity(healthFood);

        texts.add(createText(scoreTxt, SCORE, FontWeight.BOLD, buttonSize, Color.WHITE));
        scoreText = new TextEntity(scorePos, "" + peach.princessPeach.score);
        scoreText.setFill(Color.WHITE);
        scoreText.setAnchorPoint(AnchorPoint.TOP_LEFT);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, buttonSize));
        addEntity(scoreText);

        texts.add(createText(livesTxt, LIVES, FontWeight.BOLD, buttonSize, Color.RED));
        healthText = new TextEntity(livesPos, "" + peach.princessPeach.health);
        healthText.setFill(Color.RED);
        healthText.setAnchorPoint(AnchorPoint.TOP_LEFT);
        healthText.setFont(Font.font("Roboto", FontWeight.BOLD, buttonSize));
        addEntity(healthText);
      
        for (TextEntity entity : texts) {
            addEntity(entity);
        }
    }

    @Override
    public void setupTileMaps() {
        TileMap GroundTileMap = new GroundTileMap();
        
        addTileMap(GroundTileMap);
    }

/**
 * Is de functie om de tekst te maken, zodat alle tekst hetzelfde eruit ziet en 
 * efficient kan worden toegevoegd met zo min mogelijk dubbele code.
 * @author Amy Dorland
 * @param position
 * @param text
 * @param font
 * @param fontSize
 * @param textColor
 * @return
 */
public TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
    TextEntity newtext = new TextEntity(position, text);
    newtext.setFill(textColor);
    newtext.setAnchorPoint(AnchorPoint.TOP_LEFT);
    newtext.setFont(Font.font("Roboto", font, fontSize));

    return newtext;
    }

    /**
     * Update de health realtime
     * @author Timoy van Balkom
     */
    public void updateHealth() {
        healthText.setText(" " + peach.princessPeach.health);
    }

    /**
     * Update de score realtime
     * @author Timoy van Balkom
     */
    public void updateScore() {
        scoreText.setText(" " + peach.princessPeach.score);
    }

}

