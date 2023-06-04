import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * red - 
 * green - shooting
 * blue - 
 * yellow - speed
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    private String color;
    private boolean isCollected = false;
    //sprite
    private int numFrames = 24;
    private GreenfootImage[] idle;
    private int animCount = 0;
    
    public PowerUp(String c)
    {
        color = c;
        idle = new GreenfootImage[numFrames];
        for (int i = 0; i<numFrames; i++)
        {
            String fileName = "PowerUps/" + color + "/" + color + "Gem" + (i+1) + ".png";
            idle[i] = new GreenfootImage(fileName);
            idle[i].scale(idle[i].getWidth()*5, idle[i].getHeight()*5);
        }
    }
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate();
        if (isTouching(MainPlayer.class))
        {
            getWorld().removeObject(this);
        }
    }
    public void animate() 
    {
        setImage(idle[animCount++ % numFrames]);
    }
    public void setIsCollected()
    {
        isCollected = !isCollected;
    }
    public String getColor()
    {
        return color;
    }
}
