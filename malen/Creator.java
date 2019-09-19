package malen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.LinkedList;

public class Creator {
	static int x = 1;
	static int y = 1;
	static int s = 60;
//		static boolean a = false;

	public static void rsZeichnen(Graphics g) {
		int rsx = x * 64 + 6;
		int rsy = y * 64 + 28;
		g.setColor(new Color(0, 100, 100));
		g.fillOval(rsx, rsy, s + 1, s + 1);
		g.setColor(new Color(200, 255, 255));
		g.drawOval(rsx, rsy, s, s);
	}

	// */
	public void bewegen(int xp, int yp) {
		x = xp;
		y = yp;
	}

	public void deleteUnderlying(int xd, int yd) {
		Bloecke.zeile[yd][xd] = 0;
	}

	private void create(int x2, int y2, char c) {
		Bloecke.zeile[y2][x2] = c;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			bewegen(x, y - 1);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			bewegen(x, y + 1);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			bewegen(x - 1, y);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			bewegen(x + 1, y);
		} else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			deleteUnderlying(x, y);
		} else if (e.getKeyCode() == KeyEvent.VK_C) {
			char c = 1;
			create(x, y, c);
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			char c = 2;
			create(x, y, c);
		} else if (e.getKeyCode() == KeyEvent.VK_G) {
			char c = 3;
			create(x, y, c);
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 0, 'r');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_T) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 0, 'z');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_E) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 1, 'z');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_U) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 0, 'v');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 1, 'v');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 2, 'v');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_H) {
			Gegner geg = new Gegner();
			geg.initial(x, y, 3, 'v');
			zeichnen.gegnerListe.add(geg);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			zeichnen.alleGegnerLoeschen();
			zeichnen.gegnerListe = new LinkedList<Gegner>();
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			zeichnen.alleGegnerStarten();
		}
	}
}
