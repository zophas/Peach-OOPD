package nl.oopd.peach.scenes;
import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.QuitButton;
import nl.oopd.peach.entities.buttons.RestartButton;

public class EndScene extends StaticScene {
    private Peach peach;

    TextEntity scoreText, healthText;
   
    public int score, health;

    private final int SPACING = 200, SMALLSPACING = 100, DEVIDER = 2;
    
    private String endText;
    private final String SCORE = "Your score: ", HEALTH = "Remaining health: ";

    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final int fontSize = 35, buttonSize = 50, titleFont = 80;

    private ArrayList<TextEntity> texts = new ArrayList<>();

    public EndScene(Peach peach) {
        this.peach = peach;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
        setBackgroundAudio(STARTSCENE_MUSIC);    
    }

    @Override
    public void setupEntities() {
        if (peach.princessPeach.gameWon == 1) {
            endText = "You won!";
         } else {
             endText = "Game over"; 
         }
    
        Coordinate2D endTxt = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER - SPACING);
        Coordinate2D scoretxt = new Coordinate2D(getWidth() / DEVIDER - SMALLSPACING, getHeight() / DEVIDER - SPACING + titleFont);
        Coordinate2D scorePos = new Coordinate2D(getWidth() / DEVIDER + SMALLSPACING, getHeight() / DEVIDER - SPACING + titleFont);
        Coordinate2D healthtxt = new Coordinate2D(getWidth() / DEVIDER - SMALLSPACING, getHeight() / DEVIDER - SPACING + titleFont + fontSize);
        Coordinate2D healthPos = new Coordinate2D(getWidth() / DEVIDER + SMALLSPACING, getHeight() / DEVIDER- SPACING + titleFont + fontSize);
        Coordinate2D restartBttn = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER);
        Coordinate2D quitBttn = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER + buttonSize);

        texts.add(createText(endTxt, endText, FontWeight.BOLD, titleFont, Color.HOTPINK));
        texts.add(createText(scoretxt, SCORE, FontWeight.MEDIUM, fontSize, Color.WHITE));
        scoreText = new TextEntity(scorePos, "" + peach.princessPeach.score);
        scoreText.setFill(Color.WHITE);
        scoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, fontSize));
        addEntity(scoreText);

        texts.add(createText(healthtxt, HEALTH, FontWeight.MEDIUM, fontSize, Color.RED));
        healthText = new TextEntity(healthPos, "" + peach.princessPeach.health);
        healthText.setFill(Color.RED);
        healthText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        healthText.setFont(Font.font("Roboto", FontWeight.BOLD, fontSize));
        addEntity(healthText);

        for (TextEntity entity : texts) {
            addEntity(entity);  
        }

        RestartButton restartButton = new RestartButton(restartBttn, peach, peach.STARTSCENE, buttonSize);
        addEntity(restartButton);
        QuitButton quitButton = new QuitButton(quitBttn, peach, buttonSize);
        addEntity(quitButton);
        
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
    TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
        TextEntity newtext = new TextEntity(position, text);
        newtext.setFill(textColor);
        newtext.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        newtext.setFont(Font.font("Roboto", font, fontSize));

        return newtext;
    }

}
