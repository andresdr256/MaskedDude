import greenfoot.*;  

public class HardButton extends Button
{
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu(2));
        }
    }    
}
