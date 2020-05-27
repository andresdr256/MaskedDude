import greenfoot.*;

public class FloorLevel2 extends Floor
{
    public boolean scroll()
    {
        boolean floorChanged = false;

        if(Greenfoot.isKeyDown("right"))
        {        
            if(getX() == -550)
            {
                setLocation(1650, 250);
                floorChanged = true;
            }
            setLocation(getX()-5, getY());
        }
        
        return floorChanged;
    }


}
