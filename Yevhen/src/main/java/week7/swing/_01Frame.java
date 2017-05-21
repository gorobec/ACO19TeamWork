package week7.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 26.11.16.
 */
public class _01Frame {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Main window");
//        frame.setResizable(false);
        frame.setVisible(true);
//
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Thread.sleep(1500);
        frame.setState(Frame.ICONIFIED);
        Thread.sleep(1500);
        frame.setExtendedState(Frame.NORMAL);

    }
}
