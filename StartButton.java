import greenfoot.*;  

public class StartButton extends Button
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound2.mp3");    
    
    private int difficulty;
    
    public StartButton(int difficulty)
    {
        this.difficulty = difficulty;
        soundtrack.play();
    }
    
    public void act() 
    {
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            soundtrack.stop();
            Greenfoot.setWorld(new InstructionsScreen(difficulty));
        }
    }   
}
