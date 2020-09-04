import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                JFrame startPage = new StartPage("Start Page");
                startPage.setVisible(true);
                try{
                    URL url = new URL("http://localhost:8080/login");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");


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
}
