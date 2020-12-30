import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Actor
{
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());            
        }
        else if(Greenfoot.isKeyDown("F1"))
        {
            Greenfoot.setWorld(new Instructions());
        } 
        else if(Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new TitleScreen());
        } 
        /*else if (Greenfoot.isKeyDown("") && (!Greenfoot.isKeyDown("space") || !Greenfoot.isKeyDown("F1")))
        {
            TitleScreen ts = (TitleScreen) getWorld(); 
            ts.invalidKey(); // calls gameOver sign
        }*/
    }    
}
