import greenfoot.*;  

public class InstructionsButton extends Button
{
    private int difficulty;
    
    public InstructionsButton(int difficulty)
    {
        this.difficulty = difficulty;
    }
    
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new InstructionsScreen(difficulty));
    }    
}
