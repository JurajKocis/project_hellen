package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;

public class Health {

    private int energy;
    private int maxenergy;
    private List<ExhaustionEffect> zoznam;

    public Health(int energy, int maxenergy) {
        this.energy = energy;
        this.maxenergy = maxenergy;
    }

    public Health(int energy) {
        this.energy = energy;
        this.maxenergy = energy;
        zoznam = new ArrayList<>();
    }

    public int getValue()
    {
        return energy;
    }

    public void refill(int amount) {
        energy += amount;
    }

    public void restore()
    {
        energy = maxenergy;
    }

    public void drain(int amount) {
        energy -= amount;
        if(getValue() == 0)
        {
            //zoznam.forEach((callback)-> callback.apply());
            zoznam.forEach(ExhaustionEffect::apply);

            /*for(ExhaustionEffect effect: zoznam) {
                effect.apply();
            }*/
        }
    }

    public void exhaust() {
        energy = 0;
    }

    public void onExhaustion(ExhaustionEffect callback) {
        zoznam.add(callback);
    }

    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }
}
