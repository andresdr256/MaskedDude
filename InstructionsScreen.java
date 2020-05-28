import greenfoot.*; 

public class InstructionsScreen extends World
{
    private int difficulty;
    
    public InstructionsScreen(int difficulty)
    {    
        super(1100, 500, 1); 
        
        this.difficulty = difficulty;

        prepare();
    }
    
    private void prepare()
    {
        addObject(new MainMenuButton(difficulty), 960, 290);
        addObject(new PlayButton(difficulty), 960, 340);
    }
}