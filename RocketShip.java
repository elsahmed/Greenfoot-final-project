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
    protected int hit = 0;
    final static int BULLET_PACK = 5;
    final static String KEY_X = "x";
    final static String KEY_RIGHT = "right";
    final static String KEY_LEFT = "left";
    final static String KEY_UP = "UP";
    final static String KEY_SPACE = "space";
    final static String KEY_ESCAPE = "escape";    
    
    /**
     * Act - do whatever the rocketShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        if ( !world.isGameOver()) {            
            if (Greenfoot.isKeyDown(KEY_X)) // excelerator forward
            {
                move(7);
            }
            if (Greenfoot.isKeyDown(KEY_RIGHT)) // turns right
            {
                turn(5);
            }
            if (Greenfoot.isKeyDown(KEY_LEFT)) // turns left
            {
                turn(355);
            }
            if(Greenfoot.isKeyDown(KEY_UP)) // move forward
            {
                move(5);
            }
            if(Greenfoot.isKeyDown(KEY_SPACE)) // shoot bullet
            { 
                this.fire++;
                fireBullet();                
            }
            hit();
        }
        if(Greenfoot.isKeyDown(KEY_ESCAPE)) // move forward
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
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Meteoroid.class))
        {
            removeTouching(Meteoroid.class);             
            GreenfootImage crack = new GreenfootImage("images/rocket-cracked" + (hit) + ".png");
            setImage(crack);
            //world.test(this.lives-this.hit);
            Greenfoot.playSound("sounds/rocketExplosion.wav");            
            if(this.hit == world.TOTLIVES-1)
            {                
                getImage().setTransparency(0);
                rocketExplode rocketExp = new rocketExplode(15);
                world.addObject(rocketExp, getX(), getY());
                world.gameOver();
            }
            this.hit++;
        }
        if(isTouching(DropAmmo.class))
        {
            removeTouching(DropAmmo.class);
            world.updateBullets(BULLET_PACK);
        }
    }
    
    public void fireBullet()
    {
        MyWorld world = (MyWorld) getWorld();
        if(this.fire >= 7 && world.ammo > 0) // delay bullet shots = 7
        {
            Bullet bullet = new Bullet(15, getRotation());
            world.addObject(bullet, getX(), getY());
            this.fire=0;
            world.updateBullets(-1);
            Greenfoot.playSound("sounds/firebullet.wav");
        }
    }
}