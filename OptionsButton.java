import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class OptionsButton extends Button
{
    public void act() 
    {
        checkMouse();
                
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Options());
        }
    }    
}