import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;

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
        createLobby.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    URL url = new URL("http://localhost:8080/create?userId=" + user.getId());
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    int responseCode = con.getResponseCode();
                    String response = LoginPage.getResponse(responseCode, con);
                    Lobby lobby = null;
                    if (responseCode == 200) {
                        Gson gson = new Gson();
                        lobby = gson.fromJson(response, Lobby.class);
                        LobbyPage lobbyPage = new LobbyPage("Lobby Page", lobby);
                        lobbyPage.getUserOne().setText(user.getUsername());
                        lobbyPage.setVisible(true);
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }


    public JTextField getUsernameField() {
        return usernameField;
    }


    public JTextField getHighScore() {
        return highScore;
    }

}
