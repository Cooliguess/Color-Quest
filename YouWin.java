import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends World
{
    private GreenfootImage backgroundImage;
    private boolean a = true;
    /**
     * Constructor for objects of class YouLose.
     * 
     */
    public YouWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        //set the image of the opening image;
        backgroundImage = new GreenfootImage("Background/win.png");
        backgroundImage.scale(backgroundImage.getWidth()/2, backgroundImage.getHeight()/2);
        setBackground(backgroundImage);
        
    }
    
    public void act()
    {
        
    }
}
