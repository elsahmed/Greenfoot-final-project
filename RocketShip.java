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
    //private int ammo = 10;
    private int fire = 0;    
    private int hit = 0;
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
                move(7);
            }
            if (Greenfoot.isKeyDown("right")) // turns right
            {
                turn(5);
            }
            if (Greenfoot.isKeyDown("left")) // turns left
            {
                turn(355);
            }
            if(Greenfoot.isKeyDown("up")) // move forward
            {
                move(3);
            }
            if(Greenfoot.isKeyDown("space")) // shoot bullet
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
            removeTouching(Meteoroid.class);
            if(this.hit == 5)
            {
                MyWorld world = (MyWorld) getWorld();
                world.gameOver();
            }
            this.hit++;
        }
        if(isTouching(DropAmmo.class))
        {
            removeTouching(DropAmmo.class);
            MyWorld world = (MyWorld) getWorld();
            world.updateBullets(5);
        }
    }
    
    public void fireBullet()
    {
        MyWorld world = (MyWorld) getWorld();
        if(this.fire == 10 && world.ammo > 0) // delay bullet shots
        {
            Bullet bullet = new Bullet(15, getRotation());
            world.addObject(bullet, getX(), getY());
            this.fire=0;
            world.updateBullets(-1);
        }
    }
}