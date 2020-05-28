import greenfoot.*;  

public class PlayButton extends Button
{
    private int difficulty;

    public PlayButton(int difficulty)
    {
        this.difficulty = difficulty;
    }
    
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Level1StartScreen(1, difficulty));
        }
    }    
}
