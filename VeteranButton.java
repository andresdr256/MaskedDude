import greenfoot.*;  

public class VeteranButton extends Button
{
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu(3));
        }
    }    
}
