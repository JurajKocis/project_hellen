package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.GameActorFactory;

public class Main {

   
    public static void main(String[] args) {
        SlickWorld world =new SlickWorld("world",800,600);
        GameActorFactory actorFactory=new GameActorFactory();
        world.setFactory(actorFactory);
        world.setMap("/resources/levels/level.11.tmx");
        System.out.println("Greetings from Manager");
        world.run();
    }

    public static void scenario(){
        
    }
}
