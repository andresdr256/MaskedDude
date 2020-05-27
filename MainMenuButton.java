import greenfoot.*; 

public class MainMenuButton extends Button
{
    private int difficulty;
    
    public MainMenuButton(int difficulty)
    {
        this.difficulty = difficulty;
    }
    
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Menu());
        }
    } 
}
