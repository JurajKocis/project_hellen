package sk.tuke.oop.aliens;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;


public class ChainBomb extends TimeBomb{
    private int timer;
    private boolean boom;
    private Animation onAnimation;
    private Animation offAnimation;
    private Animation exploAnim;
    


    public ChainBomb(int time) {
        super(time);
        offAnimation = new Animation("resources/images/bomb.png", 16, 16, 1);
        offAnimation.setPingPong(false);
        onAnimation = new Animation("resources/images/bomb_activated.png", 16, 16, 100);
        onAnimation.setPingPong(true);
        exploAnim = new Animation("resources/images/small_explosion.png", 16, 16, 50);
        timer = time + 50;
        boom = false;
        act();
    }


    public void act() {
        Circle circle = new Circle(this.getX(), this.getY(), 50);
        if (super.isActivated()) {
            timer = timer - 1;
            if (timer > 50) {
                setAnimation(onAnimation);
            } else {
                if (!boom) {
                    boom = true;
                    for (Actor bomb : getWorld()) {
                        Rectangle rectangle = new Rectangle(bomb.getX(), bomb.getY(), 16, 16);
                        if (bomb instanceof ChainBomb && circle.intersects(rectangle)) {
                            ((ChainBomb) bomb).chainReaction(this);
                        }
                    }
                }
                setAnimation(exploAnim);
            }
        } else {
            setAnimation(offAnimation);
        }

        if (timer <= 1) {
            getWorld().removeActor(this);
        }
    }


    public void chainReaction(ChainBomb bomb) {
        if (!boom && bomb != null) {
            timer = 50;
            super.activate();
        }
    }
}
