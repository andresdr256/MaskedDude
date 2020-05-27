import greenfoot.*;  

public class PlayButton extends Button
{
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new FirstWorld());
        }
    }    
}
