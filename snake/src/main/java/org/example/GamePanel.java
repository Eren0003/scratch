package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x [] = new int[SCREEN_WIDTH];
    final int y [] = new int[SCREEN_HEIGHT];
    int bodyParts = 6;
    int applesEaten ;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    public GamePanel(){
        Border border = BorderFactory.createLineBorder(Color.white);
        random = new Random();
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        setBorder(border);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);
    }
    public void draw(Graphics graphics){
        if(running) {
//            for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
//                graphics.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//                graphics.drawLine(0, i * UNIT_SIZE, SCREEN_HEIGHT, i * UNIT_SIZE);
//            }
            if(applesEaten%3 == 0){
                graphics.setColor(Color.orange);
                graphics.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
            }
            else{
                graphics.setColor(Color.red);
                graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(Color.green);
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
//                    graphics.setColor(new Color(30, 88, 11));
                    graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            graphics.setColor(Color.red);
            graphics.setFont(new Font("MV Boli",Font.PLAIN ,30));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("SCORE : "+applesEaten,(SCREEN_WIDTH-metrics.stringWidth("SCORE : "+applesEaten))/2,graphics.getFont().getSize());
        }
        else{
            gameOver(graphics);
        }
    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move (){
        for(int i = bodyParts ; i > 0 ; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction){
            case 'U':
                y[0] = y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0]+UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        if((x[0] == appleX && y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions(){
        //head collides with body
        for(int i = bodyParts ; i > 0 ; i--){
            if((x[0] == x[i] )&&(y[0] == y[i])){
                running = false;
            }
        }
//        head collides with left border
        if(x[0] < 0){
            x[0] = SCREEN_WIDTH;
        }
//        head collides with right border
        if(x[0] > SCREEN_HEIGHT){
            x[0] = 0;
        }
        //head collides with top border
        if(y[0] < 0){
            y[0] = SCREEN_HEIGHT;
        }
        //head collides with bottom border
        if(y[0] > SCREEN_HEIGHT){
            y[0] = 0;
        }
        //head collides with top border
        if(!running){
            timer.stop();
        }
    }
    public void gameOver(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free",Font.BOLD ,30));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("SCORE : "+applesEaten,(SCREEN_WIDTH-metrics1.stringWidth("SCORE : "+applesEaten))/2,graphics.getFont().getSize());

        graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free",Font.BOLD ,75));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("GAME OVER",(SCREEN_WIDTH-metrics2.stringWidth("GAME OVER"))/2,(SCREEN_HEIGHT)/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed (KeyEvent k){
            switch( k.getKeyCode()){
                case KeyEvent.VK_LEFT :
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction !='D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
