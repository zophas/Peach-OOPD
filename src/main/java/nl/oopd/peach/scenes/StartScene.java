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
import nl.oopd.peach.entities.buttons.Button;
import nl.oopd.peach.entities.buttons.StartButton;

public class StartScene extends StaticScene {
    private Peach peach;

    private final String TITLE_TEXT = "PEACH";
    private final String TITLE_SUBTEXT = "A Mario sequel";
    private final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private final int TITLE_SIZE = 80, SUBTEXT_SIZE = 45, DEVIDER = 2, SPACING  = 200;

    private ArrayList<TextEntity> texts = new ArrayList<>();

    public StartScene(Peach peach){
        this.peach = peach;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(STARTSCENE_BACKGROUND);
        setBackgroundAudio(STARTSCENE_MUSIC);
    }

    @Override
    public void setupEntities() {
        Coordinate2D title = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER - SPACING);
        Coordinate2D subtext = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER - SPACING + TITLE_SIZE);
        Coordinate2D startButtonPos = new Coordinate2D(getWidth() / DEVIDER, getHeight() / DEVIDER);

        texts.add(createText(title, TITLE_TEXT, FontWeight.BOLD, TITLE_SIZE, Color.HOTPINK));
        texts.add(createText(subtext, TITLE_SUBTEXT, FontWeight.MEDIUM, SUBTEXT_SIZE, Color.WHITE));

        for(TextEntity entity : texts) {
            addEntity(entity);
        }

        Button startButton = new StartButton(startButtonPos, peach, peach.GAMESCENE);
        addEntity(startButton);
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
