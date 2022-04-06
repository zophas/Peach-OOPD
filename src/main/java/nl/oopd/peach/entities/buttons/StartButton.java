package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;

public class StartButton extends Button {

    private Peach peach;

    public StartButton(Coordinate2D initialLocation, Peach peach, int scene) {
        super(initialLocation,"Start game", scene);

        this.peach = peach;

        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        peach.setActiveScene(peach.GAMESCENE);
    }
} 