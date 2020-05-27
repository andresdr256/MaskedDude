import greenfoot.*;  

public class StartButton extends Button
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound2.mp3");    

    public void act() 
    {
        soundtrack.play();
        
        checkMouse();  
        
        if(Greenfoot.mouseClicked(this)){
            soundtrack.stop();
            Greenfoot.setWorld(new Level1StartScreen());
        }
    }    
}
