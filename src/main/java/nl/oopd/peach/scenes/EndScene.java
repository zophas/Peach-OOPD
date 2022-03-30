package nl.oopd.peach.scenes;
import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nl.oopd.peach.Peach;

public class EndScene extends StaticScene {
    private Peach peach;
    
    private final String END_TEXT = "";
    private final String HIGH_SCORE = "High score: ";
    private final String YOUR_SCORE = "Your score: ";
    private final String BACK_BUTTON_TEXT = "Back to start";

    private final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private int titleFont = 80;

    private final Font BLACK = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Black.ttf", 200);
    private final Font MEDIUM = Font.loadFont("file:nl/oopd/peach/resources/fonts/Montserrat-Medium.ttf", 100);

    private ArrayList<TextEntity> texts = new ArrayList<>();


    public EndScene(Peach peach) {
        this.peach = peach;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(STARTSCENE_BACKGROUND);
        setBackgroundAudio(STARTSCENE_MUSIC);    
    }

    @Override
    public void setupEntities() {
        // TODO Auto-generated method stub
        
    }

    TextEntity createText(Coordinate2D position, String tekst, Font font, Color kleur) {
        TextEntity text = new TextEntity(position, tekst);
        text.setFill(kleur);
        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFont(font);

        return text;
    }
}
