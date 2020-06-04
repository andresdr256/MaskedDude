import greenfoot.*;

public class ScoreCounter extends Actor
{
    int score;
 
    public ScoreCounter()
    {
    }

    public ScoreCounter(int score)
    {
        this.score = score;
    }
    
    public void act() 
    {
        setImage(new GreenfootImage("Score: "+ score, 24, Color.GREEN, Color.BLACK));
    }    
    
    public void addScore(int score)
    {
        this.score += score;
    }

    public int getScore()
    {
        return score;
    }
}
