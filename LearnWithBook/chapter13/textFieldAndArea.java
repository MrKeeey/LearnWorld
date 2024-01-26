package LearnWithBook.chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class textFieldAndArea implements ActionListener {

    JTextArea text;
    JTextField field;
    int count = 0;
    public static void main(String[] args) {
        textFieldAndArea gui = new textFieldAndArea();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame("Text");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Click");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field = new JTextField(21);
        field.setText("Write text here");

        button.addActionListener(this);
        text = new JTextArea(10, 20);
        text.setLineWrap(true);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel2.add(field);
        panel.add(scroller);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(350, 300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        field.setText("Button clicked " + count + " times.");
        text.append("Button clicked \n");
    }
}
