import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Tetris extends JPanel  {
    
public static int level =1;

Tetris()
{

  boolean pause = false;
  JFrame frmT = new JFrame("MyGame");
  frmT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  // frmT.setExtendedState(JFrame.); 
  frmT.setSize(1920, 1080);
  frmT.setVisible(true);
  ImageIcon iconn = new ImageIcon("tetris.png");
  frmT.setIconImage(iconn.getImage());
  TetrisGame game = new TetrisGame();


  // JButton pauseButton = new JButton("Pause");   
  // pauseButton.setVisible(true);
  // pauseButton.setFocusable(false);
  // pauseButton.setBounds(500, 700,150 , 100);
  // pauseButton.setBackground(new Color(17, 13, 61));
  // pauseButton.setForeground(new Color(255,255,100));
  // frmT.add(pauseButton);


 
  frmT.add(game);

  game.init();

  frmT.setBackground(new Color(51,143,195));
  


  frmT.setVisible(true);
  frmT.addKeyListener(new KeyListener() {
  
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
      switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
          game.rotate(-1);
          break;

        case KeyEvent.VK_DOWN:
          game.rotate(+1);
          break;

        case KeyEvent.VK_LEFT:
          game.move(-1);
          break;

        case KeyEvent.VK_RIGHT:
          game.move(+1);
          break;

        case KeyEvent.VK_SPACE:
          game.dropDown();

            game.increaseScore();
         
        
          break;

      }
    }

    public void keyReleased(KeyEvent e) 
    {
    }

  });
  

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
         
          game.dropDown();
        } catch (InterruptedException e) {
        }
      }
    }
  }.start();
}
}

