package sk.tuke.oop.game.actors.weapons;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.AbstractActor;

import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.Enemy;


public class Bullet extends AbstractActor implements Fireable {
    private Animation animation;
    private Bullet(String name) {
        super("Bullet");
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public Animation getAnimation() {
        return null;
    }

    @Override
    public void setAnimation(Animation animation) {

    }

    @Override
    public void act() {

    }

    @Override
    public boolean intersects(Actor actor) {
        return false;
    }

    @Override
    public void addedToWorld(World world) {

    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setDirection(int angle) {
        
    }

/*
    public void setDirection(int angle) {

    }
*/
}