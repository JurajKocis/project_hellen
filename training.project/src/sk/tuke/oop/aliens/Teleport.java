

package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.aliens.actor.Player;
import sk.tuke.oop.framework.Animation;

public class Teleport extends AbstractActor {
    private Teleport other;
    private boolean activated;
    private Animation teleportAnimation;

    public Teleport( Teleport oth ) {
       
            this.teleportAnimation = new Animation("images/lift.png", 48, 48, 200);
            setAnimation(teleportAnimation);
            this.activated = false;
            this.other = oth;
      
    }

    public void setDestination( Teleport tp ){

        if ( this == other ) return;
        other = tp;
    }

    public void teleportPlayer(){
        getPlayer().setPosition( other.getX() + other.getWidth()/2 - getPlayer().getWidth()/2, other.getY() + other.getHeight()/2 - getPlayer().getHeight()/2);
        other.activated = true;
    }

    @Override
    public void act(){
        Player player = getPlayer();
        if ( activated ){
            if ( ( player.getX() > getX() + getWidth()/2 || player.getX() < getX() - getWidth()/2 )
                    || ( player.getY() > getY() + getHeight()/2 || player.getY() < getY() - getHeight()/2 ) ){
                activated = false;
                return;
            }
        }
        if ( !activated ){
            if ( other == null ) return;
            if ( ( player.getX() <= getX() + getWidth()/2 && player.getX() >= getX() - getWidth()/2 )
                    && ( player.getY() <= getY() + getHeight()/2 && player.getY() >= getY() - getHeight()/2 ) ){
               
                activated = true;
                teleportPlayer();
            }
        }
    }

}
