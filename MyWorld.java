import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world the rocket will be placed in.
 * 
 * @author Elsa 
 * @version December 8th 2020
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int score = 0;
    Label scoreLabel;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1, false); 
        RocketShip rocket = new RocketShip();
        addObject(rocket, 500, 300);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        
        createMeteoroid();
        //Meteoroid meteoroid = new Meteoroid();
        //addObject(meteoroid, 500, 0);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void createMeteoroid()
    {
        Meteoroid meteoroid = new Meteoroid();
        int x = Greenfoot.getRandomNumber(600);
        addObject(meteoroid, x, 0);
    }
    
    /**
     * shows the 'game over' sign 
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 500, 300);
    }
}
