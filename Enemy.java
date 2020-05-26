import greenfoot.*;  

public class Enemy extends Actor
{
    private final int GRAVITY = 1;
    private int speed;
    private boolean isImpacted = false;
    private int i = 0;
    
    public Enemy()
    {
        setImage("sprites/Enemy1.png");
        speed = 5;
    }
    
    public void act()
    {
        fall();
        shoot();
        checkImpact();

        if(isImpacted)
        {
            switch(i){
                case 0:
                    setImage("sprites/Enemy2.png");
                    i++;
                    break;
                    
                case 5:
                    setImage("sprites/Enemy3.png");
                    setLocation(getX()+35, getY()+10);
                    i++;
                    break;
                    
                case 10:
                    setImage("sprites/Enemy4.png");
                    setLocation(getX()+35, getY()+10);
                    i++;
                    break;                
            
                case 30:
                    i=0;
                    isImpacted = false;
                    setImage("sprites/Enemy1.png");
                    break;                
                    
                default:
                    i++;
            }
            
        }    

    }
        
    public void scroll() 
    {
        if(Greenfoot.isKeyDown("RIGHT"))
        {   
            setLocation(getX() - 5 , getY());
        }
    }    
    
        // Movimiento de caida 
    public void fall() {
        setLocation(getX(), getY() + speed);
        
        if(isOnSolidGround()){
            speed = 0;        
        }
        
        else if (speed < 0) {
                speed = 0;
            }
            else{
                speed += GRAVITY;            
            }

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
    
    public void shoot()
    {
    }    
    
    public boolean checkImpact()
    {
        if(isTouching(Bullet.class))
            isImpacted = true;
        
        return isImpacted;
    }
}
