import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display the number of live the rocket has left
 * 
 * @author Elsa Ahmed
 * @version December 2020
 */
public class Health extends Actor
{
    GreenfootImage heart = new GreenfootImage("images/rocket.png"); 
    private int liveID;
    /**
     * Health class contructor sets id number of live
     */
    public Health(int liveID)
    {
        this.liveID = liveID;
        turn(270);
        setImage(heart);
        heart.scale(50,30);        
    }
    
    public void act() 
    {
        updateLive();        
    }  
    
    /**
     * updates the number of lives to be displayed
     */
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
