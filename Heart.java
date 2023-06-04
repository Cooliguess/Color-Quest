import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    private GreenfootImage[] death = new GreenfootImage[25];
    private boolean dead = false;
    private int animCount = 0;
    
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Heart()
    {
        for (int i = 0; i<25; i++)
        {
            String fileName = "Heart/heart" + (i+1) + ".png";
            death[i] = new GreenfootImage(fileName);
            death[i].scale(death[i].getWidth()*5, death[i].getHeight()*5);
        }
        setImage(death[0]);
    }
    public void act()
    {
        explosion();
        if (animCount>25)
            getWorld().removeObject(this);
    }
    public void kill()
    {
        dead = true;
    }
    public void explosion() 
    {
        if (dead && animCount<25) {
            setImage(death[animCount++ % 25]);  
        }
    }
}
