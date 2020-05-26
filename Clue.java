import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class clue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clue extends Actor
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")){
            move(-5);
        }
    }    
}
