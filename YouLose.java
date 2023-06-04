import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouLose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouLose extends World
{
    private GreenfootImage backgroundImage;
    private Button play;
    private boolean c = false;
    private GreenfootSound click = new GreenfootSound("Click.mp3");
    private Level3 startLvl;
    /**
     * Constructor for objects of class YouLose.
     * 
     */
    public YouLose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        //set the image of the opening image;
        backgroundImage = new GreenfootImage("Background/lose.png");
        backgroundImage.scale(backgroundImage.getWidth()/2, backgroundImage.getHeight()/2);
        setBackground(backgroundImage);
        
        
    }
    
    public void act()
    {
        
    }
}
