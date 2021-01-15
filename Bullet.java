import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bullets stored in rocket and can destroy Meteoroids
 * 
 * @author Elsa Ahmed 
 * @version December 2020
 */
public class Bullet extends Actor
{
    private int speed; // speed bullet traveld
    private int rotation; // rotation to turn
    
    /**
     * Bullet class constructor sets value for speed and rotation for the bullet
     */
    public Bullet(int speed, int rot)
    {
        this.speed = speed;
        this.rotation = rot;        
    }
    
    /**
     * Bullet travel at the given speed and direction it is thrown
     */    
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        //sets bullet and moves in direction thrown
        if (!world.isGameOver()) 
        {            
            setLocation(getX(), getY());
            setRotation(this.rotation);
            move(this.speed);
            destroy();            
        }        
    }    
    
    /**
     * removed meteoroid when comes in contact
     */
    public void destroy()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Meteoroid.class))
        {
            Greenfoot.playSound("sounds/explosion.wav"); //plays sound
            removeTouching(Meteoroid.class);
            world.increaseScore(); //inscreases score
            world.removeObject(this); //removed object after destroyed
        } 
        // if not touching meteoroid, removed after end of the screen 
        else if( getY() < 1 || getX() < 1 ||  getY() > world.getHeight()-5 || getX() > world.getWidth()-5)
        {            
            world.removeObject(this);
        }
    }
}
