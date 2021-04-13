package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;


public class Door extends AbstractActor implements Openable {
    private  Animation animation;
    private boolean closeDoor;
    private boolean lockDoor;
    private boolean init=true;
    public Door(String name, boolean vertical) {
        super(name);
        if(vertical)
            animation = new Animation("resources/sprites/vdoor.png", 16, 32, 100);
        else
            animation = new Animation("resources/sprites/hdoor.png", 32, 16, 100);
        animation.setPingPong(false);
        setAnimation(animation);
        animation.setLooping(false);
        animation.stop();
        closeDoor=true;
        lockDoor=true;
    }

    @Override
    public void act() {
        if(init){
            init=false;
            getWorld().setWall(getX()/16, getY()/16, true);
        }
    }


    @Override
    public void close() {
        this.getAnimation().start();
        getAnimation().stopAt(0);
        closeDoor = true;
    }


    @Override
    public void open() {
        if(!lockDoor && closeDoor==true){
            closeDoor=false;
            animation.start();
            getWorld().setWall(getX()/16, getY()/16, false);
        }
    }


    @Override
    public boolean isOpen() {
        return !closeDoor;
    }

}
