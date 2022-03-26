package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScene extends StaticScene {

    private String titleText = "PEACH";
    private String titleSubText = "A Mario sequel";

    private int titleFont = 80;

    private double titleX, titleY;
    private double subTextX, subTextY;

    @Override
    public void setupScene() {
        setBackgroundImage("images/StartScene_background.jpg");
        setBackgroundAudio("audio/StartScene_music.mp3");
    }

    @Override
    public void setupEntities() {
        titleX = getWidth() / 2;
        titleY = getHeight() / 2 - 200;

        TextEntity title = new TextEntity(new Coordinate2D(titleX, titleY),titleText);
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.HOTPINK);
        title.setFont(Font.font("Roboto", FontWeight.BLACK, titleFont));
        title.setStrokeColor(Color.BLACK);
        title.setStrokeWidth(2.5);
        addEntity(title);

        subTextX = titleX;
        subTextY = titleY + titleFont;
        TextEntity subText = new TextEntity(new Coordinate2D(subTextX, subTextY),titleSubText);
        subText.setFill(Color.WHITE);
        subText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        subText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(subText);
    }
}
