import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocketAnimation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rocketAnimation extends Actor
{    

    /**
     * Act - do whatever the rocketAnimation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.        
        animation();
    }   
       
    public void animation()
    {
       int gap =10;
       TitleScreen world = (TitleScreen) getWorld();
       if (!(getY() < gap || getX() < gap ||  getY() > world.getHeight()-gap || getX() > world.getWidth()-gap))
       {
           move(5);
       }
       else if (getY() < gap || getX() < gap ||  getY() > world.getHeight()-gap || getX() > world.getWidth()-gap)
       {           
           turn(Greenfoot.getRandomNumber(180));
           move(10);
       }
    }
}
