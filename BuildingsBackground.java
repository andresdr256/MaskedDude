import greenfoot.*;  

public class BuildingsBackground extends Actor
{
    private int counter = 0;
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()-1, getY());
        }
    }    
}
