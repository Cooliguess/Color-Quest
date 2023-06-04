import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Machine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Machine extends Entity
{
    private int a = 20;
    private int c = 0;
    
    public Machine()
    {
        super(7, "Monsters/Zarko/Machine/shoot/Machine_shoot", 0, 1);
        setImage(getIdleLeft()[0]);
    }
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getFacer() == 1)
            idleL();
        else
            idleR();
        Actor bullet = new Bullet("Projectiles/red/red", 1000, 5);
        if (c <=100)
        {
            if (a >= 20) {
                if (getFacer() == 1) bullet.turn(180);
                if (getFacer() == 0) getWorld().addObject(bullet, getX()+75, getY());
                else getWorld().addObject(bullet, getX()-75, getY());
                bullet.move(32);
                a = 0;
            }
        }
        a++;
        c++;
        if (c>200)
            c = 0;
    }
}
