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
     * Constructor for StartScreen class.
     */    
    public TitleScreen()
    {    
        //world size
        super(1000, 600, 1); 
        //sets rocket image
        GreenfootImage imageRocket = new GreenfootImage("images/rocket.png");
        imageRocket.scale(240,120);
        getBackground().drawImage(imageRocket,400, 150);

        start();
    }    
    
    /**
     * Sets rocket animation and labels on the title screen
     */
    private void start() 
    {
        //rocket
        rocketAnimation rocket = new rocketAnimation();
        addObject(rocket, 100, 450);
        
        //Game name
        Label start = new Label("SPACE BATTLE", 100);
        addObject(start, 500, 300);

        //keypress to start
        Label presskey = new Label("Press [space] to start new game", 40);
        presskey.setFillColor(Color.RED);
        addObject(presskey, 500, 360);
        
        //instructios screen
        Label helpkey = new Label("Press [F1] for instructions", 35);
        helpkey.setFillColor(Color.YELLOW);
        addObject(helpkey, 200, 550);

        //object switches screen
        StartGame sg = new StartGame();
        addObject(sg, 0, 0);
    }    
}
