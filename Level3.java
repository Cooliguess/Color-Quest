import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends SWorld
{
    GreenfootSound backgroundMusic;
    private YouWin a;
    private Zarko z;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {
        super(1200, 800, 1, 1920, 1080);
        backgroundMusic = new GreenfootSound("boss1.mp3");
        backgroundMusic.setVolume(50);
        prepare();
        a = new YouWin();
    }
    public void act()
    {
        backgroundMusic.playLoop();
        
        super.act();
        if (z.dead) {
            Greenfoot.setWorld(a);
        }
    }
    public void started()
    {
        backgroundMusic.playLoop();
    }
    public void stopped()
    {
        backgroundMusic.pause();
    }
    
    public void prepare()
    {
        Heart one = new Heart();
        addObject(one, 90, 75, false);
        Heart two = new Heart();
        addObject(two, 250, 75, false);
        Heart three = new Heart();
        addObject(three, 410, 75, false);
        setMainActor(new MainPlayer(one, two, three), 0, 0);
        mainActor.setLocation(-300, 600);
        
        
        GreenfootImage bg = new GreenfootImage("Background/boss.png");
        setScrollingBackground(bg);
        
        
        Machine m = new Machine();
        addObject(m, 0, 0);
        z = new Zarko(m);
        addObject(z, 1450, 580);
        
        for (int i = 0; i<75; i++)
        {
            if (i >= 4 && i <= 6)
            {
                addObject(new Ground("tile02"), (i*100)-300, 400);
            }
            else
            {
                if (i == 7 || i == 3)
                {
                    
                }
                else
                    addObject(new Ground("tile02"), (i*100)-300, 740);
            }
            
        }
    }
}
