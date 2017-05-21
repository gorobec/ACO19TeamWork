package week7.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gorobec on 26.11.16.
 */
public class LoginListener implements ActionListener {


    private JTextField loginField;
    private JPasswordField passField;

    private static final String LOGIN = "admin";
    private static final String PASS = "admin";

    public LoginListener(JTextField loginField, JPasswordField passField) {
        this.loginField = loginField;
        this.passField = passField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (LOGIN.equals(loginField.getText()) &&
                PASS.equals(String.valueOf(passField.getPassword()))){
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong LOGIN or PASS");
        }
    }
}
