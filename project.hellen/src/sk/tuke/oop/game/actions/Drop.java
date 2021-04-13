package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.World;


public class Drop<A extends Actor> implements Action {
    private final World world;
    private ActorContainer<A> container;
    private int x, y;

    public Drop(ActorContainer<A> container, World world, int x, int y){
        this.container = container;
        this.world = world;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {

    }
}