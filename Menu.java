import greenfoot.*;  

public class Menu extends World
{    
    public Menu()
    {    
        super(1100, 500, 1);
        
        prepare();
    }
    
    private void prepare(){
        addObject(new StartButton(), 200,295);
        addObject(new OptionsButton(), 193,370);
        addObject(new ExitButton(), 190,440);   
    }
    
    public void act(){
    }
}
