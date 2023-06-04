import greenfoot.*;
import greenfoot.Actor;
public class Level1 extends SWorld {
    private MainPlayer player;
    private Level2 startLv2;
    GreenfootSound backgroundMusic;
    public Level1() {
        //   winx winy cell fullx fully
        super(1200, 800, 1, 3800, 1400);
        backgroundMusic = new GreenfootSound("level1.mp3");
        prepare();
        startLv2 = new Level2();
    }
    public void act()
    {
        backgroundMusic.playLoop();
        super.act();
        if (((MainPlayer)mainActor).getFinish())
        {
            backgroundMusic.stop();
            Greenfoot.setWorld(startLv2);
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
        GreenfootImage bg = new GreenfootImage("Background/scene-modified.jpg");
        setScrollingBackground(bg);


        for (int i = 0; i<75; i++)
        {
            if (!(i > 23)){
                addObject(new Ground("tile02"), 80+(i*160), 1050);
            }
            if ((i > 23 && i <28) && (i % 2 != 0)){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground("tile03"), 80+(i*160), 1300-(((j+(i*4)-92)*20)));
                }

            }
            if (i>28){
                for (int j = 0; j < 20; j++){
                    addObject(new Ground("tile03"), 80+(i*160),1440-(j*60));
                }

            }
            if (i == 20){
                addObject(new Ground("tile03"), 80+(i*160), 500);
            }
        }


        
        addObject(new Groolog(890),1000,890, true);
        addObject(new Groolog(890),2400,890, true);
        addObject(new Groolog(1300),10300,1300, true);
        Halu halu = new Halu();
        addObject(halu, 3280, 890, true);
        addObject(new Halu(), 4240, 100, true);

        Portal g = new Portal();
        addObject(g, 2450, 890, true);

    }
    // width number of actors

}