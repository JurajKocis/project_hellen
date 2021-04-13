package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.Movable;

public class Move implements Action {

    private int step;
    private int dx;
    private int dy;
    private Actor actor;

    public Move(Movable actor, int step, int dx, int dy) {
        this.step = step;
        this.dx = dx;
        this.dy = dy;
        this.actor = actor;
    }

    public void execute() {
        if (dy == -1) //hore
        {
            if (dx == 1) {
                if (actor.getAnimation().getRotation() != 45) //hore doprava
                    actor.getAnimation().setRotation(45);

                actor.setPosition(actor.getX() + step, actor.getY() - step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX()-step, actor.getY()+step);
            }

            else if (dx == -1) {
                if (actor.getAnimation().getRotation() != 315) //hore dolava
                    actor.getAnimation().setRotation(315);

                actor.setPosition(actor.getX() - step, actor.getY() - step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX()+step, actor.getY()+step);
            }

            else {
                if (actor.getAnimation().getRotation() != 0) //hore
                    actor.getAnimation().setRotation(0);

                actor.setPosition(actor.getX(), actor.getY() - step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX(), actor.getY()+step);
            }
        }

        else if (dy == 1) //dole
        {
            if (dx == 1) //dole doprava
            {
                if (actor.getAnimation().getRotation() != 135)
                    actor.getAnimation().setRotation(135);

                actor.setPosition(actor.getX() + step, actor.getY() + step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX()-step, actor.getY()-step);
            }

            else if (dx == -1) //dole dolava
            {
                if (actor.getAnimation().getRotation() != 225)
                    actor.getAnimation().setRotation(225);

                actor.setPosition(actor.getX() - step, actor.getY() + step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX()+step, actor.getY()-step);
            }

            else
            {
                if (actor.getAnimation().getRotation() != 180) //dole
                    actor.getAnimation().setRotation(180);

                actor.setPosition(actor.getX(), actor.getY() + step);

                if(actor.getWorld().intersectWithWall(actor))
                    actor.setPosition(actor.getX(), actor.getY()-step);
            }
        }

        else if (dx == -1 && dy == 0) //dolava
        {
            if (actor.getAnimation().getRotation() != 270)
                actor.getAnimation().setRotation(270);

            actor.setPosition(actor.getX() - step, actor.getY());

            if(actor.getWorld().intersectWithWall(actor))
                actor.setPosition(actor.getX()+step, actor.getY());
        }

        else if (dx == 1 && dy == 0) //doprava
        {
            if (actor.getAnimation().getRotation() != 90)
                actor.getAnimation().setRotation(90);

            actor.setPosition(actor.getX() + step, actor.getY());

            if(actor.getWorld().intersectWithWall(actor))
                actor.setPosition(actor.getX() - step, actor.getY());
        }
    }
}