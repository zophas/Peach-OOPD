package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.oopd.peach.Peach;

public class QuitButton extends Button{

    protected Peach peach;

    public QuitButton(Coordinate2D initialLocation,Peach peach) {
        super(initialLocation, "Quit", -1);

        this.peach = peach;
    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
      peach.quit();
    }
}
