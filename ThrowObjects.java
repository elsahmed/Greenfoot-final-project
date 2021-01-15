import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Throws objects from top of the screen at random y postions and drop-speed
 * 
 * @author Elsa Ahmed
 * @version Demember 2020
 */
public class ThrowObjects extends Actor
{
    int ammoDropDelay = 1;
    int drop = 0;
    int pause = 0;
    int speed; 

    /**
     * contrustor of ThrowObjects class sets value of speed to send down multiple objects
     */
    public ThrowObjects(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * contrustor of ThrowObjects class speed value set for 100
     */
    public ThrowObjects()
    {
        this.speed = 100;
    }
    
    /**
     * Objects are droped at random depending on the levels
     */
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld(); 
        //picks random y position
        if(drop == 0)
        {
            drop = Greenfoot.getRandomNumber(499) + 1;            
        }
        // drops meteoroids
        if(pause % speed == 0)
        {
            int x = Greenfoot.getRandomNumber(900);            
            createMeteoroid(x, 0); 
            if(world.level % 5 == 0 && this.speed >= 21)
            {
                this.speed -= 20;
            }
            pause = 0;
        }
        // drops extra ammo
        if(ammoDropDelay % drop == 0 )
        {
            int x1 = Greenfoot.getRandomNumber(900);
            dropAmmo(x1, 0);
            drop = 0;
            ammoDropDelay = 1;
        }
        pause++;
        ammoDropDelay++;
    }  
    
    /**
     * creates meteoroid at the given set position
     */
    public void createMeteoroid(int x, int y)
    {
        MyWorld world = (MyWorld) getWorld();
        Meteoroid meteoroid = new Meteoroid(world.level);
        world.addObject(meteoroid, x, y);
    }
    
    /**
     *  creates ammo at the given set position
     */
    public void dropAmmo(int x, int y)
    {
        DropAmmo ammo = new DropAmmo();
        MyWorld world = (MyWorld) getWorld();
        world.addObject(ammo, x, y);
    }
}
