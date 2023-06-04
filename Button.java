import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private MouseInfo m;
    private GreenfootImage idleImage;
    private GreenfootImage hoverImage;
    String image;
    private boolean isHover;
    private boolean isClick;
    public Button(String image)
    {
        isHover = false;
        isClick = false;
        this.image=image;
        initAnim();
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkMouse();
    }
    public void checkMouse()
    {
        m = Greenfoot.getMouseInfo();
        if (m != null)
        {
            //hovering?
            if (!isHover && Greenfoot.mouseMoved(this))
                isHover = true;
            if (isHover && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
                isHover = false;
            if (isHover)
                this.setImage(hoverImage);
            else
                this.setImage(idleImage);
        }
    }
    public void initAnim()
    {
        idleImage = new GreenfootImage("Background/"+image+".png");
        hoverImage = new GreenfootImage("Background/"+image+"_hover.png");
        setImage(idleImage);
    }
    public void resize(int width, int height)
    {
        idleImage.scale(width,height);
        hoverImage.scale(width,height);
    }
}
