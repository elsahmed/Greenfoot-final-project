import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket after destroyed animation
 * 
 * @author Elsa Ahmed 
 * @version January 2021
 */
public class rocketExplode extends Actor
{
    private int fallSpeed;
    GreenfootImage image = new GreenfootImage("images/rocket-explode2.png");
    GreenfootImage destroy = new GreenfootImage("images/rocket-destroy.png");
    private int delay = 2;
    private boolean exploded = false;
    private int fallRotation = 15;
    
    /**
     * constructor for rocketExplode
     */
    public rocketExplode(int fallSpeed)
    {
        this.fallSpeed = fallSpeed;
        setImage(image);
    }
    
    /**
     * animates the rocket falling once lives are over
     */
    public void act() 
    {
        if (delay >=0) 
        {
            delay--; // delay in between the rocket spinning
        } 
        else if (!this.exploded)
        {
            //movement and rotation of rocket falling
            MyWorld world = (MyWorld) getWorld();        
            turn(this.fallRotation);
            int x = getX();
            int y = getY()+this.fallSpeed;
            setLocation(x, y);            
            if(y > world.getHeight()-5)
            {
                // rocket hits end of screen
                Greenfoot.playSound("sounds/rocketExplosion2.wav");
                this.exploded =true;
                getImage().setTransparency(0);
                world.getBackground().drawImage(destroy,x-50, world.getHeight()-50); //sets destroyed image               
            }            
            delay=2;
        }        
    }    
}
