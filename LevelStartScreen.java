import greenfoot.*;  

public class LevelStartScreen extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSound1.mp3");
    GreenfootImage tempImage = getBackground();
    private int i = 0;
    private int level;
    private int difficulty;

    public LevelStartScreen()
    {    
        super(1100, 500, 1);         
        play();
    }
    
    public void act()
    {              
        if(i>35)
            startLevel(level, difficulty);
        
        resizeBackground();
        i++;
        Greenfoot.delay(5);            
    }    
    
    public void resizeBackground()
    {
        tempImage.scale(tempImage.getWidth(), tempImage.getHeight()+1);
        setBackground(tempImage);        
    }
    
    public void setLevel(int level, int difficulty)
    {
        this.level = level;
        this.difficulty = difficulty;
    }
    
    public void play()
    {
        soundtrack.play();
    } 

    public void startLevel(int level, int difficulty)
    {
        soundtrack.stop();
        
        if(level == 1)
            Greenfoot.setWorld(new FirstWorld(difficulty));        

        if(level == 2)
            Greenfoot.setWorld(new SecondWorld(difficulty));
        
        if(level == 3)
            Greenfoot.setWorld(new FinalWorld(difficulty));
    }
}