package nl.oopd.peach.scenes;

import java.util.ArrayList;
import java.util.Set;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.Button;
import nl.oopd.peach.entities.buttons.GiveUpButton;
import nl.oopd.peach.entities.buttons.QuitButton;
import nl.oopd.peach.entities.buttons.ResumeButton;

public class PauseScene extends StaticScene implements KeyListener {
    private Peach peach;
    
    TextEntity scoreText;

    private int buttonSize = 50, fontSize = 50, titleFont = 90;

    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";
    private final String TITLE_TEXT = "Pause", SCORE = "Score: ";
    public int score;

    private ArrayList<TextEntity> texts = new ArrayList<>();

    public PauseScene(Peach peach) {
        this.peach = peach;
    }

    @Override   
    public void setupScene() {
        setBackgroundColor(Color.BLACK);;
       setBackgroundAudio(STARTSCENE_MUSIC);
        
    }

    @Override
    public void setupEntities() {
        Coordinate2D title = new Coordinate2D(getWidth() / 2, getHeight() / 2 - 200);
        Coordinate2D score = new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - 100);
        Coordinate2D scorePos = new Coordinate2D(getWidth() / 2 + 100, getHeight() / 2 - 100);
        Coordinate2D resumeBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Coordinate2D giveUpBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100);
        Coordinate2D quitBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200);

        texts.add(createText(score, SCORE, FontWeight.BOLD, fontSize, Color.WHITE));
        scoreText = new TextEntity(scorePos, "" + peach.princessPeach.score);
        scoreText.setFill(Color.WHITE);
        scoreText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        scoreText.setFont(Font.font("Roboto", FontWeight.BOLD, fontSize));
        addEntity(scoreText);
        
        texts.add(createText(title, TITLE_TEXT, FontWeight.BOLD, titleFont, Color.HOTPINK));
        for (TextEntity entity : texts) {
            addEntity(entity);
        }

        Button resumeButton = new ResumeButton(resumeBttn, peach, peach.GAMESCENE, buttonSize);
        addEntity(resumeButton);

        Button giveUpButton = new GiveUpButton(giveUpBttn, peach, peach.STARTSCENE, buttonSize);
        addEntity(giveUpButton);

        Button quitButton = new QuitButton(quitBttn, peach, buttonSize);
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

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.ESCAPE)) {
            peach.setActiveScene(peach.GAMESCENE);
        }
    }  
}
