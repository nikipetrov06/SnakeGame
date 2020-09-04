import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame{
    private JPanel startPage;
    private JTextField usernameField;
    private JTextField highScore;
    private JButton newGame;
    private JTextField singlePlayer;
    private JButton resumeGame;
    private JTextField multiPlayer;
    private JButton createLobby;
    private JButton joinLobby;

    public StartPage(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(startPage);
        this.pack();
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame ex = new Snake();
                        ex.setVisible(true);
                    }
                });
            }
        });
    }
}
