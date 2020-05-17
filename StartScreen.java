import greenfoot.*;

public class StartScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    
    public StartScreen()
    {    
        super(1100, 500, 1); 

        prepare();
    }

    private void prepare(){
        addObject(new LogoStartScreen(), 530,250);
    }
    
    public void act(){        
        soundtrack.play();
        Greenfoot.delay(190);
        Greenfoot.setWorld(new Menu());
        soundtrack.stop();
    }
    
    
    
}
