import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false ;   // game should not start by itself
    private int score =0 ;
    private int Totalbrick = 21;
    private Timer timer ;
    private int delay = 4;   // maintain speed of ball
    private int playerX=310;
    private int ballposX= 120;
    private int ballposY=350;
    private int ballXdir=-3;
    private int ballYdir=-2;
    private MapGenerator map;

    public GamePlay()
    {
        map=new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer =new Timer(delay,this);
        timer.start();

    }

    public void paint(Graphics g){

        //  background
        g.setColor(Color.BLACK);
        g.fillRect(1,1,692,592);

        // drawing map
        map.draw((Graphics2D)g);

        // border
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,690,3);
        g.fillRect(691,0,3,592);

        // printing scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(" " + score ,500,30);

        // paddle
        g.setColor(Color.green);
        g.fillRect(playerX,550,100,8);

        // the ball
        g.setColor(Color.red);
        g.fillOval(ballposX,ballposY,20,20);


        // when all brick get over
        if(Totalbrick<=0){
            play =false;
            ballYdir=0;
            ballXdir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("You won  :",190,300);


            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press enter to restart ",270,380);
        }


        // after game over
        if(ballposY>570){
            play =false;
            ballYdir=0;
            ballXdir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("game over , scores :",190,300);


            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press enter to restart ",270,380);


        }


        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         timer.start();


         if(play){
             // when ball touches the paddle then change direction of ball
             if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                 ballYdir = -ballYdir;
             }


             A : for(int i=0; i<map.map.length ; i++){       // accessing the 2D map array created using the object map created
                                                             // created in the above class
                 for(int j=0; j<map.map[0].length; j++){
                     if(map.map[i][j]>0){

                         // setting current position of brick with which ball strike
                         int brickX = j*map.brickwidth +80 ;
                         int brickY = i*map.brickheight +50 ;

                         int brickwidth = map.brickwidth;
                         int brickheight = map.brickheight;

                         Rectangle rect = new Rectangle(brickX,brickY,brickwidth,brickheight);
                         Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                         Rectangle brickRect= rect;
                         // removing brick when ball touches it
                         if(ballRect.intersects(brickRect)){
                             map.setBrickValue(0,i,j);
                             Totalbrick--;
                             score +=5;


                             // changing direction of ball when it touches brick
                             if(ballposX +19<=brickRect.x || ballposX +1>=brickRect.x + brickRect.width){
                                 ballXdir = -ballXdir;
                             }else{
                                 ballYdir=-ballYdir;
                             }
                             break A;      // break from above A initilized for loop
                         }

                     }

                 }
             }




             ballposX+=ballXdir;     // make movement of ball when condition is true
             ballposY+=ballYdir;
             if(ballposX<0){           // checking left boundary
                 ballXdir=-ballXdir;
             }
             if(ballposY<0){          // checking top boundary
                 ballYdir=-ballYdir;
             }
             if(ballposX>670){        // checking right boundary
                 ballXdir=-ballXdir;
             }
         }

         repaint();       // call the paint function so redraw all things ar new position

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        // when game over abd pressing enter botton
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!false){
                play=true;
                ballposX=120;
                ballposY=350;
                ballXdir=-1;
                ballYdir=-2;
                playerX=310;
                score=0;
                Totalbrick=21;
                map=new MapGenerator(3,7);
                repaint();
            }
        }


    }

        public void moveRight () {
            play = true;
            playerX += 20;

        }
        public void moveLeft () {
            play = true;
            playerX -= 20;

        }


}
