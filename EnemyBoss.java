import greenfoot.*;  

public class EnemyBoss extends Actor
{
    private final int GRAVITY = 1;
    private boolean canShot = true;
    private boolean isImpacted = false;
    private int shotDelayer = 0;
    private int speed;    
    private int i = 0;
    private int health = 300;
    
    public EnemyBoss()
    {
        setImage("sprites/EnemyBoss1.png");
        speed = 5;
    }
    
    public void act()
    {
        fall();
        shoot();
        animation();
        checkImpact();
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
        if(shotDelayer == 30){
            Bullet bullet = new Bullet(-15);
            getWorld().addObject(bullet,getX()-120,getY()-45);
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
            health--;
        }
        return isImpacted;
    }    
    
    public void animation()
    {
        if(isImpacted)
        {
            switch(i){
                case 0:
                    setImage("sprites/EnemyBoss2.png");
                    i++;
                    canShot = false;
                    break;
                case 30:
                    i=0;
                    isImpacted = false;
                    canShot = true;
                    setImage("sprites/EnemyBoss1.png");
                    break;                
                    
                default:
                    i++;
            }
        }    
    }
    
    public int getHealth()
    {
        return health;
    }
}
