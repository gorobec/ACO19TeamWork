package week7.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gorobec on 26.11.16.
 */
public class CancelListener implements ActionListener {
    private JTextField loginField;
    private JPasswordField passField;

    public CancelListener(JTextField loginField, JPasswordField passField) {
        this.loginField = loginField;
        this.passField = passField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginField.setText("");
        passField.setText("");
    }
}
