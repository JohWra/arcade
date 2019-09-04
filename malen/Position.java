package malen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

public class Position implements KeyListener
{
	static int x=1;
	static int y=1;
	static int s=60;
//	static boolean a = false;
	
	public static void rsZeichnen(Graphics g)
	{
			int rsx = x*64+6;
			int rsy = y*64+28;
			g.setColor(new Color(0,100,250));
			g.fillOval(rsx,rsy,s+1,s+1);
			g.setColor(new Color(200,255,255));
			g.drawOval(rsx,rsy,s,s);
	}
	// */
	public void bewegen(int xp, int yp)
	{
		if (Bloecke.zeile[yp][xp]==0)
		{
		 	x = xp;
		 	y = yp;
		} else if (Bloecke.zeile[yp][xp]==2)
		{
			Bloecke.zeile[yp][xp] = 0;
		 	x = xp;
		 	y = yp;		
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			bewegen(x,y-1); 
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			bewegen(x,y+1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			bewegen(x-1,y);	
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			bewegen(x+1,y);
		}
		else if (e.getKeyCode() == KeyEvent.VK_M)
		{ 
			if (Bloecke.level<3) 
				{
				for (int i=0; i<zeichnen.gegnerListe.size(); i++)
				{
					zeichnen.gegnerListe.remove();	
				}
				Bloecke.level += 1;
				Bloecke.zeile = Bloecke.nLevel(Bloecke.level);
//				zeichnen.gegnerListe = new LinkedList();
				zeichnen.initial();
				}
		}
		else if (e.getKeyCode() == KeyEvent.VK_N)
		{
			if (Bloecke.level>1) 
			{
				Gegner geg = null;
				Bloecke.level -= 1;
				Bloecke.zeile = Bloecke.nLevel(Bloecke.level);
				zeichnen.gegnerListe = new LinkedList();
				zeichnen.initial();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}