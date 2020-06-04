import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.String;


public class HighScoreTable extends Actor
{
    //int score = 0;
    ArrayList<Jugador> highScores;
  
    public HighScoreTable()
    {
        this.highScores = new ArrayList<Jugador>();
        readFileAndSplit();
        sortScores();
        setImage(new GreenfootImage("Top 3 Players \n\n" 
                + "1.- " + highScores.get(0).name + " . . . " + highScores.get(0).score + "\n\n"
                + "2.- " + highScores.get(1).name + " . . . " + highScores.get(1).score + "\n\n" 
                + "3.- " + highScores.get(2).name + " . . . " + highScores.get(2).score
                , 24, Color.YELLOW, Color.BLACK));
    }

    public void act() 
    {
        
    }

    public void readFileAndSplit()
    {
        try
            {
                BufferedReader br = new BufferedReader(new FileReader("names.txt"));
                String currentLine = br.readLine();
                String[] scoreTable = currentLine.split(",");

                String nombre = "";
                int score = 0;
                for(int i=0; i<scoreTable.length;i++)
                {
                    if(i%2==0){
                        nombre = scoreTable[i];
                    }
                    else
                    {
                        score = Integer.parseInt(scoreTable[i]);
                        Jugador auxJugador = new Jugador(nombre, score);
                        highScores.add(auxJugador);
                    }
                }
                br.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public void sortScores()
    {
        Collections.sort(highScores, new Comparator<Jugador>()
        {
            public int compare(Jugador j1, Jugador j2)
            {
                return Integer.valueOf(j2.score).compareTo(j1.score);
            }
        });
    }
}