package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame  extends JFrame {
    MyFrame() {
        Random random = new Random();
        this.setSize(400, 400);
        this.setTitle("jFrAmE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        this.setVisible(true);

    }
}
