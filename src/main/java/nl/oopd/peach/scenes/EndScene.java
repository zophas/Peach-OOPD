package nl.oopd.peach.scenes;
import java.util.ArrayList;



import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.QuitButton;
import nl.oopd.peach.entities.buttons.RestartButton;

public class EndScene extends StaticScene {
    private Peach peach;

    private int score = GameLevel.getScore();
    String scoreString = String.valueOf(score);
    private int highScore = GameLevel.getHighScore();
    String highScoreString = String.valueOf(highScore);

    private boolean gameWon = GameLevel.getGameWon();

    private final int STARTSCENE = 0;
    private final int SPACING = 200;
    
    private String endText;
    private final String HIGH_SCORE = "High score: ";
    private final String YOUR_SCORE = "Your score: ";

    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final int titleFont = 80;
    private final int fontSize = 35;
    private final int buttonSize = 50;

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
        if (gameWon) {
            endText = "You won!";
        } else {
            endText = "You lost, loser";
        }
    
        Coordinate2D endTxt = new Coordinate2D(getWidth() / 2, getHeight() / 2 - SPACING);
        Coordinate2D highScoretxt = new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - SPACING + titleFont);
        Coordinate2D highScoreNmr = new Coordinate2D(getWidth() / 2 + 100, getHeight() / 2 - SPACING + titleFont);
        Coordinate2D yourScoretxt = new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - SPACING + titleFont + fontSize);
        Coordinate2D yourScoreNmr = new Coordinate2D(getWidth() / 2 + 100, getHeight() / 2 - SPACING + titleFont + fontSize);
        Coordinate2D restartBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Coordinate2D quitBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + buttonSize);

        texts.add(createText(endTxt, endText, FontWeight.BOLD, titleFont, Color.HOTPINK));
        texts.add(createText(highScoretxt, HIGH_SCORE, FontWeight.MEDIUM, fontSize, Color.WHITE));
        texts.add(createText(highScoreNmr, highScoreString, FontWeight.MEDIUM, fontSize, Color.WHITE));
        texts.add(createText(yourScoretxt, YOUR_SCORE, FontWeight.MEDIUM, fontSize, Color.WHITE));
        texts.add(createText(yourScoreNmr, scoreString, FontWeight.MEDIUM, fontSize, Color.WHITE));
        for (TextEntity entity : texts) {
            addEntity(entity);  
        }

        RestartButton restartButton = new RestartButton(restartBttn, peach, STARTSCENE, buttonSize);
        addEntity(restartButton);
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
