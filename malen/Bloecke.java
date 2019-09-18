package malen;

import java.awt.Color;
import java.awt.Graphics;

public class Bloecke 
{
	static int level = 1;
	static char[][] zeile = nLevel(level);
	
	static char[][] nLevel(int n){
		if (n == 1) {
			char[][] lv1 = 
				{
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},//0
				    {  1,'S',  1,  0,  0,  0,  0,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  0,  0,  1},
					{  1,  0,  1,  0,  1,  1,  1,  0,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//2
					{  1,  0,  1,  0,  1,  0,  0,  0,  1,  0,  1,  0,  1,  0,  0,  1,  1,  1,  0,  1},
					{  1,  0,  1,  0,  1,  1,  1,  1,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//4
					{  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1,  0,  1,  0,  1},
					{  1,  1,  1,  1,  1,  1,  0,  1,  0,  1,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//6
					{  1,  0,  0,  0,  0,  0,  0,  1,  0,  0,'r',  2,  1,  0,  1,  1,  0,  1,  0,  1},
					{  1,  0,  1,  1,  1,  1,  1,  1,  0,  1,  0,  1,  1,  0,  1,  0,  0,  1,  0,  1},//8
					{  1,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  1,  0,  0,  1,  0,  1,  1,'C',  1},
					{  1,  0,  0,  0,  1,  0,  0,  0,  1,  1,  0,  0,  0,  1,  1,  0,  0,  1,'G',  1},//10
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
				    // 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
				};
			return lv1;
		} else if (n == 2){
			char[][] lv2 = 
				{
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},//0
				    {  1,'S',  0,  0,  1,  0,  0,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  0,  0,  1},
					{  1,  1,  1,  0,  1,  1,  1,  0,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//2
					{  1,  0,'v',  2,  0,  0,  0,  0,  1,  0,  1,  0,  1,  0,  0,  1,  1,  1,  0,  1},
					{  1,  0,'v',  2,  1,  1,  1,  1,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//4
					{  1,  0,'v',  2,  0,  0,  0,  0,  0,  0,  1,  0,  1,  1,  1,  1,  0,  1,  0,  1},
					{  1,  0,'v',  2,  1,  1,  0,  1,  1,  1,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//6
					{  1,  0,'v',  2,  0,  0,  0,  1,  0,  0,  0,  0,  1,  0,  1,  1,  0,  1,  0,  1},
					{  1,  0,'v',  2,  1,  1,  1,  1,  0,  1,  0,  1,  1,  0,  1,  0,  0,  1,  0,  1},//8
					{  1,  0,'v',  2,  0,  0,  0,  1,  0,  1,  0,  1,  0,  0,  1,  0,  1,  1,  0,  1},
					{  1,  0,  0,  0,  1,  0,  0,  0,  0,  1,  0,  0,  0,  1,  1,  0,  0,  1,'G',  1},//10
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
				    // 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
				};
			return lv2;
		} else {
			char[][] lv3 = 
				{
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},//0
				    {  1,  0,  1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  0,  1,  0,  0,  0,  1},
					{  1,  0,  1,  0,  1,  1,  1,  0,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//2
					{  1,  0,  1,  0,  1,  0,  0,  0,  1,  0,  1,  0,  1,  0,  0,  1,  1,  1,  0,  1},
					{  1,  0,  1,  0,  1,  1,  1,  1,  1,  0,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//4
					{  1,'r',  0,  0,  0,  0,  0,  0,  0,  0,  1,  0,  1,  1,  1,  1,  0,  1,  0,  1},
					{  1,  1,  1,  1,  1,  1,  0,  1,  1,  1,  1,  0,  1,  0,  0,  0,  0,  1,  0,  1},//6
					{  1,  0,  0,  0,  0,  0,  0,  1,  0,  0,  0,  0,  1,  0,  1,  1,  0,  1,  0,  1},
					{  1,  0,  1,  1,  1,  1,  1,  1,  0,  1,  0,  1,  1,  0,  1,  0,  0,  1,  0,  1},//8
					{  1,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  1,  0,  0,  1,  0,  1,  1,  0,  1},
					{  1,'S',  0,  0,  1,  0,  0,  0,  1,  1,  0,  0,  0,  1,  1,  0,  0,  1,'G',  1},//10
					{  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
				    // 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
				};
			return lv3;}
	}


	static void erstellen(Graphics g)
	{
		int rx = 0;
		int rrx = 64;
		int ry = 0;
		int rry = 64;
		for (int i=0; i<12; i++)
		{
			for (int j=0; j<20; j++)
			{
				if (zeile[i][j]==1) //solider Block, wo keiner durch kommt
				{
					rx = j*64 + 4;
					ry = i*64 + 26;
					g.setColor(new Color(230,150,00));
					g.fillRect(rx, ry, rrx, rry);
				}
				else if (zeile[i][j]==2) //Barriere fuer Gegner, die man selber aufloesen kann
				{
					rx = j*64 + 4;
					ry = i*64 + 26;
					g.setColor(new Color(0,200,00));
					g.fillRect(rx, ry, rrx, rry);
				}
				else if (zeile[i][j]=='G') //Ziel
				{
					rx = j*64 + 4;
					ry = i*64 + 26;
					g.setColor(new Color(0,250,00));
					g.fillRect(rx, ry, rrx, rry);
				}
			}
		}
	}
}
