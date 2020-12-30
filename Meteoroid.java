import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * object that is falling from the top of the world.
 * player needs to hit this object to score a point,
 * before object reaches the end of the world screen.
 * 
 * @author Elsa 
 * @version December 2020
 */
public class Meteoroid extends Actor
{
    private int speed;
    public Meteoroid(int speed)
    {
        this.speed = speed;
    }
    /**
     * Act - do whatever the Meteoroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if (!world.isGameOver()) 
        {
            int x = getX();
            int y = getY()+this.speed;
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
