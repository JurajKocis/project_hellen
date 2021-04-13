package sk.tuke.oop.aliens;

public class SmartCooler extends Cooler {
    private Reactor reactor;

    public SmartCooler(Reactor reactor) {
        super(reactor);
        this.reactor = reactor;
    }

    public void act(){
        if(reactor != null) {
            if (reactor.getTemperature() < 1000) {
                turnOff();
            }
            if (reactor.getTemperature() > 2000) {
                turnOn();
            }
            super.act();
        }
    }



}