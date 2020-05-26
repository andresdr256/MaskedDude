
import greenfoot.*;

public class Bullet extends Actor
{
    private GreenfootSound gunSound = new GreenfootSound("Shot.mp3");
    
    private int speed;
    private int damage;
    private int soundIsPlaying = 0;
    
    public Bullet(int s)
    {
        speed = s;
        damage = 1;        
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(int s)
    {
        speed = s;
    }    
    
    public void act() 
    {
        move(speed);
        checkBoundaries();
    }
   
    public void checkBoundaries()
    {
        GreenfootImage img = getImage();
        int width = img.getWidth();
        int height = img.getHeight();
        
        World livesIn = getWorld();
        
        int left = getX() - width/2;
        int right = getX() + width/2;
        
        if(left <= 0  ||  right >= livesIn.getWidth()  ||  isTouching(Enemy.class))
        {  
            if(isTouching(Enemy.class))
            {
                setImage("sprites/Bullet2.png");
            
            } else
                livesIn.removeObject(this);  
        
        } else
            play();

        
    }
    
    public void play()
    {
        if(soundIsPlaying == 0)
        {
            gunSound.play();
            soundIsPlaying = 1;    
        }
    }
}
