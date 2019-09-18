package malen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

public class Position implements KeyListener {
	static int x = 1;
	static int y = 1;
	static int s = 60;
//	static boolean a = false;

	public static void rsZeichnen(Graphics g) {
		int rsx = x * 64 + 6;
		int rsy = y * 64 + 28;
		g.setColor(new Color(0, 100, 250));
		g.fillOval(rsx, rsy, s + 1, s + 1);
		g.setColor(new Color(200, 255, 255));
		g.drawOval(rsx, rsy, s, s);
	}

	// */
	public void bewegen(int xp, int yp) {
		if (Bloecke.zeile[yp][xp] == 0)// wenn kein Hindernis bewegen
		{
			x = xp;
			y = yp;
		} else if (Bloecke.zeile[yp][xp] == 2)// wenn Barriere
		{
			Bloecke.zeile[yp][xp] = 0;// Barriere loeschen
			x = xp;// bewegen
			y = yp;
		} else if (Bloecke.zeile[yp][xp] == 'G')// wenn am Ziel
		{
			Bloecke.zeile[yp][xp] = 0;// Barriere loeschen
			x = xp;// bewegen
			y = yp;
			nextLevel();
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			bewegen(x, y - 1);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			bewegen(x, y + 1);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bewegen(x - 1, y);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bewegen(x + 1, y);
		} else if (e.getKeyCode() == KeyEvent.VK_M) {
			nextLevel();
		} else if (e.getKeyCode() == KeyEvent.VK_N) {
			prevLevel();
		} else {
			if(zeichnen.c != null) {
				zeichnen.c.keyPressed(e);				
			}
		}
	}

	public void nextLevel() {
		if (Bloecke.level < 3) {
			zeichnen.alleGegnerLoeschen();
			zeichnen.gegnerListe = new LinkedList<Gegner>();
			Bloecke.level += 1;
			Bloecke.zeile = Bloecke.nLevel(Bloecke.level);
			zeichnen.initial();
		}
	}

	public void prevLevel() {
		if (Bloecke.level > 1) {
			zeichnen.alleGegnerLoeschen();
			zeichnen.gegnerListe = new LinkedList<Gegner>();
			Bloecke.level -= 1;
			Bloecke.zeile = Bloecke.nLevel(Bloecke.level);
			zeichnen.initial();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}