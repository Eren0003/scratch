package org.example;

import javax.swing.*;
import java.awt.*;

public class jPanel {
    public static void main(String[] args) {

        JLabel label1 = new JLabel();
        label1.setText("RED");
        label1.setForeground(Color.green);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
//        label1.setHorizontalTextPosition(JLabel.CENTER);
//        label1.setVerticalTextPosition(JLabel.CENTER);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setBounds(0,0,250,250);
        panel1.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(250,0,250,250);
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,250,500,250);
        panel3.setBackground(Color.green);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        panel1.add(label1);
        frame.add(panel2);
        frame.add(panel3);
    }
}
