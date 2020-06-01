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
    
    FloorFinalBoss floor = new FloorFinalBoss();

    Player player = new Player();
    Clue clue = new Clue();
    EnemyBoss enemyBoss = new EnemyBoss();
    Timer timer = new Timer();

    public BossFight(int difficulty, int score)
    {    
        play();
        
        this.difficulty = difficulty;
        scoreCounter.addScore(score);
        
        prepare();
    }
    
    public void prepare()
    {
        addObject(healthbar, 200, 40);        
        addObject(scoreCounter, 950, 35);
        addObject(floor,550, 400);

        addObject(player, 100, 300);
        addObject(enemyBoss, 850, 200);
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
            if(enemyBoss.getHealth() <= 0)
            {
                missionComplete();
            }
            
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
        removeObject(enemyBoss);
        Greenfoot.delay(100);
        soundtrack.stop();
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
