import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world the rocket will be placed in.
 * 
 * @author Elsa 
 * @version December 8th 2020
 */
public class MyWorld extends World
{
    final static int TOTLIVES = 5;
    protected int ammo = 10;
    private int score = 0;
    protected int level = 1;
    private boolean bGameOver= false;
    private Label ammoLabel;
    private Label levelLabel;
    private Label scoreLabel;
    protected Label test;
    private ThrowObjects throwM;  
    public RocketShip rocket;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 600, 1); 
        //RocketShip 
        rocket = new RocketShip();
        addObject(rocket, 500, 300);        
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        Label scoreLabel2 = new Label("SCORE",25);
        addObject(scoreLabel2, 50,85);
        
        ammoLabel = new Label(10,80);
        addObject(ammoLabel, 940,50);
        Label ammoLabel2 = new Label("BULLETS",25);
        addObject(ammoLabel2, 940,85);
        
        levelLabel = new Label("LEVEL " + this.level,30);
        addObject(levelLabel, 65, 575);                
        
        throwM = new ThrowObjects(100);
        addObject(throwM, 0, 0);
        
        showFullLives();
        
        //test = new Label("",80);
        //addObject(test, 500,50);
    }
    
    /**
     * increases the score everytime the user scores a point
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(this.score >= 25 && this.level == 1)
         {
            this.level = 2;
            this.ammo += 10;
        }
        else if(score >= 50 && level == 2)
        {
            this.level = 3;
            this.ammo += 15;
        }
        else if(score >= 75 && level == 3)
        {
            this.level = 4;
            this.ammo += 17;
        }
        else if(score >= 100 && level == 4)
        {
            this.level = 5; 
            this.ammo += 20;
        }     
        levelLabel.setValue("LEVEL " + level);
    }
    
    public void updateBullets(int val)
    {
        ammo+= val;
        ammoLabel.setValue(ammo);
    }    
            
    public void showFullLives()
    {                        
        int x = 830;
        int y = 570;
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
    
    public boolean isGameOver()
    {
        return this.bGameOver;
    }
}
