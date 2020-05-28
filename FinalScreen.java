import greenfoot.*;  

public class FinalScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    GreenfootImage tempImage = getBackground();
    private int i = 0;

    public FinalScreen()
    {    
        super(1100, 500, 1);         
        play();
    }
    
    public void act()
    {              
        if(i>35)
            Greenfoot.setWorld(new Menu());
        
        resizeBackground();
        i++;
        Greenfoot.delay(5);            
    }    
    
    public void resizeBackground()
    {
        tempImage.scale(tempImage.getWidth(), tempImage.getHeight()+1);
        setBackground(tempImage);        
    }
    
    public void play()
    {
        soundtrack.play();
    }
}
