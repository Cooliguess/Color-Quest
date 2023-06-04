import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class SWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * WINDOW refers to the screen the player can actually see, the visible screen, POV, whatever you wanna call it (short term = win)
 * FULL WORLD refers to the entire world that the player can only see a portion of through the window.
 * 
 * **so in a way, it would be like POV=WINDOW, and Earth's surface area = FULL WORLD, in a 2d way**
 * 
 */
public class SWorld extends World
{
    //so the Full World's length and width
    private int fullWidth, fullHeight;
    //the space in the WINDOW (the area the player can see, or, to the effect, the camera) in which the mainplayer can move
    private int minMovableX, maxMovableX, minMovableY, maxMovableY; 
    //once reasing max/min movable x/y, this var says how much it should increment per 'scroll'
    private int incPerScrollX, incPerScrollY; 
    // indicates scrolling directions (0 = none, 1 = horizontal, 2 = vertical, 3 = both)
    private int scrollType; 
    Actor mainActor = null; // mainPlayer
    private List<Actor> scrollingActors = new ArrayList();
    private GreenfootImage background = null;
    
    /**
     * Constructor for objects of class SWorld.
     * 
     */
    public SWorld(int winWide, int winHigh, int cellSize, int fullW, int fullH)
    {    
        super(winWide, winHigh, cellSize, false);
        scrollType = 1;
        fullWidth = fullW;
        fullHeight = fullH;
    }
    /**
     * x&y range is the amount of breathing room in the window in which 
     * the player can move before starting the scrolling mechanism
     */
    public void setMainActor(Actor main, int xRange, int yRange) 
    {
        super.addObject(main, getWidth()/2, getHeight()/2); // width/2 and height/2 means the center of the world
        mainActor = main;
        xRange = (int) Math.min(xRange, getWidth());
        yRange = (int) Math.min(yRange, getHeight());
        minMovableX = getWidth()/2-xRange/2;
        maxMovableX = getWidth()/2+xRange/2;
        minMovableY = getHeight()/2-yRange/2;
        maxMovableY = getHeight()/2+yRange/2;
    }
    /**
     * the image u want as the background
     */
    public void setScrollingBackground(GreenfootImage scrollingBackground)
    {
        background = new GreenfootImage(scrollingBackground);
        background.scale(fullWidth*getCellSize(), fullHeight*getCellSize());
        //setBackground(background);
        scrollBackground();
    }
    
    
    
    public void addObject(Actor obj, int xLoc, int yLoc, boolean scroller)
    {
        super.addObject(obj, xLoc, yLoc);
        if (scroller) 
            scrollingActors.add(obj);
    }
    public void addObject(Actor obj, int xLoc, int yLoc)
    {
        addObject(obj, xLoc, yLoc, true);
    }
    public void removeObject(Actor obj)
    {
        if (obj == null) 
            return;
        if (obj.equals(mainActor)) 
            mainActor = null;
        else 
            scrollingActors.remove(obj);
        super.removeObject(obj);
    }
    public void removeObjects(List<Actor>objs)
    {
        for (Actor obj : objs) removeObject(obj);
    }
    
    
    
    public void act()
    {
        scrollObjects();
        scrollBackground();
        
    }
    
    
    
    private void scrollBackground()
    {
        int w = getWidth(), h = getHeight(), c = getCellSize(), bw = background.getWidth(), bh = background.getHeight();
        getBackground().drawImage(background, (w*c-bw)/2-incPerScrollX*c, (h*c-bh)/2-incPerScrollY*c);
    }
    private void scrollObjects()
    {
        int dx = 0, dy = 0;
        if (mainActor.getX() < minMovableX) 
            dx = minMovableX-mainActor.getX();
        if (mainActor.getX() > maxMovableX)
            dx = maxMovableX-mainActor.getX();
        if (mainActor.getY() < minMovableY)
            dy = minMovableY-mainActor.getY();
        if (mainActor.getY() > maxMovableY)
            dy = maxMovableY-mainActor.getY();
        
            
        
        
        int dxStore = dx, dyStore = dy;
        incPerScrollX-=dx;
        incPerScrollY-=dy;
        
        
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        
        
        dx = 0;
        dy = 0;
        if (incPerScrollX > fullWidth/2-getWidth()/2) 
            dx = incPerScrollX-(fullWidth/2-getWidth()/2);
        // so why incPerScrollX why fullWidth/2 - width/2?
        if (incPerScrollX < getWidth()/2-fullWidth/2) 
            dx = incPerScrollX-(getWidth()/2-fullWidth/2);
        if (incPerScrollY > fullHeight/2-getHeight()/2) 
            dy = incPerScrollY-(fullHeight/2-getHeight()/2);
        if (incPerScrollY < getHeight()/2-fullHeight/2) 
            dy = incPerScrollY-(getHeight()/2-fullHeight/2);
        
            
        dxStore+=dx;
        dyStore+=dy;
        incPerScrollX-=dx;
        incPerScrollY-=dy;
        
        
        
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
        for (Object obj: scrollingActors)
        {
            Actor actor = (Actor)obj;
            actor.setLocation(actor.getX()+dxStore, actor.getY()+dyStore);
        }
        
        
        
        dx=0;
        dy=0;
        
        if (mainActor.getX() < 0) 
            dx = 0-mainActor.getX();
        if (mainActor.getX() > getWidth()-1) 
            dx = (getWidth()-1)-mainActor.getX();
        if (mainActor.getY() < 0) 
            dy = 0-mainActor.getY();
        if (mainActor.getY() > getHeight()-1) 
            dy = (getHeight()-1)-mainActor.getY();
        if (dx == 0 && dy == 0) 
            return;
            
            
        
        
        mainActor.setLocation(mainActor.getX()+dx, mainActor.getY()+dy);
    }
    
    
    
    public int getincPerScrollX()
    {
        return incPerScrollX;
    }
    public int getincPerScrollY()
    {
        return incPerScrollY;
    }
    public int getIncPerScrollX()
    {
        return incPerScrollX;
    }
    public int getIncPerScrollY()
    {
        return incPerScrollY;
    }
}
