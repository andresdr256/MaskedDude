import greenfoot.*;  

public class Player extends Actor
{
    private final int GRAVITY = 1;
    private int speed;
    
    public Player(){        
        speed = 5;
    }
    
    public Player(int width, int height){
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }

    
    public void act() {
        move();
    }    
            
    public void move() {
        
        // Position variables
        int y = getY();
        int x = getX();
        
        // Horizontal movement
        if(Greenfoot.isKeyDown("LEFT")  &&  x>20)    x -= 10;
        if(Greenfoot.isKeyDown("RIGHT")  &&  x<900) x += 5;
        setLocation(x, y);
        
        // Fall motion
        fall();
        
        // Jump motion
        if(Greenfoot.isKeyDown("UP") && isOnSolidGround()){
            jump();
        }    
    }        
    
    // Movimiento de caida 
    public void fall() {
        setLocation(getX(), getY() + speed);
        
        if(isOnSolidGround()){
            speed = 0;        
        }
        
        else if (speed < 0 && didBumpHead()) {
                speed = 0;
            }
            else speed += GRAVITY;
    }

    // Saltar
    public void jump(){
        speed = -20;
    }        

    // Se encuentra en el suelo
    public boolean isOnSolidGround(){
        boolean isOnGround = false;
        
        if(getY() > getWorld().getHeight() - 80)    isOnGround = true;
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Platform.class) != null  || 
           getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Platform.class) != null) {
               isOnGround = true;
        }
        
        return isOnGround;
    }

    // Se ha golpeado la cabeza
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
