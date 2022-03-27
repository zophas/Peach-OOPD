package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;


public class Button extends TextEntity{

<<<<<<< Updated upstream:src/main/java/nl/oopd/peach/entities/buttons/Button.java
    public Button(Coordinate2D initialLocation) {
        super(initialLocation);
=======
    public GameButton(final Coordinate2D initialLocation,final String text)
    {
        super(initialLocation, text);
>>>>>>> Stashed changes:src/main/java/nl/oopd/peach/entities/buttons/GameButton.java
    }
}