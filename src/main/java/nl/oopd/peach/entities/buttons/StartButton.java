package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.oopd.peach.Peach;

public class StartButton extends TextEntity implements MouseButtonPressedListener,MouseEnterListener, MouseExitListener {

    private Peach peach;

    public StartButton(final Coordinate2D initialLocation,final Peach peach, final String text) {
        super(initialLocation, text);
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));

        this.peach = peach;
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        peach.setActiveScene(1);
    }
}

