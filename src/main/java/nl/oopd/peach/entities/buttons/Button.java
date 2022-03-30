package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Button extends TextEntity implements MouseButtonPressedListener {
    

    public Button(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 30));
        
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        // TODO Auto-generated method stub
        
    }
    
}
