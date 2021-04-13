package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;


public class Computer extends AbstractActor implements EnergyConsumer  {
    private Animation computerAnimation;
    private boolean compOn;
    private boolean electricity;

    public Computer(){
        computerAnimation = new Animation("resources/images/computer.png", 80, 48, 100);
        setAnimation(computerAnimation);
    }

    public void turnOn() {
        compOn =true;
    }
    public void turnOff() {
        compOn =false;
    }
    public int add(int a, int b) {
                 return a+b;
    }

    public int sub(int a, int b) {

                return a-b;
    }

    public double add(double a, double b) {

                return a+b;
    }

    public double sub(double a, double b) {

                return a-b;
    }

    public void setElectricityFlow(boolean compOn) {
        electricity = this.compOn;
    }
            public boolean isOn() {
                return compOn;
    }

    public void act(){
        if (compOn && electricity){
            computerAnimation.setPingPong(true);
            setAnimation(computerAnimation);
            computerAnimation.start();}
        else{
            setAnimation(computerAnimation);
            computerAnimation.stop();
        }
    }
}
