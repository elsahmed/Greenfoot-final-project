import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world the rocket will be placed in.
 * 
 * @author Elsa 
 * @version December 8th 2020
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 600, 1, false); 
        RocketShip rocket = new RocketShip();
        addObject(rocket, 500, 300);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        
        createMeteoroid();
    }
    
    /**
     * increases the score everytime the user scores a point
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * creates a new meteoroid every time one is hit  
     */
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
