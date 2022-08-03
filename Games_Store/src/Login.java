import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Login implements ActionListener 
{
	
	LoginFile file = new LoginFile();
	JFrame frame =  new JFrame();
	JPanel panel =new JPanel();
	JPanel loginpanel =new JPanel();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton newButton = new JButton("Create an Account");
	JButton exitpanel = new JButton("Ok");
	JTextField Idfill = new JTextField();
	JPasswordField password = new JPasswordField();
	JLabel userIdlabel = new JLabel("User ID :");
	JLabel errorinac = new JLabel("This ID is taken.Try another..");
	JLabel errorinpass = new JLabel("Password should be size of 6");
	JLabel userpasslabel = new JLabel("Password :");
	JLabel Wrongdet = new JLabel("Incorrect ID or password. Please try again.");
	JLabel photo = new JLabel();
	Border border = new LineBorder(Color.white, 1);
	Font font = new Font("Outfit",Font.PLAIN,16);
	ImageIcon icon = new ImageIcon("gm.jpg");
	static String userID;
	int x = 435,y=170;
      Login(){
    	  
    	  userIdlabel.setBounds(50+x, 90+y, 75, 25);
    	  userIdlabel.setFont(font);
    	  userIdlabel.setForeground(Color.white);
    	  
    	  userpasslabel.setBounds(50+x, 140+y, 90, 25);
    	  userpasslabel.setFont(font);
    	  userpasslabel.setForeground(Color.white);
    	  
    	  Idfill.setBounds(150+x, 90+y, 206, 25);
    	  Idfill.setFont(font);
    	  Idfill.setForeground(Color.white);
    	  Idfill.setOpaque(false);
    	  
    	  
    	  password.setBounds(150+x, 85+55+y, 206, 25);
    	  password.setForeground(Color.white);
    	  password.setOpaque(false);
    	  
    	  
    	  loginButton.setBounds(150+x, 190+y, 102, 25);
    	  loginButton.addActionListener(this);
    	  loginButton.setFocusable(false);
    	  loginButton.setOpaque(false);
    	  loginButton.setContentAreaFilled(false);
    	  loginButton.setFont(font);
    	  loginButton.setForeground(Color.white);
    	  
    	  
    	  resetButton.setBounds(254+x, 190+y, 104, 25);
    	  resetButton.addActionListener(this);
    	  resetButton.setFocusable(false);
    	  resetButton.setOpaque(false);
    	  resetButton.setContentAreaFilled(false);
    	  resetButton.setFont(font);
    	  resetButton.setForeground(Color.white);
    	  
    	  newButton.setBounds(150+x, 230+y, 208, 25);
    	  newButton.addActionListener(this);
    	  newButton.setFocusable(false);
    	  newButton.setOpaque(false);
    	  newButton.setContentAreaFilled(false);
    	  newButton.setFont(font);
    	  newButton.setForeground(Color.white);
    	  
    	  Idfill.setBorder(border);
		  password.setBorder(border);
    	  panel.setBackground(Color.black);
    	  panel.setBounds(450,200, 350,200);
    	  panel.setBorder(border);
    	  
		  Wrongdet.setBounds(10, 5, 310, 50);
		  Wrongdet.setFont(font);
		  Wrongdet.setForeground(Color.red);
		  
		  panel.add(Wrongdet);
    	  panel.add(exitpanel);
    	  
	      exitpanel.setBounds(230, 150, 50, 25);
    	  exitpanel.addActionListener(this);
    	  exitpanel.setFocusable(false);
    	  exitpanel.setBorder(border);
    	  exitpanel.setBackground(Color.white);
    	  exitpanel.setFont(font);
    	  
    	  panel.setLayout(null);
    	  panel.setVisible(false);
    	  
    	  errorinac.setBounds(150+x, 115+y, 250, 25);
    	 
    	  loginpanel.add(errorinac);
    	  errorinac.setVisible(false);
    	  errorinac.setFont(font);
    	  errorinac.setForeground(Color.white);
    	  
    	  errorinpass.setBounds(150+x, 165+y, 250, 25);
    	  loginpanel.add(errorinpass);
    	  errorinpass.setVisible(true);
    	  errorinpass.setFont(font);
    	  errorinpass.setForeground(Color.white);
    	  
    	  loginpanel.setBackground(Color.black);
    	  loginpanel.setBounds(0,0, 1920,1080);
    	  
    	  loginpanel.add(userIdlabel);
    	  loginpanel.add(userpasslabel);
    	  loginpanel.add(Idfill);
    	  loginpanel.add(password);
    	  loginpanel.add(newButton);
    	  loginpanel.add(loginButton);
    	  loginpanel.add(resetButton);
    	 
    	  loginpanel.setLayout(null);
    	  frame.add(panel);
    	  loginpanel.add(photo);
    	  frame.add(loginpanel);
    	  
    	  photo.setIcon(icon);
    	  photo.setBounds(0, 0, 1920, 1080);
    	  
    	  
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	  frame.getContentPane().setBackground(Color.black);
          frame.setLayout(null);
          
          frame.setVisible(true);
          
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			Idfill.setText("");
			password.setText("");
			Border border1 = new LineBorder(Color.WHITE, 1);
			Idfill.setBorder(border1);
			password.setBorder(border1);
			errorinac.setVisible(false);
			
		}
		
		if(e.getSource()==newButton) {
			userID = Idfill.getText();
			String passw = String.valueOf(password.getPassword());
			Border border1 = new LineBorder(Color.red, 1);
			
			try {
				if(userID.length()!=0&&passw.length()==6) {
				if(file.addAccount(userID,passw)==0) {
				Idfill.setBorder(border1);
				errorinac.setVisible(true);
				}
				else {
					System.out.println("Successfully created account");
					new nameAndscore(userID,"0");
					 new Menu();              //////////////////////////////////////
						
					}
				
				}
				else {
					if(userID.length()==0&&passw.length()!=6) {
						Idfill.setBorder(border1);
						password.setBorder(border1);
						
					}
					else if(userID.length()==0&&passw.length()==6) {
						Idfill.setBorder(border1);
					}
					else if(userID.length()!=0&&passw.length()!=6) {
						password.setBorder(border1);
						
					}
					else {
					Idfill.setBorder(border1);
					password.setBorder(border1);
					System.out.println("not valid");
					}
					
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==loginButton) {
			Border border1 = new LineBorder(Color.red, 1);
			userID = Idfill.getText();
			String passw = String.valueOf(password.getPassword());
			try {
				if(userID.length()!=0&&passw.length()==6) {
					String sub_data[] = file.check(userID+"-"+passw);
				if(sub_data!=null) {
					
					System.out.println();
					
					new Menu();
				 /////////////////////////////////////////
				}
				else {
					loginpanel.setVisible(false);
					panel.setVisible(true);
				}
				}
				else {
					if((userID.length()==0&&passw.length()!=6)) {
						Idfill.setBorder(border1);
						password.setBorder(border1);
						
					}
					else if(userID.length()==0&&passw.length()==6) {
						Idfill.setBorder(border1);
					}
					else if(userID.length()!=0&&passw.length()!=6) {
						password.setBorder(border1);
						
					}
					else {
					Idfill.setBorder(border1);
					password.setBorder(border1);
					System.out.println("not valid");
					}
				}
					
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		if(e.getSource()==exitpanel) {
			Idfill.setText("");
			password.setText("");
			loginpanel.setVisible(true);
			panel.setVisible(false);
			
		}
	}
}
