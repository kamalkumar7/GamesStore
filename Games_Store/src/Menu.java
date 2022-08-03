
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.*;

public class Menu  
{

    JButton b1;
    JButton b2 ;
    JFrame frame;
    JLabel menulabel =new JLabel();


    Menu()
    {
     
       JFrame frame = new JFrame();

 
       JLabel label = new JLabel();
       label.setBounds(-150, 0,1900 , 200);
       label.setText("MENU 🎮");
       label.setIconTextGap(25);
         
       frame.setTitle("Game Store");
       frame.setSize(1920,1080);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setLayout(null);
   
       label.setFont(new Font("Helvetica",Font.BOLD,20));

   
       label.setVerticalAlignment(JLabel.TOP);
       label.setHorizontalAlignment(JLabel.CENTER);

       JLabel label_name = new JLabel();
       label_name.setBounds(0, -20,1900 , 100);
       label_name.setText(" ID -  "+ Login.userID);
       label_name.setFont(new Font("Helvetica",Font.BOLD,30));

       JLabel label_score = new JLabel();
       label_score.setBounds(0, -20,1900 , 200);
      //  label_score.setText(" ID -  "+ Login.userID);
       label_score.setFont(new Font("Helvetica",Font.BOLD,30));
   
   
       ImageIcon gameimg = new ImageIcon("storeimg.png");
       label.setIcon(gameimg);
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setVerticalTextPosition(JLabel.BOTTOM);
   
       menulabel.setBounds(-150, 200,1920 , 100);

       menulabel.setHorizontalTextPosition(JLabel.CENTER);
       menulabel.setVerticalTextPosition(JLabel.BOTTOM);
       menulabel.setVerticalAlignment(JLabel.CENTER);
       menulabel.setHorizontalAlignment(JLabel.CENTER);

       
       
       
   
       JLabel menulabel2 = new JLabel();
       menulabel2.setBounds(-150, 350,1920 , 100);


       menulabel2.setHorizontalTextPosition(JLabel.CENTER);
       menulabel2.setVerticalTextPosition(JLabel.BOTTOM);
       menulabel2.setVerticalAlignment(JLabel.CENTER);
       menulabel2.setHorizontalAlignment(JLabel.CENTER);
   
   
       JLabel menulabel3 = new JLabel();
       menulabel3.setBounds(-150, 500,1900 , 100);

       menulabel3.setHorizontalTextPosition(JLabel.CENTER);
       menulabel3.setVerticalTextPosition(JLabel.BOTTOM);
       menulabel3.setVerticalAlignment(JLabel.CENTER);
       menulabel3.setHorizontalAlignment(JLabel.CENTER);


       JLabel menulabel4 = new JLabel();
       menulabel4.setBounds(-150, 650,1900 , 100);

       menulabel4.setHorizontalTextPosition(JLabel.CENTER);
       menulabel4.setVerticalTextPosition(JLabel.BOTTOM);
       menulabel4.setVerticalAlignment(JLabel.CENTER);
       menulabel4.setHorizontalAlignment(JLabel.CENTER);

    
       frame.add(label);
       frame.add(label_name);
       frame.add(menulabel);
       frame.add(menulabel2);
       frame.add(menulabel3);
       frame.add(menulabel4);
       frame.add(label_score);
  
       JButton b1 = new JButton("LUDO");
      
       b1.setVisible(true);
       b1.setFocusable(false);
       b1.setBounds(590, 0,150 , 100);
       b1.setHorizontalAlignment(JLabel.CENTER);
       b1.setBackground(new Color(17, 13, 61));
       b1.setForeground(new Color(255,255,100));


       menulabel.add(b1);
   
   
   
       JButton b2 = new JButton();
       b2.setText("SNAKE GAME");
       b2.setVisible(true);
       b2.setFocusable(false);
       b2.setBounds(590, 0,150 , 100);
       b2.setHorizontalAlignment(JLabel.CENTER);
       b2.setBackground(new Color(17, 13, 61));
       b2.setForeground(new Color(255,255,100));
       menulabel2.add(b2);
       



       JButton b9 = new JButton();
       b9.setText("SNAKE GAME");
       b9.setVisible(true);
       b9.setFocusable(false);
       b9.setBounds(850, 0,150 , 100);
       b9.setHorizontalAlignment(JLabel.CENTER);
       b9.setBackground(new Color(17, 13, 61));
       b9.setForeground(new Color(255,255,100));
       menulabel2.add(b9);


       JButton LeaderBoard = new JButton();
       LeaderBoard.setText("Leaderboard");
       LeaderBoard.setVisible(true);
       LeaderBoard.setFocusable(false);
       LeaderBoard.setBounds(1500, 10, 150 , 50);
       LeaderBoard.setHorizontalAlignment(JLabel.CENTER);
       LeaderBoard.setBackground(new Color(145, 23, 151));
       LeaderBoard.setForeground(new Color(255,255,100));
       label.add(LeaderBoard);
   
       JButton b3 = new JButton();
       b3.setText("BRICK BREAKER");
       b3.setVisible(true);
       b3.setFocusable(false);
       b3.setBounds(590, 0,150 , 100);
       b3.setHorizontalAlignment(JLabel.CENTER);
       b3.setBackground(new Color(17, 13, 61));
       b3.setForeground(new Color(255,255,100));
       menulabel3.add(b3);
 

       JButton b4 = new JButton();
       b4.setText("PUZZLE GAME");
       b4.setVisible(true);
       b4.setFocusable(false);
       b4.setBounds(590, 0,150 , 100);
       b4.setHorizontalAlignment(JLabel.CENTER);
       b4.setBackground(new Color(17, 13, 61));
       b4.setForeground(new Color(255,255,100));
       menulabel4.add(b4);


       JButton b5 = new JButton();
       b5.setText("TETRIS");
       b5.setVisible(true);
       b5.setFocusable(false);
       b5.setBounds(1090, 0,150 , 100);
       b5.setHorizontalAlignment(JLabel.CENTER);
       b5.setBackground(new Color(17, 13, 61));
       b5.setForeground(new Color(255,255,100));
       menulabel.add(b5);


       JButton b6 = new JButton();
       b6.setText("CAR GAME");
       b6.setVisible(true);
       b6.setFocusable(false);
       b6.setBounds(1090, 0,150 , 100);
       b6.setHorizontalAlignment(JLabel.CENTER);
       b6.setBackground(new Color(17, 13, 61));
       b6.setForeground(new Color(255,255,100));
       menulabel2.add(b6);


       JButton b7 = new JButton();
       b7.setText("TIC TAC TOE");
       b7.setVisible(true);
       b7.setFocusable(false);
       b7.setBounds(1090, 0,150 , 100);
       b7.setHorizontalAlignment(JLabel.CENTER);
       b7.setBackground(new Color(17, 13, 61));
       b7.setForeground(new Color(255,255,100));
       menulabel3.add(b7);



       JButton b8 = new JButton();
       b8.setText("Candy Rush");
       b8.setVisible(true);
       b8.setFocusable(false);
       b8.setBounds(1090, 0,150 , 100);
       b8.setHorizontalAlignment(JLabel.CENTER);
       b8.setBackground(new Color(17, 13, 61));
       b8.setForeground(new Color(255,255,100));
       menulabel4.add(b8);






       ImageIcon icon = new ImageIcon("logo.png");
       frame.setIconImage(icon.getImage());
       frame.getContentPane().setBackground(Color.WHITE);
       frame.setResizable(true);
       frame.setVisible(true);
   
   b1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
      new MyLUDOFrame();
     
    }
    });

    b4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
 
      new Puzzle();
     
    } 
    });

  b3.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
   new Load_brickBreak();
   
  }
  });

  b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
   

     new Snake().setVisible(true);
     
    }
    });


  b5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      new Tetris();
     
    }
    });


    b6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       CarGame C = new CarGame("Car Game");
       
      }
      });

    b7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          TicTacToe T = new TicTacToe();
          
       
      }
      });


      b8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            new CandyMain().setVisible(true);
         
        }
        });

        b9.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              
              GameFrame frame = new GameFrame();
           
          }
          });

  
  LeaderBoard.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     
      JFrame frameLB = new JFrame();
      frameLB.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
      JLabel label2 = new JLabel();
      
      label2.setBounds(0, 0,192 , 200);
      label.setText("MENU 🎮");
      label.setIconTextGap(25);
      frameLB.add(label2);

      JButton backB = new JButton();
      backB.setText(" MENU ");
      backB.setVisible(true);
      backB.setFocusable(false);
      backB.setBounds(50, 100,150 , 50);
      backB.setHorizontalAlignment(JLabel.CENTER);
      backB.setForeground(new Color(255,255,100));
      backB.setBackground(new Color(17, 13, 61));
      backB.setVisible(true);
      label2.add(backB);

      backB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         frameLB.dispose();
          new Menu();

         
        }
        });


        
		LoginFile x = new LoginFile();
		ArrayList<String> st = new ArrayList<String>();
		try {
			st = x.Store_data();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String s[] = {"ID" ,"Rank", "Score"};
		String data[][] = new String[st.size()] [3];
		for(int i=0;i<st.size();i++) {
			String sub_data[];
			   sub_data = st.get(i).split("-");
			data[i][0] = sub_data[0];
			data[i][1] = "";
			data[i][2] = sub_data[2];
		}
		Arrays.sort(data,new Comparator<String[]>()
    {
			@Override
			public int compare(String[] e1 , String[] e2) 
      {
				if(Integer.parseInt(e1[2]) < Integer.parseInt(e2[2]))
					return 1;
				else
					return -1;

			}
		});
		
		int Rank =1;
		data[0][1] = Integer.toString(Rank);
		for(int i=1;i<data.length;i++) {
			if(data[i][2].equals(data[i-1][2])) {
				data[i][1] = Integer.toString(Rank);
			}
			else {
				Rank++;
				data[i][1] = Integer.toString(Rank);
			}
		}
		JTable table = new JTable(data,s);
		table.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(400, 100, 500, 200);
		frameLB.add(scroll);
		frameLB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	  frameLB.setExtendedState(JFrame.MAXIMIZED_BOTH);
	  	  
	        frameLB.setLayout(null);
	        frameLB.setVisible(true);
     
    }
    });

}
}