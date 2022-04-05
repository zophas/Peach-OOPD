package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;

public class RestartButton extends Button {
    private Peach peach;
    
    public RestartButton(Coordinate2D initialLocation, Peach peach, int scene, int buttonSize) {
        super(initialLocation, "Back to the lobby", scene);
        this.peach = peach;

        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, buttonSize));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        
    }
        
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        peach.resetGame();
        peach.setActiveScene(0);
        
    }

    
}
