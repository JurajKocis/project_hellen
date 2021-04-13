package sk.tuke.oop.game.actions;

import sk.tuke.oop.game.actors.Armed;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.actors.weapons.Bullet;

public class Fire implements Action {

    private final Armed armed;

    public Fire(Armed armed){
        this.armed = armed;
    }

    @Override
    public void execute() {
    }
}