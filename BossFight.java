import greenfoot.*;

public class BossFight extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean difficultyIsSetOnPlayer = false;
    private boolean missionComplete = false;
    private boolean enemyBossHasBeenHit = false;
    private boolean backgroundChanged = false;
    private int floorsCounter = 0;
    private int scoreDelayer;
    private int difficulty;
    private int score;
    private int time;
    private int X;
    private int Y;
    
    FloorLevel3 floorLevel3= new FloorLevel3();

    FinalBackground background1 = new FinalBackground();
    FinalBackground background2 = new FinalBackground();
    
    Player player = new Player();
    Clue clue = new Clue();
    EnemyBoss enemyBoss = new EnemyBoss();

    public BossFight(int difficulty, int score)
    {    
        play();
        
        this.difficulty = difficulty;
        scoreCounter.addScore(score);
        
        prepare();
    }
    
    public void prepare()
    {
        addObject(floorLevel3,550, 400);

        addObject(background1,550, 250);
        addObject(background2,1650, 250);
        background2.setImage("Background3B.png");    

        addObject(healthbar, 200, 40);        
        addObject(scoreCounter, 950, 35);

        addObject(player, 100, 400);
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

                addObject(enemyBoss, 850, 100);

                //--------------------------------------------------------------------------------------------------
                //--------------------------------------------------------------------------------------------------
                if(enemyBoss.checkImpact())
                {
                    enemyBossHasBeenHit = true;
        
                    if(scoreDelayer > 25)
                    {
                        scoreCounter.addScore(1);
                        scoreDelayer = 0;           
                    }else
                        scoreDelayer++;                   
                }
                
                if(enemyBossHasBeenHit){
                    enemyBossHasBeenHit = false;
                    if(enemyBoss.health == 0)
                    {
                        removeObject(enemyBoss);
                    }
                }
                //--------------------------------------------------------------------------------------------------
                //--------------------------------------------------------------------------------------------------
        }else
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
        Greenfoot.setWorld(new FinalScreen(score));        
    }

    public void play()
    {
        soundtrack.play();
    }

    public void stop()
    {
        score = scoreCounter.getScore();
        soundtrack.stop();
        Greenfoot.setWorld(new GameOverScreen(score));
    }    
}
