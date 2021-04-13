package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.items.Usable;

public class Use implements Action {
    private Actor actor;
    private Actor actuator;

    public Use(Actor actor, Actor actuator) {
        this.actor= actor;
        this.actuator = actuator;

    }

    @Override
    public void execute() {
        if(actor instanceof Usable){
            ((Usable)actor).useBy(actuator);
        }
        if(actor instanceof Openable){
            if (((Openable)actor).isOpen() == false) {
                ((Openable)actor).open();
            } else {
                ((Openable)actor).close();
            }
        }


    }
}