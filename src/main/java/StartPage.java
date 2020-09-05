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

    public StartPage(String title,final User user) throws HeadlessException {
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
                        JFrame ex = new Snake(user);
                        ex.setVisible(true);
                    }
                });
            }
        });
    }


    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getHighScore() {
        return highScore;
    }

    public void setHighScore(JTextField highScore) {
        this.highScore = highScore;
    }
}
