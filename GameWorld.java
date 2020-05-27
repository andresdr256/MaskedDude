import greenfoot.*;  

public class GameWorld extends World
{
    HealthBar healthbar = new HealthBar();

    public GameWorld()
    {    
        super(1100, 500, 1, false);
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }        
}
