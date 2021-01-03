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
        //MyWorld world = (MyWorld) getWorld();     
        GreenfootImage imageRocket = new GreenfootImage("images/rocket.png");
        imageRocket.scale(150,100);
        getBackground().drawImage(imageRocket,450, 150);
        //setImage(rocket);
        //addObject(rocket, 500, 300);
        start();
    }
    
    public void start() 
    {
        rocketAnimation rocket = new rocketAnimation();
        addObject(rocket, 200, 400);
        
        Label start = new Label("SPACE BATTLE", 100);
        addObject(start, 500, 300);

        Label presskey = new Label("Press [space] to start new game", 40);
        presskey.setFillColor(Color.RED);
        addObject(presskey, 500, 360);
        
        Label helpkey = new Label("Press [F1] for instructions", 35);
        helpkey.setFillColor(Color.YELLOW);
        addObject(helpkey, 200, 550);

        StartGame sg = new StartGame();
        addObject(sg, 0, 0);
    }    
}
