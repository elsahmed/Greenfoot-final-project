import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Meteoroids are dropped from the top
 * 
 * @author Elsa Ahmed
 * @version December 2020
 */
public class Meteoroid extends Actor
{
    private int speed; // speed of fall
    
    /**
     * sets what speed the meteoroid falls
     */
    public Meteoroid(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * drops meteoroid and checks to see if game is over
     */    
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if (!world.isGameOver()) 
        {
            int x = getX();
            int y = getY() + this.speed;
            setLocation(x, y);
            if(y > world.getHeight()-5 && world.ammo == 0)
            {
                world.removeObject(this);
                world.gameOver(); // calls gameOver sign 
            }  
            if(y > world.getHeight()-5)
            {
                world.removeObject(this);                
            }   
        }
    }       
}
