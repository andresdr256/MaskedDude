import greenfoot.*;  

public class Timer extends Actor
{
    private int seconds = 50;
    private int secondsDelay;
    
    public void act() 
    {
        if(secondsDelay > 60)
        {    
            seconds--;
            secondsDelay = 0;
        
        }else
            secondsDelay++;
        
        
        setImage(new GreenfootImage("Time: "+ seconds, 24, Color.WHITE, Color.BLACK));
    }        
    
    public int getTime()
    {
        return seconds;
    }
}
