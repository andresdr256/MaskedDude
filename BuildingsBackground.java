import greenfoot.*;  

public class BuildingsBackground extends Actor
{   
    public void scroll()
    {
        if(Greenfoot.isKeyDown("right"))
        {        
            if(getX() == -550)
            {
                setLocation(1649, 250);
            }
        
            setLocation(getX()-1, getY());
        }
    }
}
