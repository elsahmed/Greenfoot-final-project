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
    private int fire = 0;
    /**
     * Act - do whatever the rocketShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        if ( !world.isGameOver()) {
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
            else if(Greenfoot.isKeyDown("space")) // shoot bullet
            {
                this.fire++;
                fireBullet();                
            }
            hit();
        }
        if(Greenfoot.isKeyDown("escape")) // move forward
        {
           Greenfoot.setWorld(new TitleScreen());
        }

    }    
   
    /**
     * When the rocket has come in contact with the 
     * metoroid than the object will be removed from the world.
     * Once object is removed the score will also increase by 1.
     */
    public void hit()
    {
        if(isTouching(Meteoroid.class))
        {
            //removeTouching(Meteoroid.class);
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            //world.increaseScore();
        }
    }
    
    public void fireBullet()
    {
        if(this.fire == 10) // delay bullet shots
        {
            Bullet bullet = new Bullet(15, getRotation());
            MyWorld world = (MyWorld) getWorld();
            world.addObject(bullet, getX(), getY());
            this.fire=0;
        }
    }
}