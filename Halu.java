import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.lang.Math.*;
/**
 * Write a description of class Groolog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Halu extends Organism
{
    private int c = 500;
    /**
     * Act - do whatever the Groolog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        security();
    }
    public Halu()
    {
        super(42, "Monsters/Halu/Halu", 2, 1, 1);
        setImage(getWalkDown()[0]);
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
        if (c<=200 || isTouching(Ground.class))
        {
            if (getFacer() == 0)
            {
                setLocation(getX(), getY()+getSpeed());
                moveU();
            }
            else
            {
                setLocation(getX(), getY()-getSpeed());
                moveD();
            }
            c++;
        }
        if (c>200 || isTouching(Ground.class))
        {
            c = 0;
            changeFacer();
        }
    }
}
