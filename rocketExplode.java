import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocketExplode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rocketExplode extends Actor
{
    private int fallSpeed;
    GreenfootImage image = new GreenfootImage("images/rocket-explode2.png");
    GreenfootImage destroy = new GreenfootImage("images/rocket-destroy.png");
    private int delay = 2;
    private boolean exploded = false;
    private int fallRotation = 15;
    
    public rocketExplode(int fallSpeed)
    {
        this.fallSpeed = fallSpeed;
        setImage(image);
    }
    
    /**
     * Act - do whatever the rocketExplode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay >=0) {
            delay--;
        }
        else if ( !this.exploded){
            MyWorld world = (MyWorld) getWorld();
        
            turn(this.fallRotation);
            int x = getX();
            int y = getY()+this.fallSpeed;
            setLocation(x, y);
            
            if(y > world.getHeight()-5)
            {
                Greenfoot.playSound("sounds/rocketExplosion2.wav");
                this.exploded =true;
                getImage().setTransparency(0);
                world.getBackground().drawImage(destroy,x-50, world.getHeight()-50);
                //setImage(destroy);
                
                //world.removeObject(this);                
            }
            
            delay =2;
        }
        
    }    
}
