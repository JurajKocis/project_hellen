package sk.tuke.oop.aliens;

        import sk.tuke.oop.aliens.actor.AbstractActor;
        import sk.tuke.oop.framework.Animation;

public class Helicopter extends AbstractActor {
    private boolean isSearching;

    public Helicopter() {
        setAnimation(new Animation("images.heli.png", 64, 64, 100));
    }

    public void toogleIsSearching() {
        isSearching = !isSearching;
    }

    public void searchAndDestroy() {
        isSearching = true;
    }

    @Override
    public void act() {

        int helix = this.getX();
        int heliy = this.getY();
        int playerx = getPlayer().getX();
        int playery = getPlayer().getY();

        if (isSearching) {
            if (playerx < helix) {
                this.setPosition(helix = helix - 1, heliy);
            } else {
                this.setPosition(helix = helix + 1, heliy);
            }

            if (playery < heliy) {
                this.setPosition(helix, heliy = heliy - 1);
            } else {
                this.setPosition(helix, heliy = heliy + 1);
            }

            if (this.intersects(getPlayer())) {
                getPlayer().setEnergy(getPlayer().getEnergy() - 1);
            }
        }
    }
}