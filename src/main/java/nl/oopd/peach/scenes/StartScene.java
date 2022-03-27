package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class StartScene extends StaticScene {

    private final String TITLE_TEXT = "PEACH";
    private final String TITLE_SUBTEXT = "A Mario sequel";
    private final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private int titleFont = 80;

    private final Font BLACK = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Black.ttf", 200);
    private final Font MEDIUM = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Medium.ttf", 100);


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

        texts.add(createText(title, TITLE_TEXT, BLACK , Color.HOTPINK));
        texts.add(createText(subtext, TITLE_SUBTEXT, MEDIUM, Color.WHITE));

        for(TextEntity entity : texts) {
            addEntity(entity);
        }
    }

    TextEntity createText(Coordinate2D position, String tekst, Font font, Color kleur) {
        TextEntity text = new TextEntity(position, tekst);
        text.setFill(kleur);
        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFont(font);

        return text;
    }
}
