import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Groolog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Groolog extends Entity
{
    private int c = 0;
    private int y;
    /**
     * Act - do whatever the Groolog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        security();
        hitEnemy();
    }
    public Groolog(int y)
    {
        super(32, "Monsters/Groolog/idle/Groolog_idle", 40, "Monsters/Groolog/walk/Groolog_walk", 2, 1);
        setImage(getIdleLeft()[0]);
        this.y = y;
    }
    public void security()
    {
        /*Random rand = new Random();
        int k = rand.nextInt(100)+1;
        
        if (k<=100)
        {
            if (getFacer() == 0)
            {
                setLocation(getX()+getSpeed(), getY());
                moveR();
            }
            else
            {
                setLocation(getX()-getSpeed(), getY());
                moveL();
            }
            c++;
        }
        else
        {
            if (getFacer() == 0)
                idleR();
            else
                idleL();
        }*/
        if (c<=200)
        {
            if (getFacer() == 0)
            {
                setLocation(getX()+getSpeed(), getY());
                moveR();
            }
            else
            {
                setLocation(getX()-getSpeed(), getY());
                moveL();
            }
            c++;
        }
        if (c >200 && c <=500)
        {
            if (getFacer() == 0)
                idleR();
            else
                idleL();
            c++;
        }
        if (c>500)
        {
            c = 0;
            changeFacer();
        }
    }
    public void hitEnemy()
    {
        if (isTouching(MainPlayer.class) && MainPlayer.getPowered()) {
            
            //play animation
                int knockbackSpeed = 10;
                if (getFacer() == 1) 
                    knockbackSpeed = -knockbackSpeed;
                int knockbackDuration = 30; 
                int knockbackCount = 0; 
                int k = -10;
                Greenfoot.getKey(); 
                while (getY() <= y) {
                    setLocation(getX() - knockbackSpeed, getY() + k);
                    k += 1;
                    Greenfoot.delay(1);
                }
                setLocation(getX(), y);
        }
    }
}
