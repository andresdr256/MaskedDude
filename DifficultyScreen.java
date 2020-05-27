import greenfoot.*;  

public class DifficultyScreen extends World
{
    public DifficultyScreen()
    {    
        super(1100, 500, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        addObject(new EasyButton(), 100, 230);
        addObject(new HardButton(), 105, 310);
        addObject(new VeteranButton(), 163, 397);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
