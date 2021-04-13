package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;

public class Dying implements RipleyState {
    private int energy;
    private Ripley ripley;
    private Input input;

    public Dying(Ripley ripley){
        this.ripley=ripley;
        ripley.setAnimation(new Animation("sprites/player_die.png", 32, 32, 100));
        ripley.getAnimation().setPingPong(true);
    }
    public void act() {
        input = Input.getInstance();
        ripley.getAnimation().start();
        escape();
        System.out.println(ripley);
    }

    public void escape(){
        Input input = Input.getInstance();
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
    }

    @Override
    public void act(int y, int x) {
        
    }
}
