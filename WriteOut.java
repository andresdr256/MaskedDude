import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.util.List;

public class WriteOut extends Actor
{
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            String strName = JOptionPane.showInputDialog("First Name: ");
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt", true));
                writer.write(strName + "\n");
                writer.close();
                JOptionPane.showMessageDialog(new JInternalFrame(), "Name added.");
            }
            catch (IOException e)
            {
                System.out.println("File not found.");
            }
        }
    }    
}
