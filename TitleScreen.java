import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen that is shown before the user starts playing the game.
 * -> user can switch to game screen or the instructions screen
 * from here.
 * 
 * @author Elsa 
 * @version December 2020
 */
public class TitleScreen extends World
{
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        start();
    }
    
    public void start() 
    {
        Label start = new Label("Start Game", 100);
        addObject(start, 500, 300);

        Label presskey = new Label("press [space] to start new game", 40);
        presskey.setFillColor(Color.BLUE);
        addObject(presskey, 500, 360);
        
        Label helpkey = new Label("F1 = help", 40);
        helpkey.setFillColor(Color.YELLOW);
        addObject(helpkey, 100, 550);

        StartGame sg = new StartGame();
        addObject(sg, 0, 0);
    }
    
    /*public void invalidKey() 
    {
        Label invalidkey = new Label("invalid key is pressed", 25);
        invalidkey.setFillColor(Color.YELLOW);
        addObject(invalidkey, 500, 450);
        
    }*/
}
