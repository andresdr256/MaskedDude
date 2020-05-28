import greenfoot.*;  

public class GameWorld extends World
{
    int score;

    ScoreCounter scoreCounter = new ScoreCounter();

    HealthBar healthbar = new HealthBar();
    Timer timer = new Timer();

    public GameWorld()
    {    
        super(1100, 500, 1, false);
        addObject(timer, 850, 35);
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }        
    
    public ScoreCounter getScoreCounter()
    {
        return scoreCounter;
    }
}
