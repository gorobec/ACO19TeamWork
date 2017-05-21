package week7.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 26.11.16.
 */
public class MyFrame extends JFrame{

    public MyFrame() throws HeadlessException {
        setLayout(new GridBagLayout());
        setSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Main window");
    }
}
