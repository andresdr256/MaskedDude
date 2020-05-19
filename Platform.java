import greenfoot.*;

public class Platform extends Actor
{
    public void act() 
    {
        scroll();
    }
    
    public void scroll(){
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()-5, getY());
        }
    }        
}