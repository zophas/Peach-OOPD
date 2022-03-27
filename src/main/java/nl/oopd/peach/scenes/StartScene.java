package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;
import nl.oopd.peach.entities.buttons.StartButton;

public class StartScene extends StaticScene {

    private static final String STARTBUTTON_TEXT = "Play Game";
    private final String TITLE_TEXT = "PEACH";
    private final String TITLE_SUBTEXT = "A Mario sequel";

    private  final String STARTSCENE_BACKGROUND = "images/StartScene_background.jpg";
    private final String STARTSCENE_MUSIC = "audio/StartScene_music.mp3";

    private int titleFont = 80;

    private double titleX, titleY;
    private double subTextX, subTextY;

    private Peach peach;

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
        titleX = getWidth() / 2;
        titleY = getHeight() / 2 - 200;

        TextEntity title = new TextEntity(new Coordinate2D(titleX, titleY),TITLE_TEXT);
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.HOTPINK);
        title.setFont(Font.font("Roboto", FontWeight.BLACK, titleFont));
        title.setStrokeColor(Color.BLACK);
        title.setStrokeWidth(2.5);
        addEntity(title);

        subTextX = titleX;
        subTextY = titleY + titleFont;
        TextEntity subText = new TextEntity(new Coordinate2D(subTextX, subTextY),TITLE_SUBTEXT);
        subText.setFill(Color.WHITE);
        subText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        subText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(subText);

        var startbutton = new StartButton(new Coordinate2D(getWidth() / 2 - 65, getHeight() / 2), peach, STARTBUTTON_TEXT);
        addEntity(startbutton);
    }

}
