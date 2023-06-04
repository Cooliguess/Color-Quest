import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    //movement parameters
    private int speed;
    
    //sprite
    private int numIdleFrames, numWalkFrames;
    
    private GreenfootImage[] idleRight, idleLeft, walkRight, walkLeft;
    private int animCount = 0, facer = 0;
    
    public Entity(int idle, String id, int walk, String wa, int speed, int face)
    {
        this.speed = speed;
        facer = face;
        numIdleFrames = idle;
        numWalkFrames = walk;
        idleRight = new GreenfootImage[numIdleFrames];
        idleLeft = new GreenfootImage[numIdleFrames];
        walkRight = new GreenfootImage[numWalkFrames];
        walkLeft = new GreenfootImage[numWalkFrames];
        initAnimSprite(id, wa, face);
    }
    public Entity(int idle, String id, int speed, int face)
    {
        this.speed = speed;
        facer = face;
        numIdleFrames = idle;
        idleRight = new GreenfootImage[numIdleFrames];
        idleLeft = new GreenfootImage[numIdleFrames];
        initAnimSprite(id, face);
    }
    public void act()
    {
        // Add your action code here.
    }
    public void moving()
    {
        
    }
    
    
    //accessing private variables
    public int getFacer()
    {
        return facer;
    }
    public int changeFacer()
    {
        if (facer == 0)
            facer = 1;
        else
            facer = 0;
        return facer;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int n)
    {
        speed = n;
    }
    public GreenfootImage[] getIdleRight()
    {
        return idleRight;
    }
    public GreenfootImage[] getIdleLeft()
    {
        return idleLeft;
    }
    public GreenfootImage[] getWalkRight()
    {
        return walkRight;
    }
    public GreenfootImage[] getWalkLeft()
    {
        return walkLeft;
    }
    
    
    
    
    // side - to - side animation & movement
    public void initAnimSprite(String id, String wa, int face)
    {
        for (int i = 0; i<numWalkFrames; i++)
        {
            String fileName = wa + (i+1) + ".png";
            walkRight[i] = new GreenfootImage(fileName);
            walkRight[i].scale(walkRight[i].getWidth()*5, walkRight[i].getHeight()*5);
            if (face == 1)
                walkRight[i].mirrorHorizontally();
        }
        
        for (int i = 0; i<numWalkFrames; i++)
        {
            String fileName = wa + (i+1) + ".png";
            walkLeft[i] = new GreenfootImage(fileName);
            walkLeft[i].scale(walkLeft[i].getWidth()*5, walkLeft[i].getHeight()*5);
            if (face == 0)
                walkLeft[i].mirrorHorizontally();
        }
        
        
        for (int i = 0; i<numIdleFrames; i++)
        {
            String fileName = id + (i+1) + ".png";
            idleRight[i] = new GreenfootImage(fileName);
            idleRight[i].scale(idleRight[i].getWidth()*5, idleRight[i].getHeight()*5);
            if (face == 1)
                idleRight[i].mirrorHorizontally();
        }
        
        for (int i = 0; i<numIdleFrames; i++)
        {
            String fileName = id + (i+1) + ".png";
            idleLeft[i] = new GreenfootImage(fileName);
            idleLeft[i].scale(idleLeft[i].getWidth()*5, idleLeft[i].getHeight()*5);
            if (face == 0)
                idleLeft[i].mirrorHorizontally();
        }
    }
    public void initAnimSprite(String id, int face)
    {
        for (int i = 0; i<numIdleFrames; i++)
        {
            String fileName = id + (i+1) + ".png";
            idleRight[i] = new GreenfootImage(fileName);
            idleRight[i].scale(idleRight[i].getWidth()*5, idleRight[i].getHeight()*5);
            if (face == 1)
                idleRight[i].mirrorHorizontally();
        }
        
        for (int i = 0; i<numIdleFrames; i++)
        {
            String fileName = id + (i+1) + ".png";
            idleLeft[i] = new GreenfootImage(fileName);
            idleLeft[i].scale(idleLeft[i].getWidth()*5, idleLeft[i].getHeight()*5);
            if (face == 0)
                idleLeft[i].mirrorHorizontally();
        }
    }
    
    
    public void moveR() ///////////////////////
    {
        //setLocation(getX()+speed, getY());
        animateWalkRight();
        facer = 0;
    }
    public void animateWalkRight() 
    {
        setImage(walkRight[animCount++ % numWalkFrames]);
    }
    public void moveL() ///////////////////////
    {
        //setLocation(getX()-speed, getY());
        animateWalkLeft();
        facer = 1;
    }
    public void animateWalkLeft() 
    {
        setImage(walkLeft[animCount++ % numWalkFrames]);
    }
    
    public void idleR() ////////////////////
    {
        animateIdleRight();
        facer = 0;
    }
    public void animateIdleRight()
    {
        setImage(idleRight[animCount++ % numIdleFrames]);
    }
    public void idleL() ///////////////////////
    {
        animateIdleLeft();
        facer = 1;
    }
    public void animateIdleLeft()
    {
        setImage(idleLeft[animCount++ % numIdleFrames]);
    }
}
