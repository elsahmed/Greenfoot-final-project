import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    GreenfootImage heart = new GreenfootImage("images/rocket.png"); 
    private int liveID;
    public Health(int liveID)
    {
        this.liveID = liveID;
        turn(270);
        setImage(heart);
        heart.scale(50,30);        
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here. getX(), getY()
        updateLive();        
    }  
    
    public void updateLive()
    {                        
        //int lives = hit;
        MyWorld world = (MyWorld) getWorld();        
        if (this.liveID==(world.TOTLIVES-world.rocket.hit+1))
        {
            world.removeObject(this);
        } 
    } 
}
