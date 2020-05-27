import greenfoot.*;  

public class FinalBackground extends Actor
{
    public boolean scroll()
    {
        boolean backGroundChanged = false;

        if(Greenfoot.isKeyDown("right"))
        {        
            if(getX() == -550)
            {
                setLocation(1650, 250);
                backGroundChanged = true;
            }
            setLocation(getX()-5, getY());
        }
        
        return backGroundChanged;
    }
}
