import greenfoot.*;

public class SecondWorld extends GameWorld
{
    private GreenfootSound soundtrack = new GreenfootSound("World1SoundTrack.mp3");
    private boolean difficultyIsSetOnPlayer = false;
    private boolean missionComplete = false;
    private boolean enemyHasBeenHit = false;
    private int enemyRespawnDelayer = 0;
    private int floorsCounter = 0;
    private int difficulty;
    private int scoreDelayer;
    private int score;    
    private int time;        
    private int X;
    private int Y;
    
    FloorLevel2 floor1= new FloorLevel2();
    FloorLevel2 floor2= new FloorLevel2();

    Enemy enemy = new Enemy();
    Player player = new Player();
    Clue clue = new Clue();
    Timer timer = new Timer();

    public SecondWorld(int difficulty, int score)
    {
        play();
        
        this.difficulty = difficulty;
        scoreCounter.addScore(score);
        
        prepare();
    }
    
    public void prepare()
    {
        addObject(floor1,550, 250);
        addObject(floor2,1650, 250);
        floor2.setImage("FloorBLevel2.png");
        
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
       
       if(timer.getTime() <= 0)
           stop();
        
       if(player.isOver() == false)
       {
            X = player.getX()+1000+Greenfoot.getRandomNumber(400);
            Y = 50;
            
            if(floor1.scroll())
                floorsCounter++;            
            floor2.scroll();
            
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
                addObject(clue, 1050, 400);
                GreenfootImage tempImage = clue.getImage();
                tempImage.setTransparency(0);
                clue.setImage(tempImage);
                
                floor1.setImage("FloorDLevel2.png");
                floor2.setImage("FloorCLevel2.png");
                enemy.setLocation(player.getX()+1000, 50);
                
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
        Greenfoot.setWorld(new Level3StartScreen(3, difficulty, score));        
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
