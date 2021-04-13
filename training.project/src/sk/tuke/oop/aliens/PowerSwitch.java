package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class PowerSwitch extends AbstractActor {
    private Switchable device;

    public PowerSwitch(Switchable device){
        setAnimation(new Animation("images/switch.png", 16, 16, 10));
        this.device = device;
    }

    public void switchOn(){
        if(device != null) {
            this.device.turnOn();
        }
    }

    public void switchOff(){
        if(device != null) {
            this.device.turnOff();
        }
    }
}



