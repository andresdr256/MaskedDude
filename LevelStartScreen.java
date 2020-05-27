import greenfoot.*;  

public class LevelStartScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    GreenfootImage tempImage = getBackground();
    private int i = 0;
    private int level;

    public LevelStartScreen()
    {    
        super(1100, 500, 1);         
        play();
    }
    
    public void act()
    {              
        if(i>35)
            startLevel(level);
        
        resizeBackground();
        i++;
        Greenfoot.delay(5);            
    }    
    
    public void resizeBackground()
    {
        tempImage.scale(tempImage.getWidth(), tempImage.getHeight()+1);
        setBackground(tempImage);        
    }
    
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    public void play()
    {
        soundtrack.play();
    } 

    public void startLevel(int level)
    {
        soundtrack.stop();
        
        if(level == 1)
            Greenfoot.setWorld(new InstructionsScreen());        

        if(level == 2)
            Greenfoot.setWorld(new SecondWorld());
        
        if(level == 3)
            Greenfoot.setWorld(new FinalWorld());
    }
}