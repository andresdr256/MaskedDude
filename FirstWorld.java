import greenfoot.*;
    
public class FirstWorld extends GameWorld
{    
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private int enemyRespawnDelayer = 0;
    private int plataformsCounter = 0;
    
    PlatformBuilding platformBuilding1= new PlatformBuilding();
    PlatformBuilding platformBuilding2= new PlatformBuilding();

    BuildingsBackground buildingsBackground = new BuildingsBackground();
    BuildingsBackground buildingsBackground2 = new BuildingsBackground();

    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();

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

        addObject(player, 100, 200);

        addObject(enemy, player.getX()+1200, 50);
    }
     
    public void act()
    {   
        if(player.isOver() == false)
        {
            platformBuilding1.scrollBuilding(platformBuilding2);
            if(platformBuilding2.scrollBuilding(platformBuilding1))
                plataformsCounter++;

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
            
            if(plataformsCounter == 3)
            {
                addObject(clue, 1000, 150);
                if(player.clueIsTouched())
                    missionComplete();
            }
                
        }    
        else
        {
            stop();
        } 
    }  
    
    public void missionComplete()
    {
        MissionComplete missionCompleteScreen = new MissionComplete();

        soundtrack.stop();
        Greenfoot.delay(40);
        addObject(missionCompleteScreen, 550 ,250);
        Greenfoot.delay(200);
        Greenfoot.setWorld(new SecondWorld());        
    }
    
    public void play()
    {
        soundtrack.play();
    }

    public void stop()
    {
        soundtrack.stop();
        Greenfoot.setWorld(new GameOverScreen());
    }
}
