package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;

public class AbstractTool extends AbstractActor {
   private int possibleUses;
   public AbstractTool(int possibleUses){
       this.possibleUses = possibleUses;
   }

    public void use(){

        possibleUses -= 1;
        if (possibleUses == 0)
        this.getWorld().removeActor(this);
    }

    public void uses(int number){
        possibleUses = number;
    }

    public int getPossibleUses() {
        return possibleUses;
    }
}




