import java.awt.*;  
import java.awt.event.*;  
import javax.swing.JOptionPane;
import javax.swing.JPanel;  
import javax.swing.JFrame;
public class Puzzle extends Frame implements ActionListener{  
/**
     *
     */
    private static final long serialVersionUID = 1L;

    
Button b1,b2,b3,b4,b5,b6,b7,b8,b9;  
Puzzle(){  
    JFrame frame = new JFrame();
    
     
    int x=500 , y=200;
    b1=new Button("1");  
    b1.setBounds(50+x,100,80,80);  
    b2=new Button("2");  
    b2.setBounds(150+x,100,80,80);  
    b3=new Button("3");  
    b3.setBounds(250+x,100,80,80);  
    b4=new Button("4");  
    b4.setBounds(50+x,250,80,80);  
    b5=new Button("5");
    b5.setBounds(150+x,250,80,80);

    b6=new Button("6");  
    b6.setBounds(250+x,250,80,80);  
    
    b7=new Button("7");  
    b7.setBounds(50+x,400,80,80);  
    b8=new Button("");  
    b8.setBounds(150+x,400,80,80);  

    b9=new Button("8");  
    b9.setBounds(250+x,400,80,80);  
      
    b1.addActionListener(this);  
    b2.addActionListener(this);  
    b3.addActionListener(this);  
    b4.addActionListener(this);  
    b5.addActionListener(this);  
    b6.addActionListener(this);  
    b7.addActionListener(this);  
    b8.addActionListener(this);  
    b9.addActionListener(this);  
    
    b1.setBackground(new Color(20,42,168));
    b2.setBackground(new Color(20,42,168));
    b3.setBackground(new Color(20,42,168));
    b4.setBackground(new Color(20,42,168));
    b5.setBackground(new Color(20,42,168));
    b6.setBackground(new Color(20,42,168));
    b7.setBackground(new Color(20,42,168));
    b8.setBackground(new Color(20,42,168));
    b9.setBackground(new Color(20,42,168));

    b1.setForeground(Color.white);;
    b2.setForeground(Color.white);;
    b3.setForeground(Color.white);;
    b4.setForeground(Color.white);;
    b5.setForeground(Color.white);;
    b6.setForeground(Color.white);;
    b7.setForeground(Color.white);;
    b8.setForeground(Color.white);;
    b9.setForeground(Color.white);;
      
    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);
    frame.add(b6);
    frame.add(b7);
    frame.add(b8);
    frame.add(b9);

    frame.setSize(1920,1080);  
    frame.setLayout(null);  
    frame.setVisible(true); 
    
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(null);
}  
public void actionPerformed(ActionEvent e){  
    if(e.getSource()==b1){  
        String label=b1.getLabel();  
        if(b2.getLabel().equals("")){  
            b2.setLabel(label);  
            b1.setLabel("");  
        }  
        if(b4.getLabel().equals("")){  
            b4.setLabel(label);  
            b1.setLabel("");  
        }  
    }  
    if(e.getSource()==b2){  
        String label=b2.getLabel();  
        if(b1.getLabel().equals("")){  
            b1.setLabel(label);  
            b2.setLabel("");  
        }  
        if(b3.getLabel().equals("")){  
            b3.setLabel(label);  
            b2.setLabel("");  
        }  
        if(b5.getLabel().equals("")){  
            b5.setLabel(label);  
            b2.setLabel("");  
        }  
    }  
    if(e.getSource()==b3){  
        String label=b3.getLabel();  
        if(b2.getLabel().equals("")){  
            b2.setLabel(label);  
            b3.setLabel("");  
        }  
        if(b6.getLabel().equals("")){  
            b6.setLabel(label);  
            b3.setLabel("");  
        }  
    }  
    if(e.getSource()==b4){  
        String label=b4.getLabel();  
        if(b1.getLabel().equals("")){  
            b1.setLabel(label);  
            b4.setLabel("");  
        }  
        if(b7.getLabel().equals("")){  
            b7.setLabel(label);  
            b4.setLabel("");  
        }  
        if(b5.getLabel().equals("")){  
            b5.setLabel(label);  
            b4.setLabel("");  
        }  
    }  
    if(e.getSource()==b5){  
        String label=b5.getLabel();  
        if(b2.getLabel().equals("")){  
            b2.setLabel(label);  
            b5.setLabel("");  
        }  
        if(b6.getLabel().equals("")){  
            b6.setLabel(label);  
            b5.setLabel("");  
        }  
        if(b4.getLabel().equals("")){  
            b4.setLabel(label);  
            b5.setLabel("");  
        }  
        if(b8.getLabel().equals("")){  
            b8.setLabel(label);  
            b5.setLabel("");  
        }  
    }  
    if(e.getSource()==b6){  
        String label=b6.getLabel();  
        if(b9.getLabel().equals("")){  
            b9.setLabel(label);  
            b6.setLabel("");  
        }  
        if(b3.getLabel().equals("")){  
            b3.setLabel(label);  
            b6.setLabel("");  
        }  
        if(b5.getLabel().equals("")){  
            b5.setLabel(label);  
            b6.setLabel("");  
        }  
    }  
    if(e.getSource()==b7){  
        String label=b7.getLabel();  
        if(b4.getLabel().equals("")){  
            b4.setLabel(label);  
            b7.setLabel("");  
        }  
        if(b8.getLabel().equals("")){  
            b8.setLabel(label);  
            b7.setLabel("");  
        }  
    }  
    if(e.getSource()==b8){  
        String label=b8.getLabel();  
        if(b9.getLabel().equals("")){  
            b9.setLabel(label);  
            b8.setLabel("");  
        }  
        if(b7.getLabel().equals("")){  
            b7.setLabel(label);  
            b8.setLabel("");  
        }  
        if(b5.getLabel().equals("")){  
            b5.setLabel(label);  
            b8.setLabel("");  
        }  
    }  
    if(e.getSource()==b9){  
        String label=b9.getLabel();  
        if(b6.getLabel().equals("")){  
            b6.setLabel(label);  
            b9.setLabel("");  
        }  
        if(b8.getLabel().equals("")){  
            b8.setLabel(label);  
            b9.setLabel("");  
        }  
    }  
      
    //congrats code  
    if(b1.getLabel().equals("1")&&b2.getLabel().equals("2")&&b3.getLabel()    
            .equals("3")&&b4.getLabel().equals("4")&&b5.getLabel().equals("5")    
            &&b6.getLabel().equals("6")&&b7.getLabel().equals("7")&&b8.getLabel()    
            .equals("8")&&b9.getLabel().equals("")){     
            JOptionPane.showMessageDialog(this,"Congratulations! You won.");    
    }    
}  

}  