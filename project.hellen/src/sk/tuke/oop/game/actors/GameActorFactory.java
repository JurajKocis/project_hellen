package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.ripley.Ripley;


public class GameActorFactory implements ActorFactory {
    @Override
    public Actor create(String type, String name) {
        switch(name){
            case  "Ripley":
                return new Ripley();
            default: return null;
        }

    }
}

