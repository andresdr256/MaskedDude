import greenfoot.*;  

public class GameWorld extends World
{
    HealthBar healthbar = new HealthBar();

    public GameWorld()
    {    
        super(1100, 500, 1, false);

        prepare();
    }
    
    private void prepare()
    {
        addObject(healthbar, 200, 40);        
    }

    public HealthBar getHealthBar()
    {
        return healthbar;
    }        
}
