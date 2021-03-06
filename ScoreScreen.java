import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.util.List;

public class ScoreScreen extends World
{
    MainMenuButton mainMenuButton = new MainMenuButton(1);

    public ScoreScreen(int score)
    {    
        super(1100, 500, 1); 
        ScoreCounter scoreCounter = new ScoreCounter(score);
        addObject(scoreCounter, 150, 200);
        addObject(mainMenuButton, 900, 400);
        prepare(score);
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(int score)
    {
        writePlayerOnFile(score);
    }

    public void writePlayerOnFile(int score)
    {
        String strName = JOptionPane.showInputDialog("Player Name: ");
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt", true));
            writer.write(strName + "," + String.valueOf(score) + ",");
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found.");
        }
    }
}
