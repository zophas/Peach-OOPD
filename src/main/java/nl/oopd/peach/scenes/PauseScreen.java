package nl.oopd.peach.scenes;

import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.GiveUpButton;
import nl.oopd.peach.entities.buttons.PauseButton;
import nl.oopd.peach.entities.buttons.QuitButton;
import nl.oopd.peach.entities.buttons.ResumeButton;

public class PauseScreen extends StaticScene {
    private Peach peach;
    private int buttonSize = 50;
    private int fontSize = 50;
    private int titleFont = 90;
    private final int GAMESCENE = 1;
    private final int STARTSCENE = 0;
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final String TITLE_TEXT = "Pause";
    private final String SCORE = "Score: ";
    private int score = GameLevel.getScore();
    String scoreString = String.valueOf(score);
    
    private ArrayList<TextEntity> texts = new ArrayList<>();

    public PauseScreen(Peach peach) {
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
        Coordinate2D scoreNmr = new Coordinate2D(getWidth() / 2 + 100, getHeight() / 2 - 100);
        Coordinate2D resumeBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Coordinate2D giveUpBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100);
        Coordinate2D quitBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200);

        texts.add(createText(score, SCORE, FontWeight.BOLD, fontSize, Color.WHITE));
        texts.add(createText(scoreNmr, scoreString, FontWeight.BOLD, fontSize, Color.WHITE));
        texts.add(createText(title, TITLE_TEXT, FontWeight.BOLD, titleFont, Color.HOTPINK));
        for (TextEntity entity : texts) {
            addEntity(entity);
        }

        ResumeButton resumeButton = new ResumeButton(resumeBttn, peach, GAMESCENE, buttonSize);
        addEntity(resumeButton);

        GiveUpButton giveUpButton = new GiveUpButton(giveUpBttn, peach, STARTSCENE, buttonSize);
        addEntity(giveUpButton);

        QuitButton quitButton = new QuitButton(quitBttn, peach, buttonSize);
        addEntity(quitButton);
    }

    TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
        TextEntity newtext = new TextEntity(position, text);
        newtext.setFill(textColor);
        newtext.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        newtext.setFont(Font.font("Roboto", font, fontSize));

        return newtext;
    }
    
    
}
