import greenfoot.*;

public class DifficultyButton extends Button
{
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new DifficultyScreen());
    }    
}