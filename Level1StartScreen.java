import greenfoot.*;  

public class Level1StartScreen extends World
{
    public Level1StartScreen()
    {    
        super(1100, 500, 1); 
    }
    
    public void act(){        
        Greenfoot.delay(190);
        Greenfoot.setWorld(new FirstWorld());
    }
}
