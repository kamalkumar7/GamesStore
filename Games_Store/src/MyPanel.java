import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel  {
    
	MyPanel(){
		this.setPreferredSize(new Dimension(450, 450));
	}
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		int size=400;
		int sizey = 50;
		g2D.setStroke(new BasicStroke(1));
		g2D.setPaint(Color.white);
	    g2D.fillRect(0+size,0+sizey,450,450);
		g2D.setPaint(Color.red);
	    g2D.fillRect(30+size,180+sizey,30,30);
	    g2D.fillRect(30+size,210+sizey,150,30);
	    g2D.setPaint(Color.blue);
	    g2D.fillRect(240+size,30+sizey,30,30);
	    g2D.fillRect(210+size,30+sizey,30,150);
	    g2D.setPaint(Color.yellow);
	    g2D.fillRect(180+size,390+sizey,30,30);
	    g2D.fillRect(210+size,270+sizey,30,150);
	    g2D.setPaint(Color.green);
	    g2D.fillRect(390+size,240+sizey,30,30);
	    g2D.fillRect(270+size,210+sizey,150,30);
		g2D.setPaint(Color.black);
	    for(int i=0;i<=15;i++) {
	    	g2D.drawLine(30*i+size,0+sizey,30*i+size,450+sizey);
	    	g2D.drawLine(0+size,30*i+sizey,450+size,30*i+sizey);
	    }
	    
	    g2D.setPaint(Color.red);
	    g2D.fillRect(0+size,0+sizey,180,180);
	    int [] x = {180+size,225+size,180+size};
	    int [] y = {180+sizey,225+sizey,270+sizey};
	    g2D.fillPolygon(x,y,3);
	    
	    g2D.setPaint(Color.blue);
	    g2D.fillRect(270+size,0+sizey,180,180);
	    x[0] = 180+size;
	    x[1] = 270+size;
	    x[2] = 225+size;
	    y[0] = 180+sizey;
	    y[1] = 180+sizey;
	    y[2] = 225+sizey;
	    g2D.fillPolygon(x,y,3);
	    
	    g2D.setPaint(Color.yellow);
	    g2D.fillRect(0+size,270+sizey,180,180);
	    x[0] = 225+size;
	    x[1] = 180+size;
	    x[2] = 270+size;
	    y[0] = 225+sizey;
	    y[1] = 270+sizey;
	    y[2] = 270+sizey;
	    
	    g2D.fillPolygon(x,y,3);
	    g2D.setPaint(Color.green);
	    g2D.fillRect(270+size,270+sizey,180,180);
	    x[0] = 270+size;
	    x[1] = 225+size;
	    x[2] = 270+size;
	    y[0] = 180+sizey;
	    y[1] = 225+sizey;
	    y[2] = 270+sizey;
	    g2D.fillPolygon(x,y,3);
	    
	    g2D.setPaint(Color.white);
	    g2D.fillRect(30+size,30+sizey,120,120);
	    g2D.fillRect(300+size,30+sizey,120,120);
	    g2D.fillRect(30+size,300+sizey,120,120);
	    g2D.fillRect(300+size,300+sizey,120,120);
	    g2D.setPaint(Color.red);
	    g2D.setStroke(new BasicStroke(3));
	    g2D.drawOval(185+size, 65+sizey, 20,20);
	    g2D.setPaint(Color.blue);
	    g2D.drawOval(365+size, 185+sizey, 20,20);
	    g2D.setPaint(Color.green);
	    g2D.drawOval(245+size, 365+sizey, 20,20);
	    g2D.setPaint(Color.yellow);
	    g2D.drawOval(65+size, 245+sizey, 20,20);
	    
	    g2D.setPaint(Color.black);
	    g2D.setStroke(new BasicStroke(1));
	    g2D.drawLine(180+size,180+sizey,180+size,270+sizey);
	    g2D.drawLine(180+size,180+sizey,270+size,180+sizey);
	    g2D.drawLine(0+size,270+sizey,180+size,270+sizey);
	    g2D.drawLine(270+size,270+sizey,450+size,270+sizey);
	    g2D.drawLine(270+size,270+sizey,270+size,450+sizey);
	    g2D.drawLine(270+size,0+sizey,270+size,180+sizey);
	    
	}
}
