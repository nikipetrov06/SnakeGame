import javax.swing.*;
import java.awt.*;

public class Snake extends JFrame {

    public Snake(final User user) {

        add(new Board(user));

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}