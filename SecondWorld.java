import greenfoot.*;

public class SecondWorld extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private int enemyRespawnDelayer = 0;
    private int floorsCounter = 0;
    private int X;
    private int Y;
    
    FloorLevel2 floor1= new FloorLevel2();
    FloorLevel2 floor2= new FloorLevel2();

    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();

    public SecondWorld()
    {
        play();
        prepare();
    }
    
    public void prepare()
    {
        addObject(floor1,550, 250);
        addObject(floor2,1650, 250);
        floor2.setImage("FloorBLevel2.png");
        
        addObject(player, 100, 300);
        
        addObject(enemy, player.getX()+1200, 50);
    }
    
    public void act()
    {
       if(player.isOver() == false)
       {
            X = player.getX()+1000+Greenfoot.getRandomNumber(400);
            Y = 50;
            
            if(floor1.scroll())
                floorsCounter++;            
            floor2.scroll();
            
            enemy.scroll();   
            
            if(enemy.getY() > 450)
                enemy.setLocation(X, Y);
                
            if(enemy.checkImpact())
            {
                enemyHasBeenHit = true;
            }
            
            if(enemyHasBeenHit){
               if(enemyRespawnDelayer == 30)
               {
                   enemy.setLocation(X, Y);
                   enemyRespawnDelayer = 0;
                   enemyHasBeenHit = false;
               }else{
                   enemyRespawnDelayer++;
                }               
            }
            
            if(floorsCounter == 3)
            {
                addObject(clue, 800, 50);
                
                if(player.clueIsTouched())
                    missionComplete();
            }
        }else
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
        Greenfoot.setWorld(new FinalWorld());        
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
