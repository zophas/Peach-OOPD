package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.QuitButton;
import nl.oopd.peach.entities.buttons.StartButton;

import java.util.ArrayList;

public class StartScene extends StaticScene {
    private Peach peach;
    private final int GAMESCENE = 1;

    private final String TITLE_TEXT = "PEACH";
    private final String TITLE_SUBTEXT = "A Mario sequel";
    private final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final int titleFont = 80;

    //public CustomFont BLACK = new CustomFont("file:nl/oopd/peach/resources/fonts/Montserrat-Black.ttf", 200);
    //private final Font MEDIUM = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Medium.ttf", 100);

    public StartScene(Peach peach){
        this.peach = peach;
    }


    private ArrayList<TextEntity> texts = new ArrayList<>();

    @Override
    public void setupScene() {
        setBackgroundImage(STARTSCENE_BACKGROUND);
        setBackgroundAudio(STARTSCENE_MUSIC);
    }

    @Override
    public void setupEntities() {
        Coordinate2D title = new Coordinate2D(getWidth() / 2, getHeight() / 2 - 200);
        Coordinate2D subtext = new Coordinate2D(getWidth() / 2, getHeight() / 2 - 200 + titleFont);
        Coordinate2D startButtonPos = new Coordinate2D(getWidth() / 2, getHeight() / 2);

        texts.add(createText(title, TITLE_TEXT, FontWeight.BOLD, 75, Color.HOTPINK));
        texts.add(createText(subtext, TITLE_SUBTEXT, FontWeight.MEDIUM, 40, Color.WHITE));

        for(TextEntity entity : texts) {
            addEntity(entity);
        }

        StartButton startButton = new StartButton(startButtonPos, peach, GAMESCENE);
        addEntity(startButton);
    }

    TextEntity createText(Coordinate2D position, String text, FontWeight font, int fontSize, Color textColor) {
        TextEntity newtext = new TextEntity(position, text);
        newtext.setFill(textColor);
        newtext.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        newtext.setFont(Font.font("Roboto", font, fontSize));

        return newtext;
    }
}
