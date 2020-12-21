import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a rocket ship which is the main character of the game.
 * The player will be controling this object.
 * 
 * @author Elsa 
 * @version December 8th 2020
 */
public class RocketShip extends Actor
{
    /**
     * Act - do whatever the rocketShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("a")) // excelerator forward
        {
            move(5);
        }
        else if (Greenfoot.isKeyDown("right")) // turns right
        {
            turn(5);
        }
        else if (Greenfoot.isKeyDown("left")) // turns left
        {
            turn(355);
        }
        else if(Greenfoot.isKeyDown("up")) // move forward
        {
            move(3);
        }
        //else if(Greenfoot.isKeyDown("down")) // move backwards
        //{
        //    move(-3);
        //}
        hit();
    }    
    
    public void hit()
    {
        if(isTouching(Meteoroid.class))
        {
            removeTouching(Meteoroid.class);
            
            MyWorld world = (MyWorld) getWorld();
            world.createMeteoroid();
            world.increaseScore();
        }
    }
}