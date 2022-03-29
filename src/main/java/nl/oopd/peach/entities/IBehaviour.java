package nl.oopd.peach.entities;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

public interface IBehaviour extends Collider, Collided {
    public void doDamage();
}