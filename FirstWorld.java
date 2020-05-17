import greenfoot.*;

public class FirstWorld extends GameWorld
{

    public FirstWorld()
    {    
        prepare();
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player, 216, 176);
        Platform platform = new Platform(200, 25);
        addObject(platform,400,311);
        
        
    }
    
    
}
