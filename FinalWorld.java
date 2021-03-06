import greenfoot.*;

public class FinalWorld extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean difficultyIsSetOnPlayer = false;
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private boolean backgroundChanged = false;
    private int enemyRespawnDelayer = 0;
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
    
    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();
    EnemyBoss enemyBoss = new EnemyBoss();
    Timer timer = new Timer();

    public FinalWorld(int difficulty, int score)
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

        addObject(enemy, player.getX()+1200, 50);
        addObject(timer, 850, 35);
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
            
       if(timer.getTime() <= 0)
           stop();
            
        if(player.isOver() == false)
       {
            X = player.getX()+600+Greenfoot.getRandomNumber(200);
            Y = 250;
            
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
                   enemy.setLocation(X, Y);
                   enemyRespawnDelayer = 0;
                   enemyHasBeenHit = false;
               }else{
                   enemyRespawnDelayer++;
                }               
            }

            if(floorsCounter == 5)
            {
                addObject(clue, 1000, 400);

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
        time = timer.getTime();        
        scoreCounter.addScore(time);
        score = scoreCounter.getScore();

        soundtrack.stop();
        Greenfoot.delay(40);
        Greenfoot.setWorld(new BossFight(3, score));        
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
        score = scoreCounter.getScore();
        soundtrack.stop();
        Greenfoot.setWorld(new GameOverScreen(score));
    }    
}
