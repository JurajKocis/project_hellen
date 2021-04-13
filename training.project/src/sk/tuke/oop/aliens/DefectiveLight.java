package sk.tuke.oop.aliens;



public class DefectiveLight extends Light implements Repairable
{
    private int repairTime;
    public DefectiveLight()
    {
        super();
        repairTime = -1;
    }
    @Override
    public void act()
    {
        super.act();
        if( repairTime <= 0 ) {
            if ((this.getElectricity())&&(randomWithRange(0, 20) == 1)) {
                this.toggle();
            }
        }
        else
        {
            repairTime = repairTime - 1;
        }
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    @Override
    public void repairWith(AbstractTool someTool)
    {
        if(Wrench.class != someTool.getClass())
            return;
        someTool.use();
        repairTime = 1000;
    }


}
