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
    /**
     * Act - do whatever the Meteoroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY()+2;
        setLocation(x, y);
        if(y > 600)
        {
            MyWorld world = (MyWorld) getWorld(); 
            world.gameOver(); // calls gameOver sign 
        } 
    }
}
