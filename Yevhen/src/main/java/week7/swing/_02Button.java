package week7.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gorobec on 26.11.16.
 */
public class _02Button {

    public static void main(String[] args) {
        JButton logInButton = new JButton("Log in");
        JButton cancelButton = new JButton("Cancel");
        JLabel loginLabel = new JLabel("Login");
        JLabel passLabel = new JLabel("Password");
        JTextField loginField = new JTextField(10);
        JPasswordField passField = new JPasswordField(10);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(15, 15, 15, 5);
        constraints.fill = GridBagConstraints.BOTH;

        JFrame frame = new MyFrame();


        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(loginLabel, constraints);
        constraints.gridy = 1;
        frame.add(passLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 5, 15, 15);
        frame.add(loginField, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(passField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(15, 15, 15, 15);
        frame.add(logInButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(cancelButton, constraints);
        frame.pack();
        frame.setVisible(true);


//

        logInButton.addActionListener(new LoginListener(loginField, passField));
        cancelButton.addActionListener(new CancelListener(loginField, passField));

    }

}
