import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private final int GRAVITY = 1;
    private int velocity;
    
    public Player(){
        
        velocity = 5;
    }
    
    public void act() {
        
        move();
    }    
    
    public void move() {
        
        // Position variables
        int y = getY();
        int x = getX();
        
        // Horizontal movement
        if(Greenfoot.isKeyDown("left"))    x -= 5;
        if(Greenfoot.isKeyDown("right"))   x += 5;
        setLocation(x, y);
        
        // Fall motion
        fall();
        
        // Jump motion
        if(Greenfoot.isKeyDown("space") && isOnSolidGround())    jump();
    
    }        
    
    // Falling movement 
    public void fall() {
        setLocation(getX(), getY() + velocity);
        if(isOnSolidGround()){
            velocity = 0;
        
            while (isOnSolidGround()) {
                setLocation(getX(), getY() - 1);
            }    
            setLocation(getX(), getY() + 1);
        }
        else if (velocity < 0 && didBumpHead()) velocity = 0;
        else velocity += GRAVITY;
    }
    
    public void jump(){
        velocity = -20;
    }        
    
    public boolean isOnSolidGround(){
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - 80)    isOnGround = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Platform.class) != null  || 
           getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Platform.class) != null) 
            isOnGround = true;
        
        return isOnGround;
    }
    
    public boolean didBumpHead(){
        boolean bumpedHead = false;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / -2, Platform.class) != null  || 
           getOneObjectAtOffset(imageWidth / 2, imageHeight / -2, Platform.class) != null) 
            bumpedHead = true;     
        
        return bumpedHead;
    }
}
