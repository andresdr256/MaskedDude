import greenfoot.*;

public class PlatformBuilding extends Platform
{
    // Posición aleatoria de la plataforma en el eje Y  
    int Y = Greenfoot.getRandomNumber(300)+450;  // Entre 0 y 300, mas 400.    

    
    public void scrollBuilding(PlatformBuilding platformBuilding)
    {
        if(getX() == -550)
        {
            setLocation(platformBuilding.getX() + 1300, Y);
        }
    }
}
