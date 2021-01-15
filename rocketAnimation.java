import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocketAnimation here.
 * 
 * @author Elsa Ahmed 
 * @version January 2021
 */
public class rocketAnimation extends Actor
{    
    /**
     * runs the animations of the rocket 
     */
    public void act() 
    {      
        animation();
    }   
       
    /**
     * rocket moves forward untill hits the end of the screen, then turns 60 degrees 
     */
    private void animation()
    {
       int gap =10;
       TitleScreen world = (TitleScreen) getWorld();
       if (!(getY() < gap || getX() < gap ||  getY() > world.getHeight()-gap || getX() > world.getWidth()-gap))
       {
           move(5);//speed the rocket moves
       }
       else if (getY() < gap || getX() < gap ||  getY() > world.getHeight()-gap || getX() > world.getWidth()-gap)
       {           
           turn(60);//(Greenfoot.getRandomNumber(180));
           move(5); //speed the rocket moves
       }
    }
}
