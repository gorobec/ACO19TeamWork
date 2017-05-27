package design_patterns.state.view;

import design_patterns.state.CoffeeMachine;
import week7.swing.MyFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 26.11.16.
 */
public class CoffeeMachineFrame {
    public static void main(String[] args) throws InterruptedException {

        CoffeeMachine coffeeMachine = new CoffeeMachine();


        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Coffee machine");
        frame.setResizable(false);
        frame.setVisible(true);


        JButton takeMoneyButton = new JButton("Take money");
        JButton makeCoffeeButton = new JButton("Make coffee");
        JButton giveChangeButton = new JButton("Give change");
        JButton makeChoiceButton = new JButton("Make choice");

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(15, 15, 15, 5);
        constraints.fill = GridBagConstraints.BOTH;


        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(takeMoneyButton, constraints);
        constraints.gridy = 1;
        frame.add(makeChoiceButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 5, 15, 15);
        frame.add(giveChangeButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(makeCoffeeButton, constraints);
        frame.pack();
        frame.setVisible(true);


        takeMoneyButton.addActionListener(e -> {
            try {
                coffeeMachine.takeMoney();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        giveChangeButton.addActionListener(e -> {
            try {
                coffeeMachine.giveChange();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        makeChoiceButton.addActionListener(e -> {
            try {
                coffeeMachine.makeChoice();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        makeCoffeeButton.addActionListener(e -> {
            try {
                coffeeMachine.makeCoffee();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

    }
}
