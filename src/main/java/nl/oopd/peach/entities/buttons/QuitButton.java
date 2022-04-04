package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;

public class QuitButton extends Button{

    protected Peach peach;

    public QuitButton(Coordinate2D initialLocation,Peach peach, int buttonSize) {
        super(initialLocation, "Quit", -1);

        this.peach = peach;

        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, buttonSize));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
      peach.quit();
    }
}
