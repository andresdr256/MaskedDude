import greenfoot.*;  
import java.lang.Class;

public class Player extends Actor
{
    boolean hitByBullet = false;

    private final int GRAVITY = 1;
    private boolean playerIsDown = false;
    private int leftSpriteCounter = 0; 
    private int rightSpriteCounter = 0;
    private int walkDelayer = 0;
    private int shotDelayer = 8;
    private int speed;
    
    public Player(){        
        setImage("sprites/PlayerRight0.png");        
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
        if(Greenfoot.isKeyDown("LEFT")  &&  x>100  &&  !playerIsDown){
            if(leftSpriteCounter < 8 && walkDelayer == 5){
                if(isOnSolidGround())
                    setImage("sprites/PlayerLeft" + leftSpriteCounter + ".png");
                leftSpriteCounter++;
                walkDelayer=0;
            }
            
            else{ 
                if(leftSpriteCounter >= 8) 
                    leftSpriteCounter = 0;
                
                walkDelayer++;
            }

            x -= 15;
        }
    
        if(Greenfoot.isKeyDown("RIGHT")  &&  x<900  &&  !playerIsDown){
            
            if(rightSpriteCounter < 8 && walkDelayer == 5){
                if(isOnSolidGround()){
                    if(Greenfoot.isKeyDown("SPACE")){
                        setImage("sprites/ShotRight" + rightSpriteCounter + ".png");
                    }else
                     {           
                       setImage("sprites/PlayerRight" + rightSpriteCounter + ".png");
                     }
                
                }
                rightSpriteCounter++;
                walkDelayer=0;
            }
            
            else{ 
                if(rightSpriteCounter >= 8) 
                    rightSpriteCounter = 0;
                
                walkDelayer++;
            }
            
            if(rightSpriteCounter != 0 && rightSpriteCounter != 4) 
                x += 1;
        }
        
        setLocation(x, y);
        
        // Fall motion
        fall();
        // Jump motion
        if(Greenfoot.isKeyDown("UP") && isOnSolidGround()){
            setImage("sprites/Jump0.png");
            jump();           
        }

        if(Greenfoot.isKeyDown("DOWN") && isOnSolidGround()){
            setImage("sprites/PlayerDown.png");
            playerIsDown = true;
        }        
        
        if(!Greenfoot.isKeyDown("DOWN"))
            playerIsDown = false;
            
        //Shoot action
        if (Greenfoot.isKeyDown("SPACE") && isOnSolidGround() && !playerIsDown)
        {
            // Cambia al sprite de disparo
            if ( !Greenfoot.isKeyDown("RIGHT"))
                setImage("sprites/ShotRight0.png");
            
            if(shotDelayer == 8)
            {
                shoot();
                shotDelayer = 0;
            }    
            else 
                shotDelayer++;
        }
    }

    // Accion disparar
    public void shoot()
    {
        Bullet bullet = new Bullet(15);
        getWorld().addObject(bullet,getX()+80,getY()-25);
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
            else{
                speed += GRAVITY;            
            }

        if( ! isOnSolidGround()){
            if(Greenfoot.isKeyDown("LEFT"))
            {
                if(speed == -18)
                    setImage("sprites/JumpLeft1.png");
    
                if(speed == 0)
                    setImage("sprites/JumpLeft2.png");
    
                if(speed == 10)
                    setImage("sprites/JumpLeft3.png");

            }else{
                if(speed == -18)
                    setImage("sprites/JumpRight1.png");
                
                if(speed == 0)
                    setImage("sprites/JumpRight2.png");
    
                if(speed == 10)
                    setImage("sprites/JumpRight3.png");
             }
            
            
        }
    }

    // Saltar
    public void jump(){
        speed = -22;
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
        
        if(getY() > 400  &&  getY() < 420  &&  isTouching(Floor.class))
            isOnGround = true;
        
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
        
        if(getY() > 500  ||  isTouching(Bullet.class))
        {
            isOver = true;
        }
        
        return isOver; 
    }
    
    public boolean clueIsTouched()
    {
        boolean clueIsTouched = false;
        
        if(isTouching(Clue.class))
            clueIsTouched = true;
          
        return clueIsTouched;
    }
}
