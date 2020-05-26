import greenfoot.*;
import java.util.Random;
    
public class FirstWorld extends GameWorld
{    
    private boolean enemyHasBeenHit = false;
    private int enemyRespawnDelayer = 0;
    
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");

    PlatformBuilding platformBuilding1= new PlatformBuilding();
    PlatformBuilding platformBuilding2= new PlatformBuilding();

    BuildingsBackground buildingsBackground = new BuildingsBackground();
    BuildingsBackground buildingsBackground2 = new BuildingsBackground();

    Enemy enemy = new Enemy();
    Player player = new Player();

    public FirstWorld()
    {    
        prepare();
        play();
    }
    
    private void prepare()
    {   
        addObject(buildingsBackground,550, 250);
        addObject(buildingsBackground2,1649, 250);

        addObject(platformBuilding1,550, 550);
        addObject(platformBuilding2,1850, 500);

        addObject(player, 100, 50);

        addObject(enemy, player.getX()+1200, 50);
    }
     
    public void act()
    {   
        if(player.isOver() == false)
        {
            platformBuilding1.scrollBuilding(platformBuilding2);
            platformBuilding2.scrollBuilding(platformBuilding1);
            buildingsBackground.scroll();
            buildingsBackground2.scroll();
            enemy.scroll();   
                        
            if(enemy.getY() > 450)
                enemy.setLocation(player.getX()+1500, 50);
                
            if(enemy.checkImpact())
            {
                enemyHasBeenHit = true;
            }
            
            if(enemyHasBeenHit){
               if(enemyRespawnDelayer == 30)
               {
                   enemy.setLocation(player.getX()+1500, 50);
                   enemyRespawnDelayer = 0;
                   enemyHasBeenHit = false;
               }else{
                   enemyRespawnDelayer++;
                }
            }
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
