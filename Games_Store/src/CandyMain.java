import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CandyMain extends JFrame implements Runnable
{
	Thread t;
	CandyRush cr;

	public CandyMain(){
		t = new Thread(this,"Dispose");

		cr = new CandyRush(this);
		cr.start();
		add(cr);

		addKeyListener(cr);
		setTitle("Candy Rush"); //Title Frame
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setSize(1200, 700); 		//frame size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void run(){
		dispose();
	}


}