package nl.oopd.peach.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScene extends StaticScene {

    private String titelTekst = "PEACH";
    private double titelX, titelY;
    private int titelFont = 80;
    private double subscriptX, subscriptY;

    @Override
    public void setupScene() {
        setBackgroundImage("images/StartScene_background.jpg");
        setBackgroundAudio("audio/StartScene_music.mp3");
    }

    @Override
    public void setupEntities() {
        titelX = getWidth() / 2;
        titelY = getHeight() / 2 - 200;

        TextEntity titel = new TextEntity(new Coordinate2D(titelX, titelY),titelTekst);
        titel.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titel.setFill(Color.HOTPINK);
        titel.setFont(Font.font("Roboto", FontWeight.BLACK, titelFont));
        titel.setStrokeColor(Color.BLACK);
        titel.setStrokeWidth(2.5);
        addEntity(titel);

        subscriptX = titelX;
        subscriptY = titelY + titelFont;
        TextEntity subscript = new TextEntity(new Coordinate2D(subscriptX, subscriptY), "A Mario sequel");
        subscript.setFill(Color.WHITE);
        subscript.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        subscript.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
        addEntity(subscript);
    }

}
