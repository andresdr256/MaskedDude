import greenfoot.*;

public class ScoreScreen extends World
{
    MainMenuButton mainMenuButton = new MainMenuButton(1);

    public ScoreScreen(int score)
    {    
        super(1100, 500, 1); 
        ScoreCounter scoreCounter = new ScoreCounter(score);
        addObject(scoreCounter, 150, 200);
        addObject(mainMenuButton, 900, 400);
    }
}
