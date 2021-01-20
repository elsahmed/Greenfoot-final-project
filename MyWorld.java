import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This is the world the main actors and actor controllers
 * will be places and called to function
 * 
 * @author Elsa Ahmed
 * @version December 2020
 */
public class MyWorld extends World
{
    final static int CHANGE_LEVEL_BY_SCORE = 25;
    final static int BONUS_BULLET = 50;
    final static int TOTLIVES = 5;
    protected int ammo = 10;
    protected int level = 1;
    private int score = 0;
    private boolean bGameOver= false;
    private Label ammoLabel;
    private Label levelLabel;
    private Label scoreLabel;
    protected Label test;
    private ThrowObjects throwM;  
    public RocketShip rocket;
    //GreenfootImage background = new GreenfootImage("images/space-planet.png");     
    
    /**
     * Constructor for MyWorld class.
     */
    public MyWorld()
    {    
        super(1000, 600, 1); 
        //setImage(background);
        //RocketShip 
        rocket = new RocketShip();
        addObject(rocket, 500, 300);        
        
        //score label
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        Label scoreLabel2 = new Label("SCORE",25);
        addObject(scoreLabel2, 50,85);
        
        //Bullets label
        ammoLabel = new Label(10,80);
        addObject(ammoLabel, 940,50);
        Label ammoLabel2 = new Label("BULLETS",25);
        addObject(ammoLabel2, 940,85);
        
        //Levels label
        levelLabel = new Label("LEVEL " + this.level,30);
        addObject(levelLabel, 65, 575);                
        
        //Objects falling controller
        throwM = new ThrowObjects(100);
        addObject(throwM, 0, 0);
        
        //sets 5 lives to display
        showFullLives();
        
        //test = new Label("",80);
        //addObject(test, 500,50);
    }
    
    /**
     * Increases the score everytime the user scores a point,and updates levels based on score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score); //increases score
        //updates the level
        if(this.score % CHANGE_LEVEL_BY_SCORE == 0)
        {
            this.level = (this.score / CHANGE_LEVEL_BY_SCORE) + 1;
            if (this.level % 5 == 0)
            {
                this.ammo += BONUS_BULLET * ((this.level / 5) + 1);
            }
        }        
        levelLabel.setValue("LEVEL " + level);
    }
    
    /** 
     * Updates the number of bullets the rocket has. 
     * Param takes value to be added or subtract from bullet total
     */
    public void updateBullets(int val)
    {
        ammo+= val;
        ammoLabel.setValue(ammo); //update bullets
    }    
    
    /**
     * Sets the full value of lives at the start of the game
     */
    public void showFullLives()
    {                        
        //object location of first live
        int x = 830;
        int y = 570;
        //sets lives in their respected locations
        for(int i = 1; i <= this.TOTLIVES; i++)
        {
            Health h = new Health(i);
            addObject(h, x, y);
            x += 35;
        }        
    }
    
    public void test(int val)
    {                
        int testNum = val;
        test.setValue(testNum);
    }   
    
    /**
     * Displays the 'Game Over' sign 
     */
    public void gameOver()
    {
        //game over label
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 500, 300);
        
        //start new game label
        Label gameOverLabel2 = new Label("press [esc] to start new game", 40);
        gameOverLabel2.setFillColor(Color.YELLOW);
        addObject(gameOverLabel2, 500, 350);
        
        //stops objects from falling 
        removeObject(this.throwM);
        this.bGameOver=true;        
    }    
    
    /**
     * Getter method of value of isGameOver
     */
    public boolean isGameOver()
    {
        return this.bGameOver;
    }
}
