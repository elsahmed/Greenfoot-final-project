import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThrowMeteoroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowObjects extends Actor
{
    int drop = 0;
    int pause = 0;
    int speed = 100; 
    int ammoDropDelay = 1;
    //ThrowMeteoroids
    public ThrowObjects(int speed)
    {
        this.speed = speed;
    }
    /**
     * Act - do whatever the ThrowMeteoroids wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(drop == 0)
        {
            drop = Greenfoot.getRandomNumber(500);            
        }
        if(pause % speed == 0)
        {
            int x = Greenfoot.getRandomNumber(900);            
            createMeteoroid(x, 0);            
            pause=0;
        }
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
    
    public void createMeteoroid(int x, int y)
    {
        MyWorld world = (MyWorld) getWorld();
        Meteoroid meteoroid = new Meteoroid(world.level);
        world.addObject(meteoroid, x, y);
    }
    
    public void dropAmmo(int x, int y)
    {
        DropAmmo ammo = new DropAmmo();
        MyWorld world = (MyWorld) getWorld();
        world.addObject(ammo, x, y);
    }
}
