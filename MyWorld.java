import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world the rocket will be placed in.
 * 
 * @author Elsa 
 * @version December 8th 2020
 */
public class MyWorld extends World
{
    protected int ammo = 10;
    private boolean bGameOver= false;
    private int score = 0;
    private Label ammoLabel;
    private Label scoreLabel;
    //Label test;
    private ThrowObjects throwM;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 600, 1); 
        RocketShip rocket = new RocketShip();
        addObject(rocket, 500, 300);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        Label scoreLabel2 = new Label("SCORE",25);
        addObject(scoreLabel2, 50,85);
        
        ammoLabel = new Label(10,80);
        addObject(ammoLabel, 940,50);
        Label ammoLabel2 = new Label("BULLETS",25);
        addObject(ammoLabel2, 940,85);
        
        //test = new Label(0,80);
        //addObject(test, 500,50);
        
        throwM = new ThrowObjects(100);
        addObject(throwM, 0, 0);
    }
    
    /**
     * increases the score everytime the user scores a point
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void updateBullets(int val)
    {
        ammo+= val;
        ammoLabel.setValue(ammo);
    }
    
    //public void test(int val)
    //{        
    //    test.setValue(val);
    //}
    
    /**
     * shows the 'game over' sign 
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 500, 300);
        
        Label gameOverLabel2 = new Label("press [esc] to start new game", 40);
        gameOverLabel2.setFillColor(Color.YELLOW);
        addObject(gameOverLabel2, 500, 350);
        
        removeObject(this.throwM);
        this.bGameOver=true;        
    }
    
    //public ThrowObjects getMeteoroids()
    //{
    //    return this.throwM;
    //}
    
    public boolean isGameOver()
    {
        return this.bGameOver;
    }
}
