import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScoresButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoresButton extends Button
{
    HighScoreTable highScoreTable = new HighScoreTable();
    private boolean flag = false;
    /**
     * Act - do whatever the HighScoresButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouse();
        //World livesIn = getWorld();
                
        if(Greenfoot.mouseClicked(this) && flag == false)
        {
            getWorld().addObject(highScoreTable,800, 250);
            flag = true;
        }
        else if(Greenfoot.mouseClicked(this) && flag == true)
        {
            getWorld().removeObject(highScoreTable);
            flag = false;
        }
    }
}
