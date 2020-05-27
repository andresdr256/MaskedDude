import greenfoot.*;  

public class Menu extends World
{    
    private int difficulty;
    
    
    public Menu(int difficulty)
    {    
        super(1100, 500, 1);
        
        this.difficulty = difficulty;
        
        prepare();
    }

    public Menu()
    {    
        super(1100, 500, 1);
        
        this.difficulty = 1;
        
        prepare();
    }
    
    private void prepare()
    {
        addObject(new StartButton(difficulty), 200,295);
        addObject(new OptionsButton(difficulty), 193,370);
        addObject(new ExitButton(), 190,440);   
    }
}
