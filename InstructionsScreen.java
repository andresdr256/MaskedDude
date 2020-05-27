import greenfoot.*; 

public class InstructionsScreen extends World
{
    public InstructionsScreen()
    {    
        super(1100, 500, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        addObject(new PlayButton(), 960, 340);
    }
    
    public void act(){ 
        
    }
}