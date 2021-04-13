package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

import java.util.ArrayList;
import java.util.Iterator;


public class Reactor extends AbstractActor implements Switchable,Repairable
{
    private int temperature ;
    private int damage ;
    private sk.tuke.oop.framework.Animation normalAnimation ;
    private sk.tuke.oop.framework.Animation hotAnimation ;
    private sk.tuke.oop.framework.Animation brokenAnimation;
    private Animation exFireAnimation;
    private Animation offAnimation;
    private String manufacturer;
    private boolean isReactOn;
    private ArrayList<EnergyConsumer> device;
    private boolean isSmartCooling;
    private boolean wasExFire;
    
    public Reactor()
    {
        temperature = 0;
        damage = 0;
        wasExFire = false;

        normalAnimation = new Animation("images/reactor_on.png", 80,  80,100);
        normalAnimation.setPingPong(true);

        exFireAnimation = new Animation("images/reactor_extinguished.png", 80,  80,100);
        normalAnimation.setPingPong(true);

        hotAnimation = new Animation("images/reactor_hot.png", 80,  80, 150);
        hotAnimation.setPingPong(true);

        offAnimation = new Animation("images/reactor.png", 80,  80,100);
        offAnimation.setPingPong(false);
        this.setAnimation(offAnimation);

        brokenAnimation = new Animation("images/reactor_broken.png", 80,  80,100);
        brokenAnimation.setPingPong(false);
        brokenAnimation.setLooping(false);

        manufacturer = "";
        isReactOn = false;
        device = new ArrayList<EnergyConsumer>();
        isSmartCooling = false;
    }

    public Reactor( String manufacturer)
    {
        this.manufacturer = manufacturer;
        temperature = 0;
        damage = 0;
        wasExFire = false;

        normalAnimation = new Animation("images/reactor_on.png", 80,  80,100);
        normalAnimation.setPingPong(true);

        exFireAnimation = new Animation("images/reactor_extinguished", 80,  80,100);
        normalAnimation.setPingPong(true);

        hotAnimation = new Animation("images/reactor_hot.png", 80,  80, 150);
        hotAnimation.setPingPong(true);

        offAnimation = new Animation("images/reactor.png", 80,  80,100);
        offAnimation.setPingPong(false);
        this.setAnimation(offAnimation);

        brokenAnimation = new Animation("images/reactor_broken.png", 80,  80,100);
        brokenAnimation.setPingPong(false);
        brokenAnimation.setLooping(false);

        manufacturer = "";
        isReactOn = false;
        device = new ArrayList<EnergyConsumer>();
        isSmartCooling = false;
    }

    public int getTemperature()
    {
        return  this.temperature;
    }

    public int getDamage()
    {
        return this.damage;
    }

    private void updateDamage(int temperature)
    {
        int tempDamage = 0;
        if ( temperature > 2000 )
        {
            tempDamage = ( temperature - 2000 ) / ( 4000/100 );
        }
        if  ( tempDamage > this.damage )
        {
            this.damage = tempDamage;
            this.hotAnimation.setDuration( 150 - this.damage);
        }
        if(this.damage > 100)
        {
            this.damage = 100;
        }
    }

    private void updateAnimation()
    {

        if ((isReactOn) && (6000 <= this.temperature))
        {

            setAnimation(brokenAnimation);
            this.isReactOn = false;
        }
        else if( (!isReactOn) && ( temperature< 6000 )&&(!wasExFire) )
        {

                setAnimation(offAnimation);


        }
        else if ( ( 0 <= temperature ) && ( 4000 >= temperature ) &&(!wasExFire) )
        {

                setAnimation(normalAnimation);


        }
        else if ( ( 4000 < temperature ) && ( 6000 > temperature) &&(!wasExFire))
        {

                setAnimation(hotAnimation);



        }

    }

    public void increaseTemperature(int increment)
     {
         if( !this.isReactOn)
             return;
         if ( increment < 0)
         {
             return;
         }
         double quocient = 1;
         if (( this.damage >= 33 ) && ( this.damage <= 66))
         {
             quocient = 1.5;
         }
         else if ( this.damage > 66)
         {
             quocient = 2;
         }
         this.temperature = (int) (this.temperature +(quocient * increment ));
         updateAnimation(  );
         updateDamage(temperature);

     }

     public void decreaseTemperature( int decrement ) {
         if(!this.isReactOn)
             return;
         if (decrement < 0) {
             return;
         }
         if( this.damage >= 50)
         {
             this.temperature = this.temperature - (decrement/ 2);
         }
         else if ( !( this.damage == 100) ) {
             this.temperature = this.temperature - decrement;
         }
         if (temperature < 0)
         {
             this.temperature = 0;
         }

         updateAnimation(  );
     }

    public boolean isServiceNeeded()
    {
        if ( ( this.temperature > 3000) && ( this.damage > 50) )
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    public void repairWith(AbstractTool hammer)
    {
        if( (!(hammer instanceof Hammer))||( this.damage == 0 )||( this.damage == 100 ))
        {
            return;
        }
        int newTemp;
        hammer.use();
        this.damage = this.damage - 50;
        newTemp = (4000/100)*this.damage+ 2000;
        if(newTemp < this.temperature)
        {
            this.temperature = newTemp;
        }
        if( this.damage < 0)
        {
            this.damage = 0;
        }
        updateAnimation( );
    }

    //** toto je zle pozri sa na to
    //private void updateTemperature( int damage )
    //{
    //    int tempTemperature;
    //    tempTemperature = ( damage /( hot / maximumDmg ) ) - serviceDmg;
    //    if (tempTemperature < this.temperature)
    //    {
    //        if (tempTemperature < minimum)
    //        {
    //            this.temperature = minimum;
    // }
    //        else
    //        {
    //            this.temperature = tempTemperature;
    //        }

    //    }

   // }

    public void turnOn()
    {
        isReactOn = true;
        updateAnimation();
        for (Iterator<EnergyConsumer> consumerIterator = device.iterator(); consumerIterator.hasNext(); )
        {
            EnergyConsumer consumer = consumerIterator.next();
            consumer.setElectricityFlow(true);
        }
    }

    public void turnOff()
    {
        isReactOn = false;
        updateAnimation();
        for (Iterator<EnergyConsumer> consumerIterator = device.iterator(); consumerIterator.hasNext(); )
        {
            EnergyConsumer consumer = consumerIterator.next();
            consumer.setElectricityFlow(false);
        }
    }

    public boolean isOn()
    {
        return (this.isReactOn);
    }

    public void addDevice(EnergyConsumer device)
    {
        if (device != null) {
            this.device.add(device);
            if (this.isOn())
            {
                device.setElectricityFlow(true);
            }
        }
    }

    public void removeDevice(EnergyConsumer device)
    {
        device.setElectricityFlow(false);
        this.device.remove(device);
    }

    public void extinguishWith( AbstractTool tool )
    {
        if((! (tool instanceof FireExtinguisher))||(this.damage <100))
        {
            return;
        }

            tool.use();
            wasExFire = true;
            if (this.temperature < 4000)
            {
                setAnimation(exFireAnimation);

            }
            else
            {

                this.temperature = 4000;
                setAnimation(exFireAnimation);
            }


    }

    @Override
    public void act()
    {
        super.act();
        increaseTemperature(1);
    }

    public boolean getIsSmartCooling() {
        return isSmartCooling;
    }
    public void setIsSmartCooling(boolean bool)
    {
        this.isSmartCooling = bool;
    }


}

