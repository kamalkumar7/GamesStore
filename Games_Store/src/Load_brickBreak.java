import javax.swing.*;
public class Load_brickBreak {
    Load_brickBreak()
    {
        JFrame frame=new JFrame();
        GamePlay gamePlay =new GamePlay();
    
        frame.setBounds(0,0,1920,1080);
        frame.setTitle("BrickBreaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        frame.add(gamePlay);
    }

}
