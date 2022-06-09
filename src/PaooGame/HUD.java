package PaooGame;

import java.awt.*;
import java.awt.Color;

import static java.awt.Color.white;

public class HUD {

    static public int count=0;
    static public int adunate=0;

    public  HUD(int count, int adunate){
        this.count=count;
        this.adunate=adunate;
    }
    public HUD(){}

    public void Draw(Graphics g)
    {
        //bara neagra din partea de sus a ferestrei de joc
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,40);

        g.setFont(new Font("Cairo", Font.BOLD, 20));
        g.setColor(white);
        g.drawString("Puncte: " + Integer.toString(count), 30,30);


        g.setFont(new Font("Cairo", Font.BOLD, 20));
        g.setColor(white);
        g.drawString("Piese colectate: " + Integer.toString(adunate), 150,30);
    }
}
