package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actions.Fire;
import sk.tuke.oop.game.actions.Move;
import sk.tuke.oop.game.actors.*;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.weapons.AbstractWeapon;
import sk.tuke.oop.game.items.Backpack;

public class Ripley extends AbstractActor implements Movable, Alive, Armed {
    private int energy;
    private int ammo;
    private Backpack backpack;
    private RipleyState ripleyState;
    private AbstractWeapon abstractWeapon;
    private Health health;
    private Fire fire;

    public static final String RIPLEY_NAME = "ellen";
    public Ripley(){
        super("Ripley");
        setPosition(0,0);
        Animation animation= new Animation("resources/sprites/player.png", 32, 32, 100);
        setAnimation(animation);
        this.health= new Health(100, 100);

        energy= 70;
        ammo = 480;
        backpack = new Backpack(10);
        /*fire= new Fire(this);*/

    }

    public int getAmmo() {
        return ammo;
    }
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    @Override
    public Animation getAnimation() {
        return null;
    }

    @Override
    public void setAnimation(Animation animation) {

    }

    public void act() {
        Input input = Input.getInstance();
        getAnimation().stop();
        if (input.isKeyDown(Input.Key.UP) || input.isKeyDown(Input.Key.DOWN) || input.isKeyDown(Input.Key.RIGHT) || input.isKeyDown(Input.Key.LEFT)) {
            getAnimation().start();
        }

    }

    @Override
    public boolean intersects(Actor actor) {
        return false;
    }

    @Override
    public void addedToWorld(World world) {

    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public void deadAnimation(){
        if(getHealth().getValue()==0){
            getAnimation().getRotation();
            setAnimation(new Animation("resources/sprites/player_die.png",32,32,100));
            getAnimation().getRotation();
        }
    }

    public Health getHealth() {
        return  health;
    }

    @Override
    public AbstractWeapon getWeapon() {
        return abstractWeapon;
    }

    @Override
    public void setWeapon(AbstractWeapon weapon) {
        this.abstractWeapon = weapon;
    }

    public void escape(){
        Input input = Input.getInstance();
        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
    }

    public void odoberanieEnergie() {
        for (Actor actor : getWorld()) {
            if ((actor instanceof Door && ((Door) actor).isOpen() == true) && energy >0) {
                energy = (energy) - 1;
            }
        }
    }

    /*health.onExhaustion(() -> {
        public void apply() {


        }
    });
    */

    public void left(){
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.LEFT) && !input.isKeyDown(Input.Key.DOWN) && !input.isKeyDown(Input.Key.UP) && !input.isKeyDown(Input.Key.RIGHT)) { //Key code
            if (getAnimation().getRotation() != 270) {
                getAnimation().setRotation(270);
            }
            Move move = new Move(this, 2, -1, 0);
            move.execute();
        }
    }
    public void right(){
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.RIGHT) && !input.isKeyDown(Input.Key.DOWN) && !input.isKeyDown(Input.Key.UP) && !input.isKeyDown(Input.Key.LEFT)) { //Key code
            if (getAnimation().getRotation() != 90) {
                getAnimation().setRotation(90);
            }
            Move move = new Move(this, 2, 1, 0);
            move.execute();
        }
    }
    public void down(){
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.DOWN) && !input.isKeyDown(Input.Key.UP) && !input.isKeyDown(Input.Key.RIGHT) && !input.isKeyDown(Input.Key.LEFT)) { //Key code
            if (getAnimation().getRotation() != 180) {
                getAnimation().setRotation(180);
            }
            Move move = new Move(this, 2, 0, +1);
            move.execute();
        }
    }
    public void diagonalMove(){
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.LEFT) && input.isKeyDown(Input.Key.UP)) {
            getAnimation().start();
            if (getAnimation().getRotation() != 315 ) {
                getAnimation().setRotation(315);
            }
            Move move=new Move(this,2,-1,-1);
            move.execute();
        }
        if (input.isKeyDown(Input.Key.LEFT) && input.isKeyDown(Input.Key.DOWN)) {
            getAnimation().start();
            if (getAnimation().getRotation() != 225) {
                getAnimation().setRotation(225);
            }
            Move move=new Move(this,2,-1,+1);
            move.execute();
        }
        if (input.isKeyDown(Input.Key.RIGHT) && input.isKeyDown(Input.Key.UP)) {
            getAnimation().start();
            if (getAnimation().getRotation() != 45) {
                getAnimation().setRotation(45);
            }
            Move move=new Move(this,2,+1,-1);
            move.execute();
        }
        if (input.isKeyDown(Input.Key.RIGHT) && input.isKeyDown(Input.Key.DOWN)) {
            getAnimation().start();
            if (getAnimation().getRotation() != 135) {
                getAnimation().setRotation(135);
            }
            Move move=new Move(this,2,+1,+1);
            move.execute();
        }
    }
    public void up(){
        Input input = Input.getInstance();
        if (input.isKeyDown(Input.Key.UP) && !input.isKeyDown(Input.Key.DOWN) && !input.isKeyDown(Input.Key.RIGHT) && !input.isKeyDown(Input.Key.LEFT)) { //Key code
            if (getAnimation().getRotation()!= 0) {
                getAnimation().setRotation(0);
            }
            Move move= new Move(this, 2, 0, -1);
            move.execute();
        }
    }


}
