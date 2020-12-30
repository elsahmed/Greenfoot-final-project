import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DropAmmo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropAmmo extends Actor
{
    GreenfootImage image = new GreenfootImage("images/gold-ball.png");    
    public DropAmmo()
    {
        setImage(image);
        image.scale(50,50);
    }
    /**
     * Act - do whatever the DropAmmo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if (!world.isGameOver()) 
        {
            int x = getX();
            int y = getY()+3;
            setLocation(x, y); 
            if(y > world.getHeight())
            {
                world.removeObject(this); 
            } 
        }
    }    
}
