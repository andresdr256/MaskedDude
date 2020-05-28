import greenfoot.*;

public class FinalBoss extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean difficultyIsSetOnPlayer = false;
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private boolean backgroundChanged = false;
    private int enemyRespawnDelayer = 0;
    private int floorsCounter = 0;
    private int difficulty;
    private int X;
    private int Y;
    
    FloorLevel3 floorLevel3= new FloorLevel3();

    FinalBackground background1 = new FinalBackground();
    FinalBackground background2 = new FinalBackground();
    
    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();

    public FinalBoss(int difficulty)
    {    
        play();
        
        this.difficulty = difficulty;
        
        prepare();
    }
    
    public void prepare()
    {
        addObject(floorLevel3,550, 400);

        addObject(background1,550, 250);
        addObject(background2,1650, 250);
        background2.setImage("Background3B.png");    

        addObject(healthbar, 200, 40);        
        
        addObject(player, 100, 400);
        
        addObject(enemy, player.getX()+1200, 50);
    }

    public void act()
    {
        if(!difficultyIsSetOnPlayer)
        {
            player.setDifficulty(difficulty);            
            difficultyIsSetOnPlayer = true;
        }        
        
       if(!backgroundChanged)  
            changeBackground();
            
            
        if(player.isOver() == false)
       {
            X = player.getX()+900+Greenfoot.getRandomNumber(400);
            Y = 50;
            
            if(background1.scroll())
                floorsCounter++;            
            background2.scroll();
            
            enemy.scroll();   
            
            if(enemy.getY() > 450)
            {
                enemy.setLocation(X, Y);
            }
            
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
            
            if(floorsCounter == 4)
            {
                addObject(clue, 1000, 150);

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
        Greenfoot.setWorld(new Menu());        
    }
    
    public boolean changeBackground()
    {
       if(background1.getX() == -550) 
           background1.setImage("Background3C.png");    
           
       if(background2.getX() == -550) 
           background2.setImage("Background3D.png");    
       
       return true;
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
