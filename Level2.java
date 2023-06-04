import greenfoot.*;

public class Level2 extends SWorld {
    private MainPlayer player;
    private Level3 startLv3;
    GreenfootSound backgroundMusic;
    public Level2() {    
        //   winx winy cell fullx fully
        super(1200, 800, 1, 11920, 1400);
        backgroundMusic = new GreenfootSound("level2.mp3");
        backgroundMusic.setVolume(35);
        prepare();
        startLv3 = new Level3();
        
    }
    public void act(){
        backgroundMusic.playLoop();
        super.act();
        if (((MainPlayer)mainActor).getFinish())
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(startLv3);
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
    

    private void prepare() {
        Heart one = new Heart();
        addObject(one, 90, 75, false);
        Heart two = new Heart();
        addObject(two, 250, 75, false);
        Heart three = new Heart();
        addObject(three, 410, 75, false);
        setMainActor(new MainPlayer(one, two, three), 0, 0);
        mainActor.setLocation(93, 200);
        
        GreenfootImage bg = new GreenfootImage("Background/556524-modified.jpg");
        setScrollingBackground(bg);
        
        
        for (int i = 0; i<75; i++)
        {
            if (!(i > 23) && !(i>=16 && i<=18)){
                addObject(new Ground("tile02"), 80+(i*160), 1050);
            }
            if ((i > 23 && i <28) && (i % 2 != 0)){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground("tile02"), 80+(i*160), 1300-(((j+(i*4)-92)*20)));
                }
                
            }
            if (i>28){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground("tile02"), 80+(i*160),1440-(j*60));
                }
                
            }
            if (i == 20){
                addObject(new Ground("tile03"), 80+(i*160), 500);
            }
            if (i == 17)
            {
                addObject(new Ground("tile03"), 80+(i*160), 700);
            }
        }
        
        
        
        addObject(new Groolog(890),1000,890, true);
        addObject(new Groolog(890),2400,890, true);
        addObject(new Groolog(1300),10300,1300, true);
        Halu halu = new Halu();
        addObject(halu, 3280, 890, true);
        addObject(new Halu(), 4240, 100, true);
        addObject(new Halu(), 3280, 100, true);
        Portal g = new Portal();
        addObject(g, 6500, 150, true);
        PowerUp p = new PowerUp("red");
        addObject(p, 300, 600, true);
        
        
    }
    // width * number of actors
    
}




















/*import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*public class Level2 extends SWorld
{
    private MainPlayer player;
    private Level3 startLv3;
    public Level2() {    
        //   winx winy cell fullx fully
        super(1200, 800, 1, 11920, 1400);
        prepare();
        startLv3 = new Level3();
        
        
    }
    public void act(){
        super.act();
        if (mainActor.getX() == 11900)
        {
            //sound played
            Greenfoot.setWorld(startLv3);
        }
    }
    
    

    private void prepare() {
        Heart one = new Heart();
        addObject(one, 90, 75, false);
        Heart two = new Heart();
        addObject(two, 250, 75, false);
        Heart three = new Heart();
        addObject(three, 410, 75, false);
        setMainActor(new MainPlayer(one, two, three), 0, 0);
        mainActor.setLocation(93, 200);
        
        GreenfootImage bg = new GreenfootImage("Background/556524.jpg");
        setScrollingBackground(bg);
        
        
        for (int i = 0; i<75; i++)
        {
            if (!(i > 23)){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground(), 80+(i*160),1440-(j*60));
                }
            }
            if ((i > 23 && i <28) && (i % 2 != 0)){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground(), 80+(i*160), 150+(((j+(i*4)-92)*20)));
                }
            }
            if (i>28){
                addObject(new Ground(), 80+(i*160),1050);
            }
            if (i == 20 || i == 38 || i ==73 || (i >= 43 && i <47)){
                
            }
        }
        
        
        Groolog groolog = new Groolog();
        addObject(groolog,1000,890, true);
        addObject(new Groolog(),2400,890, true);
        addObject(new Groolog(),10300,1300, true);
        Halu halu = new Halu();
        addObject(halu, 3280, 890, true);
        addObject(new Halu(), 4240, 100, true);
        
        Portal g = new Portal();
        addObject(g, 12000, 150, true);
        PowerUp p = new PowerUp("red");
        addObject(p, 300, 600, true);
        
    }
    }*/
