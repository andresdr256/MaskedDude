import greenfoot.*;
    
public class FirstWorld extends GameWorld
{    
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean difficultyIsSetOnPlayer = false;
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private int enemyRespawnDelayer = 0;
    private int plataformsCounter = 0;
    private int scoreDelayer;
    private int difficulty;
    private int score;    
    private int time;    
    
    PlatformBuilding platformBuilding1= new PlatformBuilding();
    PlatformBuilding platformBuilding2= new PlatformBuilding();

    BuildingsBackground buildingsBackground = new BuildingsBackground();
    BuildingsBackground buildingsBackground2 = new BuildingsBackground();

    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();
    
    public FirstWorld(int difficulty)
    {    
        this.difficulty = difficulty;
        prepare();
        play();
    }
    
    private void prepare()
    {   
        addObject(buildingsBackground,550, 250);
        addObject(buildingsBackground2,1649, 250);

        addObject(platformBuilding1,550, 550);
        addObject(platformBuilding2,1850, 500);

        addObject(healthbar, 200, 40);        
        addObject(scoreCounter, 950, 35);
        
        addObject(player, 100, 200);

        addObject(enemy, player.getX()+1200, 50);              
    }
     
    public void act()
    {   
        if(!difficultyIsSetOnPlayer)
        {
            player.setDifficulty(difficulty);            
            difficultyIsSetOnPlayer = true;
        }
        
        if(timer.getTime() <= 0)
            stop();
        
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
  
               if(scoreDelayer > 25)
               {
                   scoreCounter.addScore(5);
                   scoreDelayer = 0;           
               }else
                   scoreDelayer++;                   
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
            
            if(plataformsCounter == 2)
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
        time = timer.getTime();        
        scoreCounter.addScore(time);
        score = scoreCounter.getScore();
        
        soundtrack.stop();
        Greenfoot.delay(40);
        Greenfoot.setWorld(new Level2StartScreen(2, difficulty, score));        
    }
    
    public void play()
    {
        soundtrack.play();
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }    

    public void stop()
    {
        score = scoreCounter.getScore();
        soundtrack.stop();
        Greenfoot.setWorld(new GameOverScreen(score));
    }    
}
