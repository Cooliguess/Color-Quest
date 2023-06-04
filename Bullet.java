import greenfoot.*;

public class Bullet extends Entity
{
    private int c = 0;
    private int stop;
    private int speed;
    public Bullet(String s, int x, int y)
    {
        super(6, s, 10, 0);
        stop = x;
        speed =y;
    }

    public void act()
    {
        move(speed);
        idleR();
        c++;
        if (c >= stop)
        {
            getWorld().removeObject(this);
        }
    }
}
