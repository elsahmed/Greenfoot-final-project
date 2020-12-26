import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    private int rotation;
    
    public Bullet(int speed, int rot)
    {
        this.speed = speed;
        this.rotation = rot;        
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if (!world.isGameOver()) 
        {            
            setLocation(getX(), getY());
            setRotation(this.rotation);
            move(this.speed);
            destroy();            
        }        
    }    
    
    public void destroy()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Meteoroid.class))
        {
            removeTouching(Meteoroid.class);
            world.increaseScore();
            world.removeObject(this);    
        } 
        else if( getY() < 1 || getX() < 1 ||  getY() > world.getHeight()-5 || getX() > world.getWidth()-5)
        {            
            world.removeObject(this);
        }
    }
}
