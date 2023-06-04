import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private GreenfootImage backgroundImage;
    private Button play;
    private boolean c = false;
    private GreenfootSound click = new GreenfootSound("Click.mp3");
    private Level1 startLvl;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        //set the image of the opening image;
        backgroundImage = new GreenfootImage("Background/screen.png");
        backgroundImage.scale(backgroundImage.getWidth()/2, backgroundImage.getHeight()/2);
        setBackground(backgroundImage);
        
        //addObject(new Logo(), 550, 120);
        
        //add buttons
        play = new Button("tempPlay");
        addObject(play, 605, 558);
        play.resize(100, 100);
        
        //start world
        startLvl = new Level1();        
    }
    
    public void act()
    {
        {
            if (Greenfoot.mouseClicked(play))
            {
                //sound played
                click.play();
                Greenfoot.setWorld(startLvl);
            }
        }
    }
}
