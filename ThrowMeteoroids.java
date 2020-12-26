import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThrowMeteoroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowMeteoroids extends Actor
{
    int pause = 0;
    int speed = 100;
    
    public ThrowMeteoroids(int speed)
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
        if(pause % speed == 0)
        {
            int x = Greenfoot.getRandomNumber(600);
            createMeteoroid(x, 0);
            pause=0;
        }
        pause++;
    }  
    
    public void createMeteoroid(int x, int y)
    {
        Meteoroid meteoroid = new Meteoroid();
        MyWorld world = (MyWorld) getWorld();
        world.addObject(meteoroid, x, y);
    }
    
}
