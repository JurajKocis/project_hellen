package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.game.actors.Movable;

public interface Fireable extends Movable
{
    void setDirection(int angle);
}
