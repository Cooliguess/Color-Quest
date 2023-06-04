import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Entity
{
    
    
    
    public Portal()
    {
        super(36, "Portal/Portal", 0, 1);
        setImage(getIdleLeft()[0]);
    }
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getFacer() == 1)
            idleL();
        else
            idleR();
    }
}
