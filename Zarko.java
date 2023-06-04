import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zarko here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zarko extends Entity
{
    private int a = 0;
    private int c = 0;
    private Machine m;
    private int h = 5;
    private int animCount = 0;
    private int phase = 0;
    private boolean inv = false;
    public boolean dead = false;
    private boolean once = true;
    
    private int x = 0;
    private int y = 0;
    public Zarko(Machine m)
    {
        super(28, "Monsters/Zarko/idle/Zarko_idle", 30, "Monsters/Zarko/stage2/Zarko_transition", 2, 1);//32, "Monsters/Zarko/walk/Zarko_walk", 2, 1);
        setImage(getIdleLeft()[0]);
        this.m = m;
    }
    /**
     * Act - do whatever the Zarko wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if (c<=29)
        //    moveL();
        //c++;
        if (h>0 && phase == 0) {
            idleL();
            ye();
            hitEnemy();
            a++;
            if (a>500)
                inv = false;
        }
        else
        {
            // Transformation animation
            animateWalkLeft();
            a++;
            if (a > 100) {
                // Transition to phase 1
                phase = 1;
                inv = false;
                if (once) {
                    h= 20;
                    once = false;
                }
                getWorld().removeObject(m);
                // Reset variables for phase 1 actions
                a = 0;
                c = 0;
            }
        
            // Phase 1 actions
            if (c <= 100) {
                if (a >= 25) {
                    Actor bullet = new Bullet("Projectiles/red/red", 1000, 5);
                    bullet.turn(180);
            
                    int offsetY = (int) (300 * Math.sin(Math.toRadians(y * 10))) - 200;
                    getWorld().addObject(bullet, getX() - 175, getY() - 200 - offsetY);
            
                    bullet.move(32);
                    a = 0;
                    x++;
                    y++;
                }
            }



            a++;
            c++;
            hitEnemy();
            if (h <= 0) {
                dead = true;
            }
            if (c > 200) {
                c = 0;
            }
        }
    }
    


    public void ye()
    {
        m.setLocation(getX(), getY());
    }
    public void hitEnemy() 
    {
        //if (!powered) {
            if (!inv) {
                if (isTouching(Bullet.class)) {
                    h--;
                    inv = true;
                }
            }
            
        //}
        
    }
    public void moveL() ///////////////////////
    {
        //setLocation(getX()-speed, getY());
        animateWalkLeft();
    }
    public void animateWalkLeft() 
    {
        if (animCount<30) {
            setImage(getWalkLeft()[animCount]);
            Greenfoot.delay(1);
            animCount++;
        }
    }
}
