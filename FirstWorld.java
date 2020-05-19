import greenfoot.*;

public class FirstWorld extends GameWorld
{
    
    public FirstWorld()
    {    
        prepare();
    }
    
    private void prepare()
    {   
        BuildingsBackground buildingsBackground = new BuildingsBackground();
        addObject(buildingsBackground,550, 251);

        PlatformBuilding platformBuilding= new PlatformBuilding();
        addObject(platformBuilding,550, 550);

        Player player = new Player(80, 110);
        addObject(player, 216, 176);
    }
    
    
}
