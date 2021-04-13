package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.Backpack;

public class Shift <A extends Actor> implements Action {
    private ActorContainer<?> container;
    public Shift(ActorContainer<A> container){
        this.container=container;
    }

    public Shift(Backpack backpack, World world) {
    }

    @Override
    public void execute() {
        container.shiftContent();
    }
}