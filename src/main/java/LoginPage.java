

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class LoginPage extends JFrame{
    private JPanel loginPanel;
    private JTextField loginField;
    private JButton loginButton;

    public LoginPage(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    URL url = new URL("http://localhost:8080/login?username=" + loginField.getText());
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    int responseCode = con.getResponseCode();
                    System.out.println("GET Response Code :: " + responseCode);
                    String response = getResponse(responseCode, con);
                    User user = null;
                    if (responseCode == 200) {
                        Gson gson = new Gson();
                        user = gson.fromJson(response, User.class);
                        System.out.println(user.getUsername() + " " + user.getHighScore());
                        StartPage startPage = new StartPage("Start Page", user);
                        startPage.getUsernameField().setText(user.getUsername());
                        startPage.getHighScore().setText(String.valueOf(user.getHighScore()));
                        startPage.setVisible(true);
                    } else {
                        System.out.println(response);
                    }

                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame loginPage = new LoginPage("Login Page");
        loginPage.setVisible(true);
    }

    public static String getResponse(int responseCode, HttpURLConnection con) throws IOException {
        BufferedReader in = null;
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
