package malen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

class Gegner {
	int x;
	int y;
	int d = 0; // Richtung
	boolean m = false; // Bewegungsueberpruefung
	char k; // v=vorw�rts, z=vor&zur�ck, r=rechtwinklig
	boolean destroy = true;
	boolean delete = false;

	void initial(int xp, int yp, int richtung, char art, boolean move) {
		k = art;
		x = xp;
		y = yp;
		d = richtung;
		if(move) {
			start();			
		}
	}
	
	public void start() {		
		if(destroy) {
		destroy = false;
		final Timer timer1 = new Timer();
		timer1.schedule(new TimerTask() {
			public void run() {
				vorwaerts();
				if (destroy) {
					timer1.cancel();
					m = false;
					if(delete) {
						Bloecke.zeile[y][x] = 0;						
					}
				}
			}
		}, 100, 120);
		}
	}

	public void gzeichnen(Graphics g) {
		int gx = x * 64 + 6;
		int gy = y * 64 + 28;
		int[] arrx = new int[3];
		int[] arry = new int[3];
		if (d == 0) {
			arrx[1] = gx;
			arrx[2] = gx + 31;
			arrx[0] = gx + 62;
			arry[1] = gy + 62;
			arry[2] = gy;
			arry[0] = gy + 62;
		} else if (d == 1) {
			arrx[1] = gx;
			arrx[2] = gx;
			arrx[0] = gx + 62;
			arry[1] = gy;
			arry[2] = gy + 62;
			arry[0] = gy + 31;
		} else if (d == 2) {
			arrx[1] = gx;
			arrx[2] = gx + 31;
			arrx[0] = gx + 62;
			arry[1] = gy;
			arry[2] = gy + 62;
			arry[0] = gy;
		} else {
			arrx[1] = gx + 62;
			arrx[2] = gx;
			arrx[0] = gx + 62;
			arry[1] = gy;
			arry[2] = gy + 31;
			arry[0] = gy + 62;
		}
		if (k == 'v') {
			if (destroy) {
				g.setColor(new Color(50, 000, 50));
			} else {
				g.setColor(new Color(200, 000, 200));
			}
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(250, 150, 250));
			g.drawPolygon(arrx, arry, arrx.length);
		} else if (k == 'z') {
			if (destroy) {
				g.setColor(new Color(25, 000, 50));
			} else {
				g.setColor(new Color(100, 000, 200));
			}
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(150, 150, 250));
			g.drawPolygon(arrx, arry, arrx.length);
		} else if (k == 'r') {
			if (destroy) {
				g.setColor(new Color(50, 000, 000));
			} else {
				g.setColor(new Color(200, 000, 000));
			}
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(250, 150, 050));
			g.drawPolygon(arrx, arry, arrx.length);
		}
	}

	void vorwaerts() {
		int xd = 0; // neue Position
		int yd = 0;
		if (d == 0) // wenn Richtung 0
		{
			xd = x;
			yd = y - 1; // neue Position in y Richtung (oben)
		} else if (d == 1) {
			xd = x + 1; // (rechts)
			yd = y;
		} else if (d == 2) {
			xd = x;
			yd = y + 1;// (unten)
		} else if (d == 3) {
			xd = x - 1;// (links)
			yd = y;
		}

		if (Bloecke.zeile[yd][xd] == 0) // neue Position leer?
		{
			if (xd == Position.x && yd == Position.y) // wenn Spieler an neuer Position (Position == Spieler)
			{
				if (m) // wenn Gegner sich bewegt
				{
					Position.x = 1;// Ruecksetzung des Spielers
					Position.y = 1;
					Bloecke.zeile[y][x] = 0;// alte Position loeschen
					destroy = true;
				} else {
					abbiegen();
				} // wenn Gegner sich nicht bewegt abbiegen
			} else { // wenn Spieler nicht an neuer Position
				Bloecke.zeile[y][x] = 0;// alte Position loeschen
				x = xd;// weiterbewegen
				y = yd;
				m = true;// bewegt sich
			}
		} else if (Bloecke.zeile[yd][xd] == 3) // wenn Barriere an neuer Position
		{
			if (m) // wenn Gegner sich bewegt
			{ // Barriere loeschen und weiter bewegen
				Bloecke.zeile[y][x] = 0;// alte Position loeschen
				x = xd;// weiterbewegen
				y = yd;
			} else {
				abbiegen();
			} // wenn Gegner sich nicht bewegt abbiegen

		} else {// neue Position ist nicht frei
			m = false;// bewegt sich nicht
			abbiegen();
		}
		Bloecke.zeile[y][x] = '9'; // f�r Kollisionserkennung
	}

	private void abbiegen() {
		if (k == 'r') {
			if (d < 3) {
				d += 1;
			} else {
				d -= 3;
			}
		} else if (k == 'z') {
			if (d < 2) {
				d += 2;
			} else {
				d -= 2;
			}
		}
	}

	public void del() {
		destroy = true;
		delete = true;
	}
}
