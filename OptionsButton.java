import greenfoot.*;  

public class OptionsButton extends Button
{
    private int difficulty;
    
    public OptionsButton(int difficulty)
    {
        this.difficulty = difficulty;
    }
    
    public void act() 
    {
        checkMouse();
                
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Options(difficulty));
        }
    }    
}
