import greenfoot.*;  

public class Enemy extends Actor
{
    private final int GRAVITY = 1;
    private boolean canShot = true;
    private boolean isImpacted = false;
    private int shotDelayer = 0;
    private int speed;    
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
        animation();
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
                canShot = true;
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

        if(getY() > 380  &&  getY() < 450  &&  isTouching(Floor.class))
            isOnGround = true;
        
        return isOnGround;
    }
    
    public void shoot()
    {
        if(shotDelayer == 100){
            Bullet bullet = new Bullet(-10);
            getWorld().addObject(bullet,getX()-80,getY()-30);
            shotDelayer = 0;                
        }else
        {
            if(canShot)
                shotDelayer++;
        }
    }    
    
    public boolean checkImpact()
    {
        if(isTouching(Bullet.class))
        {
            isImpacted = true;
        }
        return isImpacted;
    }    
    
    public void animation()
    {
        if(isImpacted)
        {
            switch(i){
                case 0:
                    setImage("sprites/Enemy2.png");
                    i++;
                    canShot = false;
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
                    canShot = true;
                    setImage("sprites/Enemy1.png");
                    break;                
                    
                default:
                    i++;
            }
        }    
    }
}
