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

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener {

    private int scene;

    public Button(final Coordinate2D initialLocation, final String text, int scene) {
        super(initialLocation, text);
        this.scene = scene;

        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
        
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

    public int getScene() {
        return scene;
    }
}
