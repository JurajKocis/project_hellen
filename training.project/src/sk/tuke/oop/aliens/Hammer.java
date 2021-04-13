package sk.tuke.oop.aliens;

        import sk.tuke.oop.framework.Animation;

public class Hammer extends AbstractTool {

    public Hammer() {
        super(1);
        setAnimation(new Animation("images/hammer.png", 16, 16, 10));
        uses(1);
    }
}