import greenfoot.*;  

public class Player extends Actor
{
    private final int GRAVITY = 1;
    private int speed;
    private int leftSpriteCounter = 0; 
    private int rightSpriteCounter = 0;
    private int i = 0;
    
    public Player(){        
        speed = 5;
    }
    
    public void act() {        
        processKeys();
    }
    
    public void processKeys() {
        
        // Position variables
        int y = getY();
        int x = getX();
        
        // Horizontal movement
        if(Greenfoot.isKeyDown("LEFT")  &&  x>100){
            if(leftSpriteCounter < 8 && i == 5){
                setImage("sprites/PlayerLeft" + leftSpriteCounter + ".png");
                leftSpriteCounter++;
                i=0;
            }
            
            else{ 
                if(leftSpriteCounter >= 8) 
                    leftSpriteCounter = 0;
                
                i++;
            }

            x -= 10;
        }
    
        if(Greenfoot.isKeyDown("RIGHT")  &&  x<900){
            
            if(rightSpriteCounter < 8 && i == 5){
                setImage("sprites/PlayerRight" + rightSpriteCounter + ".png");
                rightSpriteCounter++;
                i=0;
            }
            
            else{ 
                if(rightSpriteCounter >= 8) 
                    rightSpriteCounter = 0;
                
                i++;
            }
            
            if(rightSpriteCounter != 0 && rightSpriteCounter != 4) 
                x += 1;
        }
        
        setLocation(x, y);
        
        // Fall motion
        fall();
        // Jump motion
        if(Greenfoot.isKeyDown("UP") && isOnSolidGround()){
            jump();
        }
        //Shoot action
        if (Greenfoot.isKeyDown("space"))
        {
            shoot();
        }
    }

    // Accion disparar
    public void shoot()
    {
        Bullet bullet = new Bullet(5);
        bullet.setRotation(getRotation());
        getWorld().addObject(bullet,getX(),getY());
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
        
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Platform.class) != null  || 
           getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Platform.class) != null){ 
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
    
    public boolean isOver()
    {
        boolean isOver = false;
        
        if(getY() > 500)
        {
            isOver = true;
        }
        
        return isOver; 
    }

}
