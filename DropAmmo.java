import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Increases total bullet ammo in rocket
 * 
 * @author Elsa Ahmed 
 * @version December 2020
 */
public class DropAmmo extends Actor
{
    GreenfootImage image = new GreenfootImage("images/gold-ball.png"); //image of gold ball
    /**
     *  contructor for DropAmmo class
     */
    public DropAmmo()
    {
        setImage(image); //sets image
        image.scale(35,35); //image size
    }
    /**
     * falls down from top of the screen at random y position
     */
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        //ammo falls from top of screen
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
