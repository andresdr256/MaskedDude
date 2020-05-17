import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExitButton extends Button
{
    public void act() 
    {
        checkMouse(); 
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.stop();
        }
    }    
}
