package sk.tuke.oop.aliens;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

public class EmpBomb extends TimeBomb {
    private Animation bomb;
    private Animation bombActiv;
    private Animation smallExplosion;
    private int time33;

    public EmpBomb(int time) {
        super(time);
        bomb = new Animation("resources/images/bomb.png", 16, 16, 10);
        bomb.setPingPong(false);
        bombActiv = new Animation("resources/images/bomb_activated.png", 16, 16, 100);
        bombActiv.setPingPong(true);
        smallExplosion = new Animation("resources/images/small_explosion.png", 16, 16, 50);
        time33=time+50;
        act();
    }

    public void act(){
        if (super.isActivated()){
            time33=time33-1;
            if (time33>50){
                setAnimation(bombActiv);
            } else {
                for (Actor switchable : getWorld()){
                    if (switchable instanceof Switchable && this.intersects(switchable)){
                        ((Switchable) switchable).turnOff();
                    }
                }
                setAnimation(smallExplosion);}
        }else{
            setAnimation(bomb);}
        if (time33==1)
            getWorld().removeActor(this);
    }
}
