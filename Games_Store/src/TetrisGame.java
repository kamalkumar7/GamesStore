import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.*;

public class TetrisGame extends JPanel
{
    public static int level =1;
    boolean pause = false;
    Music  m = new Music();
    private int currentPiece;
    int b = 1;
        
   final Point[][][] MyShapes = 
   {
       // I-Piece
       { { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
           { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) } },
 
       // J-Piece
       { { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
           { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) } },
 
       // L-Piece
       { { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
           { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
           { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) } },

          
 
                  // T point
                 {{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 1) },
                 { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
                 { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 0) },
 
                 { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 1) }},
               
                 
                 // O-Piece
                 {{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                 { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                 { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                 { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }}
             
   };
 
 
 
 // Colors
     final Color[] MyColors = 
   { Color.blue, Color.green, Color.orange, Color.yellow, Color.magenta, Color.pink, Color.red };
 
   private Point pt;
  
   private int rotation;
   private ArrayList<Integer> nextPieces = new ArrayList<Integer>();
 
   public long score;
   int maxheight =-78;
   private Color[][] well;
 
   public  void init() 
   {
     well = new Color[12][24];
     for (int i = 0; i < 12; i++) 
     {
       for (int j = 0; j < 23; j++) 
       {
         if (i == 0 || i == 11 || j == 22) 
         {
             well[i][j] = new Color(94,33,11);
         } 
         else 
         {
             well[i][j] = Color.black;
         }
       }
     }
 
     for(int i=1;i<11;i++)
     {
       well[i][2] = Color.darkGray;
     }
     newPiece();
   }
 
 
   // new Piece
 
   public void newPiece() 
   {
 
     pt = new Point(5, 2);
     rotation = 0;
 
     if (nextPieces.isEmpty()) 
     {
         Collections.addAll(nextPieces, 0, 4, 2,1,3);
         Collections.shuffle(nextPieces,new Random());
     }
 
     currentPiece = nextPieces.get((int)Math.random()*4);
     nextPieces.remove(0);
 
   }

    boolean collisionOccurs(int x, int y, int rotation) 
   {
 int flag =0;
     for (Point p : MyShapes[currentPiece][rotation]) 
     {
 
       if (well[p.x + x][p.y + y] != Color.black) 
       {
   
         flag =1;
 
         if(y<4)
         {
           flag=2;
           pause =true;
 
           new Thread() {
             @Override
             public void run() {
               while (true) {
                 try {
                   if(pause ==false)
                   {
                     Thread.sleep(1000);
                   }
                   else
                   {
                     Thread.sleep(100000);
                   }
                 } catch (InterruptedException e) {
                 }
               }
             }
           }.start();
           
         }
     
       
       }
     }
 
     if(flag ==1) return true;
 
     else if(flag==2) 
     {
  
      
        return true ;
 
       
     }
     return false;
   }
 
 
 
 
   // rotate function
   public void rotate(int i) 
   {
     int newRotation = (rotation + i) % 4;
 
     if (newRotation < 0)
     {
       newRotation = 3;
     }
 
     if (!collisionOccurs(pt.x, pt.y, newRotation))
     {
       rotation = newRotation;
     }
 
     repaint();
 
   }
 
   
   public void move(int i) 
   {
     if (!collisionOccurs(pt.x + i, pt.y, rotation)) {
       pt.x += i;
     }
     repaint();
   }
 
 
   public void dropDown() 
   {
 
 
     if (!collisionOccurs(pt.x, pt.y + 1, rotation)) 
     {
       pt.y += 1;
     } 
     else 
     {
 
       fixToWell();
  
     }
     repaint();
   }
 
   public void fixToWell()
   {
 
     
     for (Point p : MyShapes[currentPiece][rotation]) 
     {
       well[pt.x + p.x][pt.y + p.y] = MyColors[currentPiece];
     }
       clearRows();
 
       if(pause==false)
             {
                 newPiece();
             }
         
   }
   
   public void increaseScore()
   {
     if(pause ==false)
     {
      score+=1;
     }
     
   }
   
    
   public void deleteRow(int row) 
   {
     for (int j = row - 1; j > 0; j--) 
     {
       for (int i = 1; i < 11; i++) 
       {
         well[i][j + 1] = well[i][j];
       }
     }
   }
 
 
   public void clearRows() 
   {
 
     boolean gap;
     int numClears = 0;
     for (int j = 21; j > 0; j--) 
     {
 
       gap = false;
       for (int i = 1; i < 11; i++) 
       {
         if (well[i][j] == Color.black) 
         {
           gap = true;
           break;
         }
       }
 
       if (!gap) 
       {
         deleteRow(j);
         j += 1;
         numClears += 1;
       }
 
     }
 
     switch (numClears)
     {
 
       case 1:
         score += 100;
         break;
       case 2:
         score += 300;
         break;
       case 3:
         score += 500;
         break;
       case 4:
         score += 800;
         break;
     
     }
 
   }
 
 
   // drawPiece
   private void drawPiece(Graphics g)
   {
     g.setColor(MyColors[currentPiece]);
     for (Point p : MyShapes[currentPiece][rotation]) 
     {
       g.fillRect((p.x + pt.x) * 29 +500, (p.y + pt.y) * 29, 29, 29);
     }
     
   }
 
 
   @Override
   public void paintComponent(Graphics g) 
   {
     g.fillRect(500, 0, 29 * 12, 29 * 23);
 
 
    
   
     
 
     for (int i = 0; i < 12; i++) 
     {
       for (int j = 0; j < 23; j++)
       {
         g.setColor(well[i][j]);
 
         if((i<11&&i>=1)&& j==2)
         {
           g.setColor(new Color(10,10,10));
         }
         g.fillRect(29 * i +500, 29 * j, 28, 28);
       }
     }
 
     g.setColor(Color.black);
     // g.fillRect(820, 10, 120, 40);
     
     g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
 
    
 
     Toolkit t=Toolkit.getDefaultToolkit();  
     Image i=t.getImage("storeimg.png");  
     g.drawImage(i, 500,1000,this);  

     g.setColor(Color.black);
     g.fillRect(900, 100, 120, 40);
 
     g.fillRect(900, 150, 120, 40);
     g.setColor(Color.PINK);
     long level = score/500 +1;
     g.drawString(" Score : " + score, 900, 120);
     if(pause ==false)
     {
      g.drawString(" LEVEL: "+ level, 900, 170);
     }
     else
     {
      g.drawString("Game Over", 900, 170);
      if(b==1) {
      LoginFile F = new LoginFile();
      
      
      int S = (int)score;
    
      try {
		F.updata_data(Login.userID, 2,S);
		System.out.print(score);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }
      b++;
     }
     
    
    

    drawPiece(g);
   
   }
}