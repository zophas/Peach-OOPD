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
    private int Score;
    private final int STARTSCENE = 0;
    
    private final String END_TEXT = "";
    private final String HIGH_SCORE = "High score: ";
    private final String YOUR_SCORE = "Your score: ";
    private final String BACK_BUTTON_TEXT = "Back to start";

    private final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final int titleFont = 80;
    private final int fontSize = 50;
    private final int buttonSize = 50;

    private final Font BLACK = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Black.ttf", 200);
    private final Font MEDIUM = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Medium.ttf", 100);

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
        Coordinate2D endTxt = new Coordinate2D(getWidth() / 2, getHeight() / 2 - 200);
        Coordinate2D highScoretxt = new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - 200 + titleFont);
        Coordinate2D yourScoretxt = new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - 200 + titleFont + fontSize);
        Coordinate2D restartBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Coordinate2D quitBttn = new Coordinate2D(getWidth() / 2, getHeight() / 2 + buttonSize);

        texts.add(createText(endTxt, END_TEXT, FontWeight.BOLD, titleFont, Color.HOTPINK));
        texts.add(createText(highScoretxt, HIGH_SCORE, FontWeight.MEDIUM, fontSize, Color.WHITE));
        texts.add(createText(yourScoretxt, YOUR_SCORE, FontWeight.MEDIUM, fontSize, Color.WHITE));
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
