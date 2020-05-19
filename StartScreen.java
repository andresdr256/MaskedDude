import greenfoot.*;

public class StartScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    
    public StartScreen()
    {    
        super(1100, 500, 1); 
    }
    
    public void act(){        
        play();
        Greenfoot.delay(190);
        Greenfoot.setWorld(new Menu());
    }

    public void play(){
        soundtrack.play();
    }
    
    public void stop(){
        soundtrack.stop();
    }     
}
