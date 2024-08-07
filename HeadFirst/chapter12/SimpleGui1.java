package HeadFirst.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1 implements ActionListener {
    JButton button, button2, button3;
    public static void main(String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("My first button");
        JPanel panel = new JPanel();

        button = new JButton("Interview");
        button2 = new JButton("Click me");
        button3 = new JButton("Click me");
        button.addActionListener(this);
        button2.addActionListener(this);

        panel.add(button3);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.getContentPane().add(BorderLayout.SOUTH, button2);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("Congratulations! You got hired!");
        button2.setText("End");
    }
}