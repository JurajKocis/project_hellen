package sk.tuke.oop.aliens;

public class Mjolnir extends Hammer {
    private int uses;

    public Mjolnir() {
        uses(4);
    }

    public int getPossibleUses(AbstractTool abstractTool){
        return abstractTool.getPossibleUses();
    }

    public int getUses() {
        return uses;
    }

    @Override
    public void use() {
        super.use();
    }

}