package sk.tuke.oop.game.actors.weapons;

public abstract class AbstractWeapon {
    private int initAmmo;
    private int maxAmmo;

    protected abstract Fireable createBullet();
    
    public AbstractWeapon(int initAmmo, int maxAmmo){
        this.initAmmo=initAmmo;
        this.maxAmmo=maxAmmo;

    }
    
    public void reload(int newAmmo){
        initAmmo=initAmmo+newAmmo;
        if(initAmmo>maxAmmo){
            initAmmo=maxAmmo;
        }
    }
    
    
     public Fireable fire() {
        if (initAmmo == 0) {
            return null;
        }
        initAmmo--;
        return createBullet();
    }

    public int getAmmo(){

        return initAmmo;
    }
 
}
