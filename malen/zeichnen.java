package malen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferStrategy;

public class zeichnen
extends Frame
{
	public static LinkedList<Gegner>gegnerListe;
	static Creator c;
	
	public static void main(String[] args)
	{
		zeichnen wnd = new zeichnen();
	}
	
	public static void initial(){
		for (int i=0; i<12; i++)
		{
			for (int j=0; j<20; j++)
			{
				if (Bloecke.zeile[i][j]=='r') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 0, 'r', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='x') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 1, 'z', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='z') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 0, 'z', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='s') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 2, 'v', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='t') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 3, 'v', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='u') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 0, 'v', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='v') {
					Gegner geg = new Gegner();
					geg.initial(j, i, 1, 'v', true);
					gegnerListe.add(geg);
				} else if (Bloecke.zeile[i][j]=='S') {
					Position.x=j;
					Position.y=i;
					char n = 0;
					Bloecke.zeile[i][j]=n;
				} else if (Bloecke.zeile[i][j]=='C') {
					c = new Creator();
					c.x=j;
					c.y=i;
					char n = 0;
					Bloecke.zeile[i][j]=n;
				}
			}
		}
	}
	
	public static void alleGegnerLoeschen() {
		for(Gegner loeschG:gegnerListe) {
			loeschG.del();		
		}
	}
	
	public static void alleGegnerStoppen() {
		for(Gegner loeschG:gegnerListe) {
			loeschG.destroy = true;		
		}
	}

	public static void alleGegnerStarten() {
		for(Gegner startG:gegnerListe) {
			startG.start();		
		}
	}
	
	public zeichnen() 
	{
		super("Adventures of a Circle");
		addWindowListener(new WindowClosingAdapter(true));
		KeyListener raumschiff = new Position();
		addKeyListener(raumschiff);
		zeit();
		gegnerListe = new LinkedList();
		initial();
		setBackground(Color.black);
		setSize(1400,800);
        setLocationRelativeTo(null);
		setVisible(true);
        createBufferStrategy(1);
	}
	
	public void zeit(){
		Timer timer = new Timer();
		timer.schedule(
				new TimerTask() 
				{
					public void run() 
					{
						repaint();
					}
				}, 100, 50);
		}
	
	
	public static void hintergrund(Graphics g)
	{
		int i;
		int j;
		int x = 4;
		int y = 26;
		
		for(i=0; i<21; ++i)
		{
			g.setColor(Color.yellow);
			g.drawLine(x,0,x,783);
			x += 64;
		}
		
		for(j=0; j<13; ++j)
		{
			g.setColor(Color.yellow);
			g.drawLine(0,y,1280,y);
			y += 64;
		}
	}
	@Override
	public void paint(Graphics g)
	{
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
	    Graphics2D g2d = null;
        try {
            g2d = (Graphics2D)bf.getDrawGraphics();
            if (g2d == null)
                return;
            g2d.clearRect(0,0,getWidth(),getHeight());
            Position.rsZeichnen(g2d);
            Bloecke.erstellen(g2d);
            hintergrund(g2d);
            if(c != null) {
                c.rsZeichnen(g2d);            	
            }
            for (Gegner gegner: gegnerListe)
            {
            	gegner.gzeichnen(g);
            }
        } finally {
	        if (g2d != null)
	            g2d.dispose();
		}
		bf.show();
	    Toolkit.getDefaultToolkit().sync();	
	}
}
