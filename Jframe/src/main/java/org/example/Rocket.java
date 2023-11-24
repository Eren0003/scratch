package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rocket extends JFrame implements KeyListener {
    JLabel label;
    ImageIcon icon ;
    Rocket(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        icon = new ImageIcon("/home/ekambaram/Downloads/Jframe/src/main/java/org/example/car1.png");
        label = new JLabel();
        label.setBounds(200,200,210,190);
        label.setIcon(icon);
//        label.setBackground(Color.red);
//        label.setOpaque(true);
        this.setSize(500,500);
        this.add(label);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);

    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()){
            case 'a':
                label.setLocation(label.getX()-5,label.getY());
                break;
            case 's':
                label.setLocation(label.getX(),label.getY()+5);
                break;
            case 'w':
                label.setLocation(label.getX(),label.getY()-5);
                break;
            case 'd':
                label.setLocation(label.getX()+5,label.getY());
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37 :
                label.setLocation(label.getX()-5,label.getY());
                break;
            case 40 :
                label.setLocation(label.getX(),label.getY()+5);
                break;
            case 38 :
                label.setLocation(label.getX(),label.getY()-5);
                break;
            case 39 :
                label.setLocation(label.getX()+5,label.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("you typed char :"+e.getKeyCode());
    }
}
