import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket is the main actor that is controlled by the user
 * 
 * @author Elsa Ahmed 
 * @version December 2020
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
     * User controles the movement of the rocket by certain keys
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
     * check to see if rocket has come into contact with any object
     */
    public void hit()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Meteoroid.class))
        {
            removeTouching(Meteoroid.class);             
            GreenfootImage crack = new GreenfootImage("images/rocket-cracked" + (hit) + ".png");
            setImage(crack); // sets cracked rocket image
            Greenfoot.playSound("sounds/rocketExplosion.wav"); 
            
            //ends the game and plays rocket falling animation
            if(this.hit == world.TOTLIVES-1)
            {                
                getImage().setTransparency(0);
                rocketExplode rocketExp = new rocketExplode(15);
                world.addObject(rocketExp, getX(), getY());
                world.gameOver();
            }
            this.hit++;
        }
        //updates the bullet total
        if(isTouching(DropAmmo.class))
        {
            removeTouching(DropAmmo.class);
            world.updateBullets(BULLET_PACK);
        }
    }
    
    /**
     *  shoots the bullets from the rocket
     */
    public void fireBullet()
    {
        MyWorld world = (MyWorld) getWorld();
        if(this.fire >= 7 && world.ammo > 0) // delay bullet shots = 7
        {
            Bullet bullet = new Bullet(15, getRotation());
            world.addObject(bullet, getX(), getY());
            this.fire=0;
            world.updateBullets(-1); //updates the bullets total
            Greenfoot.playSound("sounds/firebullet.wav"); //plays sound
        }
    }
}