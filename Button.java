import greenfoot.*; 

public class Button extends Actor
{
    private GreenfootSound selectSound = new GreenfootSound("SelectMenuSound.mp3");
    private boolean mouseOver = false;
    private static int MAX_TRANS = 255;
    private int mouseOverSound = 0;
        
    public void checkMouse(){
        if(Greenfoot.mouseMoved(null)){
            mouseOver = Greenfoot.mouseMoved(this);
        }
        
        
        if(mouseOver){
            adjTrans(MAX_TRANS/3);
            
            if(mouseOverSound == 0){
                selectSound.play();
                mouseOverSound = 1;
            }    
        }
        else{
            adjTrans(MAX_TRANS);
            mouseOverSound = 0;
        }
    }
    
    public void adjTrans(int adjust){
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }
    
    public void act() 
    {
    }    
}
