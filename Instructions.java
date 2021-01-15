import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions on how to play the game, includes what key actions and game rules
 * 
 * @author Elsa Ahmed
 * @version December 2020
 */
public class Instructions extends World
{
    /**
     * Constructor for Instructions class.
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        StartGame sg = new StartGame();
        addObject(sg, 0, 0);
        
        Label htp = new Label("How To Play", 50);
        addObject(htp, 500, 40);
        
        Label s1 = new Label("1. Press 'UP' arrow key to move the rocket forward", 35);
        addObject(s1, 345, 160);
        
        Label s2 = new Label("2. Press 'LEFT' or 'RIGHT' arrow key to turn the rocket the direction", 35);
        addObject(s2, 455, 200);
        
        Label s3 = new Label("3. Press 'X' AND 'UP' arrow key to accelerate the rocket forward", 35);
        addObject(s3, 430, 240);
        
        Label s4 = new Label("4. Press 'SPACE' key to shoot a bullet", 35);
        addObject(s4, 265, 280);
        
        Label s5 = new Label("5. If rocket is hit by a Meteoroid 5 times, game over", 35);
        addObject(s5, 350, 320);
        
        Label s6 = new Label("6. If no bullets left AND a Meteoroid hits the end of the screen, game over", 35);
        addObject(s6, 495, 360);
        
        Label s7 = new Label("7. Move the rocket to the golden ball to get more ammo", 35);
        addObject(s7, 375, 400);
        
        Label s8 = new Label("8. Press [ESC] to exit game at anytime", 35);
        addObject(s8, 265, 440);
        /*
        Label s9 = new Label("9. Press 'UP' arrow key to move the rocket forward", 35);
        addObject(s9, 350, 480);

        Label s10 = new Label("10. Press 'UP' arrow key to move the rocket forward", 35);
        addObject(s10, 342, 520);
        */
       
        Label start = new Label("Press [space] to start the game", 35);
        start.setFillColor(Color.YELLOW);
        addObject(start, 500, 550);
    }
}
