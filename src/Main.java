//This program uses a GUI to learn Gujarati, it is a novel program built from scratch with Java programming
//skills I have learnt along the way. I hope it will help people to learn Gujarati once it is finished.
//So far only the Gujarati consonants can be learnt, but looking to add more in the future.
//Gujarati is one of the many languages of India, it is mostly spoken by people from the Indian state of Gujarat.
//Date: 19/06/2021
//Author: Dilberto

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class Main {
    public static volatile int plays;

    public static void main(String[] args) {
        JFrame textFieldFrame = new JFrame();
        JTextField howManyTests = new JTextField();
        JLabel label1 = new JLabel();
        label1.setText("How many consonants would you like to be tested on?");
        label1.setFont(new Font("Consolas", Font.PLAIN, 15));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldFrame.add(Box.createRigidArea(new Dimension(0, 5)));
        howManyTests.setAlignmentX(Component.CENTER_ALIGNMENT);
        howManyTests.setPreferredSize(new Dimension(200, 50));
        textFieldFrame.add(label1);
        textFieldFrame.add(Box.createRigidArea(new Dimension(0, 5)));
        textFieldFrame.add(howManyTests);
        textFieldFrame.add(Box.createRigidArea(new Dimension(0, 5)));
        textFieldFrame.setSize(450, 100);
        textFieldFrame.setLayout(new BoxLayout(textFieldFrame.getContentPane(), BoxLayout.Y_AXIS));
        textFieldFrame.setVisible(true);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter presssed");
                plays = Integer.valueOf(howManyTests.getText());
                System.out.println(plays);
                textFieldFrame.dispatchEvent(new WindowEvent(textFieldFrame, WindowEvent.WINDOW_CLOSING));
            }
        };
        howManyTests.addActionListener(action);
        while (plays == 0) {
            try{
                Thread.sleep(5);
                if (plays != 0) {
                    System.out.println("Number of plays chossen: " + plays);
                }
            }catch(Exception e) {
            }
        }
        guessTheConsonantGame consonantGame = new guessTheConsonantGame();
    }
}
