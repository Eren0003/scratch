package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ImageIcon icon = new ImageIcon("dude.png");
        Border border = BorderFactory.createLineBorder(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)),3);

        JLabel label = new JLabel();
        label.setText("javaLabel");
        label.setIcon(icon);
//        label.setHorizontalTextPosition(JLabel.RIGHT);
//        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        label.setFont(new Font("Courier",Font.ITALIC,20));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(border);

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("jFrAmE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        frame.setVisible(true);
        frame.add(label);
    }
}