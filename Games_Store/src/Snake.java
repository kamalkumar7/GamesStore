import javax.swing.*;
public class Snake extends JFrame{

    Snake()
    {
        super("Snake Game");
        add(new board());
        pack();

        setLocationRelativeTo(null);
//      setTitle("Snake Game");
        setResizable(false);

    }

  
}
