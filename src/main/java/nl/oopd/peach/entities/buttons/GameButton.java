package nl.oopd.peach.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;


public class GameButton extends TextEntity {

    public GameButton(final Coordinate2D initialLocation, final String text) {
        super(initialLocation, text);
    }
}