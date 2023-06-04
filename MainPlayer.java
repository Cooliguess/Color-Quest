import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainPlayer extends Entity
{
    private boolean finish = false;
    private double a = 100;
    private static boolean powered = false;
    
    //movement;
    private double vSpeed = 0;
    private int accel = 1;
    private int jumpHeight = -27;
    
    
    //lives
    private int h = 3;
    private Heart[] lives = new Heart[3];
    private boolean inv = false;
    
    
    private YouLose l = new YouLose();
    public MainPlayer(Heart one, Heart two, Heart three)
    {
        super(27, "MonoWiz/idle/MonoWiz_idle", 42, "MonoWiz/walk/MonoWiz_walk", 15, 0);
        idleR();
        lives[0] = one;
        lives[1] = two;
        lives[2] = three;
    }
    /**
     * Act - do whatever the MainPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moving();
        checkFalling();
        hitEnemy();
        portal();
        power();
        if (h <= 0) {
            powered = false;
            Greenfoot.setWorld(l);
        }
    }
    public void moving() 
    {
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX()+getSpeed(), getY());
            moveR();
        }
        else if (getFacer() == 0)
            idleR();
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) 
        {
            setLocation(getX()-getSpeed(), getY());
            moveL();
        }
        else if (getFacer() == 1)
            idleL();
        if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && onGround()) 
        {
            vSpeed = jumpHeight;
            fall();            
        }
        if (!finish)
        {
            while (getOneObjectAtOffset(getImage().getWidth()/2+1, 0, Ground.class) != null)
            {
                setLocation(getX()-1, getY());
            }   
            // check to left of actor
            while (getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, Ground.class) != null)
            {
                setLocation(getX()+1, getY());
            }
            while (getOneObjectAtOffset(getImage().getWidth()+1, 0, Zarko.class) != null)
            {
                setLocation(getX()-1, getY());
            }   
            // check to left of actor
            while (getOneObjectAtOffset(-getImage().getWidth()-1, 0, Zarko.class) != null)
            {
                setLocation(getX()+1, getY());
            }
            // check to left of actor
            while (getOneObjectAtOffset(-getImage().getWidth()-1, 0, Machine.class) != null)
            {
                setLocation(getX()+1, getY());
            }
        }
        if ((Greenfoot.isKeyDown("space") && a >= 100))
        {
            Actor bullet = new Bullet("Projectiles/white/white", 150, 20);
            if (getFacer() == 1) bullet.turn(180);
            if (getFacer() == 0) getWorld().addObject(bullet, getX()+85, getY());
            else getWorld().addObject(bullet, getX()-85, getY());
            bullet.move(30);
            a = 0;
        } 
        a++;
    }
    
    //portal collision
    public void portal()
    {
        if (isTouching(Portal.class)) {
            finish = true;
            powered = false;
        }
    }
    public boolean getFinish()
    {
        return finish;
    }
    public void setFinish()
    {
        finish = !finish;
    }
    //powerUp collision
    public void power()
    {
        if (isTouching(PowerUp.class))
            powered = true;
    }
    public static boolean getPowered()
    {
        return powered;
    }
    public void setPowered()
    {
        powered = !powered;
    }
    
    
    // gravity
    

    private void fall()
    {
        setLocation(getX(), getY() + (int)vSpeed);
        vSpeed += accel;
    }
    public boolean onGround() 
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()-27, Ground.class);
        return under != null;
        
        //works; however, if there are platforms, then != work
        //if (getY() <533)
        //    return false;
        //return true;
    }
    public void checkFalling()
    {
        if (!onGround())
        {
            fall();
        }
        else
            vSpeed = 0;
    }
    
    private int vf = 0;
    
    // interaction with danger
    public void hitEnemy() {
    if (!inv) {
        if ((isTouching(Groolog.class) && !powered) || isTouching(Halu.class) 
        || isTouching(Bullet.class)
        ) {
            h--;
            heartBoom();
            // play animation
            int knockbackSpeed = 10;
            if (getFacer() == 1) 
                knockbackSpeed = -knockbackSpeed;
            int knockbackDuration = 30;
            int knockbackCount = 0;
            int k = -10;
            Greenfoot.getKey(); 
            while (knockbackCount < knockbackDuration) {
                if (knockbackCount > 6) {
                    setLocation(getX() - knockbackSpeed, getY() + k);
                    k += accel;
                    if (getFacer() == 0) {
                        moveR(); // Change to the appropriate animation for moving right
                    } else {
                        moveL(); // Change to the appropriate animation for moving left
                    }
                }
                knockbackCount++;
                Greenfoot.delay(1);
            }
            setLocation(getX(), 503);
            inv = true;
        } else if (getY() > 800) {
            h--;
            heartBoom();
        }
        inv = true;
    }
    vf++;
    if (vf > 20) {
        inv = false;
        vf = 0;
    }
}

    


    public void heartBoom()
    {
        switch(h) {
            case 2:
                lives[2].kill();
                break;
            case 1:
                lives[1].kill();
                break;
            case 0:
                lives[0].kill();
                break;
            default:
                break;
        }
    }
    //559
    
    public int getH()
    {
        return h;
    }
    
    
    
    
}
