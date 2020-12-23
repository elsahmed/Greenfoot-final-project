import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions on how to play the game
 * 
 * @author Elsa 
 * @version December 2020
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        StartGame sg = new StartGame();
        addObject(sg, 0, 0);
        
        Label htp = new Label("How To Play", 80);
        addObject(htp, 500, 40);
        
        Label s1 = new Label("1.hello this is a game", 50);
        addObject(s1, 200, 140);
    }
}
