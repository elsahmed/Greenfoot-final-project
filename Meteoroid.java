import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteoroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        int y = getY() +2;
        setLocation(x, y);
        
        if(y > 600)
        {
            MyWorld world = (MyWorld) getWorld(); 
            world.gameOver(); // calls gameOver sign 
            // when apple leaves the screen
        } 
    }
}
