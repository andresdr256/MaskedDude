import greenfoot.*;

public class Options extends World
{
   private int difficulty;
   
   public Options(int difficulty)
    {    
        super(1100, 500, 1); 
        
        this.difficulty = difficulty;
        
        prepare();
    }
    
   private void prepare()
   {
        addObject(new InstructionsButton(difficulty), 230,230);
        addObject(new DifficultyButton(), 192,310);
        addObject(new BackButton(difficulty), 100,380);    
   }

    
    
}
