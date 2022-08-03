import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MyLUDOFrame extends JFrame implements ActionListener {
     MyPanel panel ;
     JButton button[] = new JButton[16];
     JButton dice;
     Boolean[] boolArray = new Boolean[16];
     Border border = new LineBorder(Color.black, 1);
     Border borderdice = new LineBorder(Color.black, 1);
     int y=6;
     int arr[] = new int[16];
     int homex1[] = new int[4];
     int homey1[] = new int[4];
     int homex2[] = new int[4];
     int homey2[] = new int[4];
     String s = "move in ludo.wav";
     String p[] = new String[6];
     ImageIcon icon,frameicon;
     boolean b = true;
     boolean c = true;
     int size=400;
     int sizey =50;
     
     MyLUDOFrame(){
    	  frameicon = new ImageIcon("frameIcon.jpg"); //create an ImageIcon
    	  this.setIconImage(frameicon.getImage()); //change icon of frame
    	  homex1[0]=45+size;
    	  homex1[1]=115+size;
    	  homex1[2]=45+size;
    	  homex1[3]=115+size;
    	  homey1[0]=45+sizey;
    	  homey1[1]=45+sizey;
    	  homey1[2]=115+sizey;
    	  homey1[3]=115+sizey;
    	  homex2[0]=315+size;
    	  homex2[1]=385+size;
    	  homex2[2]=315+size;
    	  homex2[3]=385+size;
    	  homey2[0]=315+sizey;
    	  homey2[1]=315+sizey;
    	  homey2[2]=385+sizey;
    	  homey2[3]=385+sizey;
    	  p[0] = "Dice.jpg";
    	  p[1] = "Dice2.jpg";
    	  p[2] = "Dice3.jpg";
    	  p[3] = "Dice4.jpg";
    	  p[4] = "Dice5.jpg";
    	  p[5] = "Dice6.jpg";
		 dice = new JButton();
		 panel = new MyPanel();
		 
		for(int i=0;i<16;i++) {
			button[i] = new JButton();
			button[i].setBorder(border);
		}
		for(int i=0;i<16;i++) {
			boolArray[i] = false;
		}
		
		this.setBackground (Color.black);
		dice.addActionListener(this);
		
		button[0].addActionListener(this);
		button[0].setBackground(Color.red);
		button[1].addActionListener(this);
		button[1].setBackground(Color.red);
		button[2].addActionListener(this);
		button[2].setBackground(Color.red);
		button[3].addActionListener(this);
		button[3].setBackground(Color.red);
		button[4].addActionListener(this);
		button[4].setBackground(Color.blue);
		button[5].addActionListener(this);
		button[5].setBackground(Color.blue);
		button[6].addActionListener(this);
		button[6].setBackground(Color.blue);
		button[7].addActionListener(this);
		button[7].setBackground(Color.blue);

		button[8].addActionListener(this);
		button[8].setBackground(Color.yellow);
		button[9].addActionListener(this);
		button[9].setBackground(Color.yellow);
		button[10].addActionListener(this);
		button[10].setBackground(Color.yellow);
		button[11].addActionListener(this);
		button[11].setBackground(Color.yellow);

		button[12].addActionListener(this);
		button[12].setBackground(Color.green);
		button[13].addActionListener(this);
		button[13].setBackground(Color.green);
		button[14].addActionListener(this);
		button[14].setBackground(Color.green);
		button[15].addActionListener(this);
		button[15].setBackground(Color.green);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setBackground(Color.black);
		
		this.setResizable(true);
		
        for(int i=0;i<16;i++) {
        	this.add(button[i]);
        }
        this.add(dice);
		this.add(panel);
		
	    dice.setBounds(200+size,490+sizey,48,49);
	    dice.setBorder(borderdice);
	    icon = new ImageIcon(p[5]);
	    
     	  dice.setIcon(icon);
	    
		button[0].setBounds(45+size,45+sizey,20,20);
		button[1].setBounds(115+size,45+sizey,20,20);
		button[2].setBounds(45+size,115+sizey,20,20);
		button[3].setBounds(115+size,115+sizey,20,20);
		
		button[4].setBounds(315+size,45+sizey,20,20);
		button[5].setBounds(385+size,45+sizey,20,20);
		button[6].setBounds(315+size,115+sizey,20,20);
		button[7].setBounds(385+size,115+sizey,20,20);
		
		button[8].setBounds(45+size,315+sizey,20,20);
		button[9].setBounds(115+size,315+sizey,20,20);
		button[10].setBounds(45+size,385+sizey,20,20);
		button[11].setBounds(115+size,385+sizey,20,20);
		
		button[12].setBounds(315+size,315+sizey,20,20);
		button[13].setBounds(385+size,315+sizey,20,20);
		button[14].setBounds(315+size,385+sizey,20,20);
		button[15].setBounds(385+size,385+sizey,20,20);
        //for(int i=0;i<16;i++) {
	      button[0].setEnabled(boolArray[0]);
	      button[1].setEnabled(boolArray[1]);
	      button[2].setEnabled(boolArray[2]);
	      button[3].setEnabled(boolArray[3]);
	      button[12].setEnabled(boolArray[12]);
	      button[13].setEnabled(boolArray[13]);
	      button[14].setEnabled(boolArray[14]);
	      button[15].setEnabled(boolArray[15]);
		//}

		this.setVisible(true);
		
		
	}
      @Override
      public void actionPerformed(ActionEvent e) {
    	  int arrx1[] = {35,65,95,125,155,185,185,185,185,185,185,215,245,245,245,245,245,245,275,305,335,365,395,425,425,425,
    			 395,365,335,305,275,245,245,245,245,245,245,215,185,185,185,185,185,185,155,125,95,65,35,5,5,35,65,95,125,155,185};
    	  int arry1[] = {185,185,185,185,185,155,125,95,65,35,5,5,5,35,65,95,125,155,185,185,185,185,185,185,215,245,245,245,
    		 245,245,245,275,305,335,365,395,425,425,425,395,365,335,305,275,245,245,245,245,245,245,215,215,215,215,215,215,215};
    	  int arrx4[] = {395,365,335,305,275,245,245,245,245,245,245,215,185,185,185,185,185,185,155,125,95,65,35,5,5,5,35,65,
    	         95,125,155,185,185,185,185,185,185,215,245,245,245,245,245,245,275,305,335,365,395,425,425,395,365,335,305,275,245};
    	  int arry4[] = {245,245,245,245,245,275,305,335,365,395,425,425,425,395,365,335,305,275,245,245,245,245,245,245,215,185,
    	            185,185,185,185,185,155,125,95,65,35,5,5,5,35,65,95,125,155,185,185,185,185,185,185,215,215,215,215,215,215,215};
    	  
    	  
    	  
    	  sound sound = new sound();
    	  if(e.getSource()==dice&&c==true) {
    		  sound.soundPlay("dice in ludo.wav");
    		  
    		  Random x = new Random(); 
        	  y = x.nextInt(6)+1;
        	  icon = new ImageIcon(p[y-1]);
           	  dice.setIcon(icon);
    		  System.out.println(y);
    		  c = false;
    		 
    	  }
    	  
    	  
    	  
    	 if(b==true&&c==false) {
    	  if(e.getSource()==button[0]&&b==true) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(0,0,12);
    		  if(arr[0]!=0) {
    			  if(arr[0]==1||arr[0]==9||arr[0]==14||arr[0]==22||arr[0]==27||arr[0]==35||arr[0]==40||arr[0]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[0].setBounds(arrx1[arr[0]-1]-2+size,arry1[arr[0]-1]-2+sizey,12,12);
    			  }
    			  else if(arr[0]==57) {
    				  sound.soundPlay("player Q.wav");
    		      button[0].setBounds(arrx1[arr[0]-1]+size,arry1[arr[0]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[0].setBounds(arrx1[arr[0]-1]+size,arry1[arr[0]-1]+sizey,20,20);
    				  
    			  }
    	  }
    		  c=true;
    	  }
    	  
    	  
    	  
    	  if(e.getSource()==button[1]&&b==true) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(1,0,12);
    		  if(arr[1]!=0) {
    			  if(arr[1]==1||arr[1]==9||arr[1]==14||arr[1]==22||arr[1]==27||arr[1]==35||arr[1]==40||arr[1]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[1].setBounds(arrx1[arr[1]-1]-2+size,arry1[arr[1]-1]+sizey-2,12,12);
    			  }
    			  else if(arr[1]==57) {
    				  sound.soundPlay("player Q.wav");
    		      button[1].setBounds(arrx1[arr[1]-1]+size,arry1[arr[1]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[1].setBounds(arrx1[arr[1]-1]+size,arry1[arr[1]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  c=true;
    	  }
    	  
    	  
    	  
    	  if(e.getSource()==button[2]&&b==true) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(2,0,12);
    		  if(arr[2]!=0) {
    			  if(arr[2]==1||arr[2]==9||arr[2]==14||arr[2]==22||arr[2]==27||arr[2]==35||arr[2]==40||arr[2]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[2].setBounds(arrx1[arr[2]-1]-2+size,arry1[arr[2]-1]+sizey-2,12,12);
    			  }
    			  else if(arr[2]==57) {
    				  sound.soundPlay("player Q.wav");
    		      button[2].setBounds(arrx1[arr[2]-1]+size,arry1[arr[2]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[2].setBounds(arrx1[arr[2]-1]+size,arry1[arr[2]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  c=true;
    	  }
    	  
    	  
    	  if(e.getSource()==button[3]&&b==true) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(3,0,12);
    		  if(arr[3]!=0) {
    			  if(arr[3]==1||arr[3]==9||arr[3]==14||arr[3]==22||arr[3]==27||arr[3]==35||arr[3]==40||arr[3]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[3].setBounds(arrx1[arr[3]-1]-2+size,arry1[arr[3]-1]-2+sizey,12,12);
    			  }
    			  else if(arr[3]==57) {
    				  sound.soundPlay("player Q.wav");
    		  button[3].setBounds(arrx1[arr[3]-1]+size,arry1[arr[3]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[3].setBounds(arrx1[arr[3]-1]+size,arry1[arr[3]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  c=true;
    	  }
    	  
    	  button[12].setEnabled(!b);
		  button[13].setEnabled(!b);
		  button[14].setEnabled(!b);
		  button[15].setEnabled(!b);
		  button[0].setEnabled(b);
		  button[1].setEnabled(b);
		  button[2].setEnabled(b);
		  button[3].setEnabled(b);
		  
    	  }
    	 
    	 
    	 
    	 if(b==false&&c==false) {
    	  if(e.getSource()==button[12]&&b==false) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(12,12,0);
    		  if(arr[12]!=0) {
    			  if(arr[12]==1||arr[12]==9||arr[12]==14||arr[12]==22||arr[12]==27||arr[12]==35||arr[12]==40||arr[12]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[12].setBounds(arrx4[arr[12]-1]+size+10,arry4[arr[12]-1]+sizey+10,12,12);
    			  }
    			  else if(arr[12]==57) {
    				  sound.soundPlay("player Q.wav");
    		  button[12].setBounds(arrx4[arr[12]-1]+size,arry4[arr[12]-1]+sizey,20,20);
    			  }
    			  else
    				  button[12].setBounds(arrx4[arr[12]-1]+size,arry4[arr[12]-1]+sizey,20,20);
    		  }
    		  if(b==false)
        		  b=true;
        	  else
        		  b=false;
    		  c=true;
    	  }
    	  
    	  
    	  
    	  if(e.getSource()==button[13]&&b==false) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(13,12,0);
    		  if(arr[13]!=0) {
    			  if(arr[13]==1||arr[13]==9||arr[13]==14||arr[13]==22||arr[13]==27||arr[13]==35||arr[13]==40||arr[13]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[13].setBounds(arrx4[arr[13]-1]+size+10,arry4[arr[13]-1]+sizey+10,12,12);
    			  }
    			  else if(arr[13]==57) {
    				  sound.soundPlay("player Q.wav");
    		  button[13].setBounds(arrx4[arr[13]-1]+size,arry4[arr[13]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[13].setBounds(arrx4[arr[13]-1]+size,arry4[arr[13]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  
    		  if(b==false)
        		  b=true;
        	  else
        		  b=false;
    		  c=true;
    	  }
    	  
    	  
    	  
    	  if(e.getSource()==button[14]&&b==false) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(14,12,0);
    		  if(arr[14]!=0) {
    			  if(arr[14]==1||arr[14]==9||arr[14]==14||arr[14]==22||arr[14]==27||arr[14]==35||arr[14]==40||arr[14]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[14].setBounds(arrx4[arr[14]-1]+10+size,arry4[arr[14]-1]+sizey+10,12,12);
    			  }
    			  else if(arr[14]==57) {
    				  sound.soundPlay("player Q.wav");
    		  button[14].setBounds(arrx4[arr[14]-1]+size,arry4[arr[14]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[14].setBounds(arrx4[arr[14]-1]+size,arry4[arr[14]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  if(b==false)
        		  b=true;
        	  else
        		  b=false;
    		  c=true;
    	  }
    	  
    	  
    	  
    	  if(e.getSource()==button[15]&&b==false) {
    		  sound.soundPlay("move in ludo.wav");
    		  move(15,12,0);
    		  if(arr[15]!=0) {
    			  if(arr[15]==1||arr[15]==9||arr[15]==14||arr[15]==22||arr[15]==27||arr[15]==35||arr[15]==40||arr[15]==48) {
    				  sound.soundPlay("safe in ludo.wav");
    				  button[15].setBounds(arrx4[arr[15]-1]+10+size,arry4[arr[15]-1]+sizey+10,12,12);
    			  }
    			  else if(arr[15]==57) {
    				  sound.soundPlay("player Q.wav");
    		  button[15].setBounds(arrx4[arr[15]-1]+size,arry4[arr[15]-1]+sizey,20,20);
    			  }
    			  else {
    				  button[15].setBounds(arrx4[arr[15]-1]+size,arry4[arr[15]-1]+sizey,20,20);
    				  
    			  }
    		  }
    		  if(b==false)
        		  b=true;
        	  else
        		  b=false;
    		  c=true;
    	  }
    	  button[0].setEnabled(b);
		  button[1].setEnabled(b);
		  button[2].setEnabled(b);
		  button[3].setEnabled(b);
		  button[12].setEnabled(!b);
		  button[13].setEnabled(!b);
		  button[14].setEnabled(!b);
		  button[15].setEnabled(!b);
    	 }
      }
      
      public void move(int a, int x ,int b1) {
    	
    	  if(y!=6&&arr[x]==0&&arr[x+1]==0&&arr[x+2]==0&&arr[x+3]==0) {
			  b = false;
		  }
		  else {
			  if((arr[x]==57||arr[x]+y>57||(arr[x]==0&&y!=6))&&(arr[x+1]==57||arr[x+1]+y>57||(arr[x+1]==0&&y!=6))&&(arr[x+2]==57||
					  arr[x+2]+y>57||(arr[x+2]==0&&y!=6))&&(arr[x+3]==57||arr[x+3]+y>57||(arr[x+3]==0&&y!=6))){
				  b = false;
			  }
			  else {
				  if(y==6&&arr[a]==0){
					  arr[a] = 1;
				        b=true;
				    }
				  else if(y!=6&&arr[a]==0) {
					  arr[a] = 0;
					  b = true;
				  }
				  else {
					  if(arr[a]+y==57){
						  arr[a] = arr[a]+y;
					        b = true;
					    }
					  else {
						  if(arr[a]+y>=57) {
							  b=true;
						  }
						  else {
							  arr[a] = arr[a]+y;
							  if(arr[a]!=1&&arr[a]!=9&&arr[a]!=14&&arr[a]!=22&&arr[a]!=27&&arr[a]!=35&&arr[a]!=40&&arr[a]!=48&&arr[a]<52){
							        if(Math.abs(arr[a]-arr[b1])==26&&arr[b1]<52&&arr[b1]!=0){
							        	arr[b1] = 0;
							        	if(x==0)
							        		button[b1].setBounds(homex2[b1-12],homey2[b1-12],20,20);	
							        	else
							        		button[b1].setBounds(homex1[b1],homey1[b1],20,20);
							            b=true;
							        }
							        else if(Math.abs(arr[a]-arr[b1+1])==26&&arr[b1+1]<52&&arr[b1+1]!=0){
							        	arr[b1+1] = 0;
							        	if(x==0)
							        		button[b1+1].setBounds(homex2[b1+1-12],homey2[b1+1-12],20,20);	
							        	else
							        		button[b1+1].setBounds(homex1[b1+1],homey1[b1+1],20,20);
							            b=true;
							        }
							        else if(Math.abs(arr[a]-arr[b1+2])==26&&arr[b1+2]<52&&arr[b1+2]!=0){
							        	arr[b1+2] = 0;
							        	if(x==0)
							        		button[b1+2].setBounds(homex2[b1+2-12],homey2[b1+2-12],20,20);	
							        	else
							        		button[b1+2].setBounds(homex1[b1+2],homey1[b1+2],20,20);
							            b=true;
							        }
							        else if(Math.abs(arr[a]-arr[b1+3])==26&&arr[b1+3]<52&&arr[b1+3]!=0){
							        	arr[b1+3] = 0;
							        	if(x==0)
							        		button[b1+3].setBounds(homex2[b1+3-12],homey2[b1+3-12],20,20);	
							        	else
							        		button[b1+3].setBounds(homex1[b1+3],homey1[b1+3],20,20);
							            b=true;
							        }
							        else if(y==6&&arr[a]<=57){
							    b=true;
							    
							        }
							        else
							            b=false;
							    }
							  else if (y==6&&arr[a]<=57) {
							  b = true;
						  }
							 else {
   							  b = false;
							 }
					  }
					  }
				  }
			  }
		  }
    	 
      }
      
      
      
}
