import greenfoot.*;
import java.util.Random;
    
public class FirstWorld extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");

    PlatformBuilding platformBuilding1= new PlatformBuilding();
    PlatformBuilding platformBuilding2= new PlatformBuilding();

    BuildingsBackground buildingsBackground = new BuildingsBackground();
    BuildingsBackground buildingsBackground2 = new BuildingsBackground();

    Player player = new Player(80, 120);

    public FirstWorld()
    {    
        prepare();
        play();
    }
    
    private void prepare()
    {   
        addObject(buildingsBackground,550, 250);
        addObject(buildingsBackground2,1650, 250);
        
        addObject(platformBuilding1,550, 550);
        addObject(platformBuilding2,1850, 500);

        addObject(player, 100, 50);
    }
     
    public void act()
    {   
        if(player.isOver() == false)
        {
            platformBuilding1.scrollBuilding(platformBuilding2);
            platformBuilding2.scrollBuilding(platformBuilding1);
            buildingsBackground.scroll();
            buildingsBackground2.scroll();
        }    
        else
        {
            stop();
        } 
    }  
    
    public void play()
    {
        soundtrack.play();
    }

    public void stop()
    {
        soundtrack.stop();
        Greenfoot.stop();
        Greenfoot.setWorld(new GameOverScreen());
    }
}
