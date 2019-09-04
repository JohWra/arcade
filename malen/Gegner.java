package malen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;


class Gegner
{
	int x;
	int y;
	int d=0; //Richtung
	boolean m = false; //Bewegungsueberpruefung
	char k; //v=vorwärts, z=vor&zurück, r=rechtwinklig
	
	void initial(int xp, int yp, int ri, char art)
	{
		k = art;
		x = xp;
		y = yp;
		d = ri;
		Timer timer1 = new Timer();
		timer1.schedule(
			new TimerTask() 
			{
				public void run() 
				{
					vorwaerts();
				}
			}, 100, 120);
	}

	public void gzeichnen(Graphics g)
	{
		int gx = x*64+6;
		int gy = y*64+28;
		int[] arrx = new int[3];
		int[] arry = new int[3];
		if (d==0)
		{
			arrx[1] = gx;
			arrx[2] = gx+31;
			arrx[0] = gx+62;
			arry[1] = gy+62;
			arry[2] = gy;
			arry[0] = gy+62;
		} else if (d==1) {
			arrx[1] = gx;
			arrx[2] = gx;
			arrx[0] = gx+62;
			arry[1] = gy;
			arry[2] = gy+62;
			arry[0] = gy+31;
		} else if (d==2) {
			arrx[1] = gx;
			arrx[2] = gx+31;
			arrx[0] = gx+62;
			arry[1] = gy;
			arry[2] = gy+62;
			arry[0] = gy;
		} else {
			arrx[1] = gx+62;
			arrx[2] = gx;
			arrx[0] = gx+62;
			arry[1] = gy;
			arry[2] = gy+31;
			arry[0] = gy+62;
		}
		if (k=='v')
		{		
			g.setColor(new Color(200,000,200));
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(250,150,250));
			g.drawPolygon(arrx, arry, arrx.length);
		} else if (k=='z') {
			g.setColor(new Color(100,000,200));
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(150,150,250));
			g.drawPolygon(arrx, arry, arrx.length);
		} else if (k=='r') {
			g.setColor(new Color(200,000,000));
			g.fillPolygon(arrx, arry, arrx.length);
			g.setColor(new Color(250,150,050));
			g.drawPolygon(arrx, arry, arrx.length);
		}
	}
	
	void vorwaerts()
	{
		int xd=0;
		int yd=0;
		if (d==0)
		{
			xd = x;
			yd = y-1;
		}
		else if (d==1)
		{
			xd = x+1;
			yd = y;
		}
		else if (d==2)
		{
			xd = x;
			yd = y+1;
		}
		else if (d==3)
		{
			xd = x-1;
			yd = y;
		}
		
		if (Bloecke.zeile[yd][xd]==0)
		{
			if (xd == Position.x && yd == Position.y)
			{ 
				if (m)
				{
					Position.x = 1;
					Position.y = 1;
					Bloecke.zeile[y][x]=0;
					x = xd;
					y = yd;
				} else {abbiegen();}
			} else {
				Bloecke.zeile[y][x]=0;
				x = xd;
				y = yd;
				m = true;
			}
		} else {
			m = false;
			abbiegen();
		}
		Bloecke.zeile[y][x]=9; //für Kollisionserkennung
	}
	
	private void abbiegen()
	{
		if (k=='r') {
			if (d<3) {d += 1;}
			else {d -= 3;}
		} else if (k=='z') {
			if (d<2) {d += 2;}
			else {d -= 2;}
		}
	}
}
