import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class board extends JPanel implements ActionListener{

    private Image downmouth;
    private Image enemy;
    private Image leftmouth;
    private Image rightmouth;
    private Image snakeimage;
    private Image snaketitle;
    private Image upmouth;
    private Image snakeBackground;

    private final int DOT_SIZE = 25;
    private final int ALL_DOTS = 782;

    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection =  true;
    private boolean upDirection =  false;
    private boolean downDirection =  false;
    private boolean inGame = true;
    private int count;
    private final int[] enemyxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private final int[] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    private final Random random = new Random();
    private int xpos;
    private int ypos;
    private int dots;

    private Timer timer;

    board(){

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(904, 700));

        setFocusable(true);

        loadImages();
        initGame();
    }

    public void loadImages(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("downmouth.png"));
        downmouth  = i1.getImage();

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("enemy.png"));
        enemy = i2.getImage();

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("leftmouth.png"));
        leftmouth = i3.getImage();

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("rightmouth.png"));
        rightmouth  = i4.getImage();

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("snakeimage.png"));
        snakeimage  = i5.getImage();

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("snaketitle.jpg"));
        snaketitle  = i6.getImage();

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("upmouth.png"));
        upmouth  = i7.getImage();

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("snakebackground.jpg"));
        snakeBackground  = i8.getImage();

    }

    public void initGame(){

        dots = 3;

        for(int z = 0 ; z < dots ; z++){
            x[z] = 150 - z * DOT_SIZE;
            y[z] = 100;
        }

        locateApple();

        timer = new Timer(100, this);
        timer.start();
    }


    public void locateApple(){

        xpos = random.nextInt(34);
        ypos = random.nextInt(23);
    }

    public void checkApple(){
        if((x[0] == enemyxpos[xpos]) && (y[0] == enemyypos[ypos])){
            dots++;
            locateApple();
        }
        count = dots;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g){
        if(inGame){
            g.drawImage(enemy, enemyxpos[xpos], enemyypos[ypos], this);
            g.setColor(Color.WHITE);
            g.drawRect(24,10,852,55);
            g.drawImage(snaketitle,25,11,this);

            g.setColor(Color.WHITE);
            g.drawRect(24,74,852,577);

            g.setColor(Color.WHITE);
            g.setFont(new Font("arial", Font.PLAIN,14));
            g.drawString("Scores : " + (count - 3),780,30);
            g.drawString("Length : " + count,780,50);

            for(int z = 0; z < dots ; z++){
                if(z == 0 && rightDirection){
                    g.drawImage(rightmouth, x[z], y[z], this);
                }
                if(z == 0 && leftDirection){
                    g.drawImage(leftmouth, x[z], y[z], this);
                }
                if(z == 0 && upDirection){
                    g.drawImage(upmouth, x[z], y[z], this);
                }
                if(z == 0 && downDirection){
                    g.drawImage(downmouth, x[z], y[z], this);
                }else{
                    g.drawImage(snakeimage, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
        }else{
            gameOver(g);
        }
    }


    public void gameOver(Graphics g){
        g.drawImage(snakeBackground,0,0,this);
        String msg = "Game Over";
        String score = "Your Score";
        int snake_length = count - 3;
        Font font = new Font("SAN_SERIF", Font.BOLD, 25);
        FontMetrics metrices = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (904 - metrices.stringWidth(msg)) / 2 , 700/2);
        g.drawString(score, (904 - metrices.stringWidth(score)) / 2, (700 /2) + 30);
        g.drawString(String.valueOf(snake_length), (904 - metrices.stringWidth(score)) / 2 + 50, (700 /2) + 60);
    }



    public void checkCollision(){

        for(int z = dots ; z > 0 ; z--){
            if((z > 4) && (x[0] == x[z]) && (y[0] == y[z])){
                inGame = false;
                break;
            }
        }
        if(!inGame){
            timer.stop();
        }
    }

    public void move(){

        for(int z = dots ; z > 0 ; z--){
            x[z] = x[z - 1];
            y[z] = y[z - 1];
        }

        if(leftDirection){
            x[0] = x[0] -  DOT_SIZE;

           
        }
        if(rightDirection){
            x[0] += DOT_SIZE;
        }
        if(upDirection){
            y[0] = y[0] -  DOT_SIZE;
        }
        if(downDirection){
            y[0] += DOT_SIZE;
        }
    }

    public void actionPerformed(ActionEvent ae){
        if(inGame){
            checkApple();
            checkCollision();
            move();
        }
        if(y[0] >= 650){
            y[0] = 75;
        }

        if(x[0] >= 875){
            x[0] = 25;
        }

        if(x[0] < 25){
            x[0] = 850;
        }

        if(y[0] < 75 ){
            y[0] = 625;
        }

        repaint();
    }


    private class TAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            int key =  e.getKeyCode();

            if(key == KeyEvent.VK_LEFT){
                leftDirection = true;
                if(!rightDirection){
                    leftDirection = true;
                }else{
                    leftDirection = false;
                    rightDirection = true;
                }
                upDirection = false;
                downDirection = false;
            }

            if(key == KeyEvent.VK_RIGHT ){
                rightDirection = true;
                if(!leftDirection){
                    rightDirection = true;
                }else{
                    rightDirection = false;
                    leftDirection = true;
                }
                upDirection = false;
                downDirection = false;
            }

            if(key == KeyEvent.VK_UP ){
                upDirection = true;
                if(!downDirection){
                    upDirection = true;
                }else{
                    upDirection = false;
                    downDirection = true;
                }
                leftDirection = false;
                rightDirection = false;
            }

            if(key == KeyEvent.VK_DOWN){
                downDirection = true;
                if(!upDirection){
                    downDirection = true;
                }else{
                    downDirection = false;
                    upDirection = true;
                }
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

}