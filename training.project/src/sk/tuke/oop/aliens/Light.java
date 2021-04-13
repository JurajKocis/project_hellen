package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer{
    private boolean on;
    private boolean electricity;
    private Animation lightOnAnim;
    private Animation lightOffAnim;

    public Light (){
        on = false;
        lightOnAnim = new Animation("images/light_on.png", 16, 16, 10);
        lightOffAnim = new Animation("images/light_off.png", 16, 16, 10);
        setAnimation(lightOffAnim);
    }

    public void setElectricityFlow(boolean electricity){
        this.electricity = electricity;
        if (on) setAnimation(lightOnAnim); else setAnimation(lightOffAnim);
    }

    public boolean getElectricity(){
        return electricity;
    }
    public boolean isOn() {

        return on;
    }
    public void turnOn() {
        on =true;
        if (electricity)
            setAnimation(lightOnAnim); else setAnimation(lightOffAnim);
    }
    public void turnOff() {
        on =false;
        setAnimation(lightOffAnim);
    }

    public void toggle(){
        if(on){
            on = false;
            setAnimation(lightOffAnim);}
        else {
            on = true;
            if (electricity)
                setAnimation(lightOnAnim); else setAnimation(lightOffAnim);
        }
    }
}
