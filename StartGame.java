import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * controls what screen are to be displayed 
 * 
 * @author Elsa Ahmed
 * @version December 2020
 */
public class StartGame extends Actor
{
    /**
     * controls whet screens are displayed
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld()); // displays game screen           
        }
        else if(Greenfoot.isKeyDown("F1"))
        {
            Greenfoot.setWorld(new Instructions()); // displays instructions screen
        } 
        else if(Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new TitleScreen()); // displays title screen
        }         
    }    
}
