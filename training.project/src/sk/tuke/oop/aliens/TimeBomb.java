package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class TimeBomb extends AbstractActor {
    private Animation bombOn;
    private Animation smallExplosion;
    private boolean isOn;
    private int time;
    private int time33;

    public TimeBomb(int timee){
        isOn = false;
        time = timee;
        time33 = 45;

        Animation bomb = new Animation("images/bomb.png", 16, 16, 100);
        bombOn = new Animation("images/bomb_activated.png", 16, 16, 60);
        smallExplosion =  new Animation("images/small_explosion.png", 16, 16, 100);

        setAnimation(bomb);
    }

    public void activate(){
        isOn = true;
        setAnimation(bombOn);
    }

    public boolean isActivated(){
        return isOn;
    }

    public int getTime(){
        return time;
    }

    @Override
    public void act() {
        if (!isActivated()){
            return;
        }
        if(time == 0){
            setAnimation(smallExplosion);
            time33--;
            if(time33 == 0){
                this.getWorld().removeActor(this);
            }
        }
        else if (isActivated()) {
            time--;
            super.act();
        }
    }
}