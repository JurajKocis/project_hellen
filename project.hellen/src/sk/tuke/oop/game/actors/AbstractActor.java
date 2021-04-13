package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

import java.util.List;

public abstract class AbstractActor implements Actor {
    private int x;
    private int y;
    private int width;
    private int height;
    private Animation animation;
    private String name;
    private World world;


    public AbstractActor(String name) {
        this.name = name;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;

    }

    @Override
    public abstract void act();

    @Override
    public boolean intersects(Actor actor) {
        if (actor.getX()<x+getWidth() && x<actor.getX()+actor.getWidth() && actor.getY()<y+getHeight() && y<actor.getY()+actor.getHeight()) {
            return true;
        }
        if(actor==null) {
            return false;
        }
        else{
            return false;
        }
    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public String getName() {
        return "Ripley";
    }

}