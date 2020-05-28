import greenfoot.*;  

public class GameOverScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    private int i = 0;
    private int score;
    
    
    public GameOverScreen(int score)
    {    
        super(1100, 500, 1);
        this.score = score;
        soundtrack.play();
    }
    
    public void act()
    {
        Greenfoot.delay(150);
        soundtrack.stop();
        Greenfoot.setWorld(new ScoreScreen(score));                        
    }
}
