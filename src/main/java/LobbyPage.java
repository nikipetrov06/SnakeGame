import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.HttpURLConnection;
import java.net.URL;

public class LobbyPage extends JFrame{
    private JTextArea userOne;
    private JTextArea userTwo;
    private JButton startGame;
    private JPanel lobbyPage;
    private Lobby lobby;

    public LobbyPage(String title, final Lobby lobby) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(lobbyPage);
        this.pack();
        this.lobby = lobby;
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                onWindowClose();
            }
        });
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (final User user : lobby.getUsers()) {
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JFrame ex = new Snake(user);
                            ex.setVisible(true);
                            ex.addWindowListener(new java.awt.event.WindowAdapter() {
                                @Override
                                public void windowClosing(WindowEvent e) {
                                    onWindowClose();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public void onWindowClose() {
        try{
            System.out.println("In window close");
            URL url = new URL("http://localhost:8080/remove?index=" + lobby.getIndex());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty(
                    "Content-Type", "application/x-www-form-urlencoded" );
            con.setRequestMethod("DELETE");
            con.connect();
            System.out.println(con.getResponseCode());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.exit(0);
    }

    public JTextArea getUserOne() {
        return userOne;
    }

    public JTextArea getUserTwo() {
        return userTwo;
    }
}
