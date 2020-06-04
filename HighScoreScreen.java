import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoreScreen extends World
{

    public HighScoreScreen()
    {
        super(1100, 500, 1);

        prepare();
    }
    
    private void prepare()
    {
        addObject(new WriteOut(), 200,295);
        addObject(new ReadIn(), 400,295);
    }
}
