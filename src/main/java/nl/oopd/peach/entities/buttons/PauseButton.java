package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;

public class PauseButton extends Button{

    private Peach peach;

    public PauseButton(Coordinate2D initialLocation, Peach peach, int scene, int buttonSize) {
        super(initialLocation, "Pause", scene);
        this.peach = peach;

        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, buttonSize));
        setAnchorPoint(AnchorPoint.TOP_LEFT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        peach.setActiveScene(peach.PAUSESCREEN);
        
    }
    
}
