import greenfoot.*;  

public class BackButton extends Button
{
    private int difficulty;
    
    public BackButton(int difficulty)
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
