import greenfoot.*;

public class PlatformBuilding extends Platform
{
    // Posición aleatoria de la plataforma en el eje Y  
    int Y = Greenfoot.getRandomNumber(300)+400;  // Entre 0 y 300, mas 400.    

    
    public boolean scrollBuilding(PlatformBuilding platformBuilding)
    {
        boolean buildingChanged = false;
        
        if(getX() == -550)
        {
            setLocation(platformBuilding.getX() + 1300, Y);
            buildingChanged = true;
        }
        
        return buildingChanged;
    }
}
