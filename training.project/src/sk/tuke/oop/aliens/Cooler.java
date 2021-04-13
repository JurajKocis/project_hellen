package sk.tuke.oop.aliens;


import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Cooler extends AbstractActor implements Switchable {
    private boolean active;
    private Reactor reactor;
    private Animation coolerAnimation;


    public Cooler(Reactor reactor){
        this.reactor = reactor;
        active = false;
        coolerAnimation=new Animation("resources/images/fan.png",32 , 32, 200);
        coolerAnimation.setLooping(false);
        setAnimation(coolerAnimation);
    }

    public void turnOn(){
        this.active = true;
        coolerAnimation.stop();
        coolerAnimation.setLooping(true);
        coolerAnimation.start();
    }

    public void turnOff(){

        coolerAnimation.setLooping(false);
        this.active = false;
    }
    public boolean isOn() {
        return active;
    }
    public void act(){
        super.act();
        if ( reactor == null )
            return;
        if (this.isOn())
            this.reactor.decreaseTemperature(1);
    }

}

