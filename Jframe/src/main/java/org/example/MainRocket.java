package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class MainRocket extends JFrame implements ActionListener{
    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 600;
    private static final int CELL_SIZE = 20;
    private static final int MAX_SNAKE_LENGTH = 100;

    private int[][] gameBoard;
    private ArrayList<Point> snakeBody;
    private Point foodPosition;
    private int direction;
    private Timer timer;
    private Random random;

    public MainRocket() {
        setTitle("Snake Game");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        gameBoard = new int[GAME_WIDTH/CELL_SIZE][GAME_HEIGHT/CELL_SIZE];
        snakeBody = new ArrayList<Point>();
        random = new Random();
        direction = KeyEvent.VK_RIGHT;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
                    direction = KeyEvent.VK_LEFT;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
                    direction = KeyEvent.VK_RIGHT;
                } else if (e.getKeyCode() == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
                    direction = KeyEvent.VK_UP;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
                    direction = KeyEvent.VK_DOWN;
                }
            }
        });

        initializeGame();
    }

    private void initializeGame() {
        // Initialize game board with zeros
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = 0;
            }
        }

        // Initialize snake body with 3 cells
        snakeBody.clear();
        snakeBody.add(new Point(GAME_WIDTH/CELL_SIZE/2, GAME_HEIGHT/CELL_SIZE/2));
        snakeBody.add(new Point(GAME_WIDTH/CELL_SIZE/2-1, GAME_HEIGHT/CELL_SIZE/2));
        snakeBody.add(new Point(GAME_WIDTH/CELL_SIZE/2-2, GAME_HEIGHT/CELL_SIZE/2));

        // Generate first food position
        generateFoodPosition();

        // Start game timer
        timer = new Timer(100, this);
        timer.start();
    }

    private void generateFoodPosition() {
        int x = random.nextInt(GAME_WIDTH/CELL_SIZE);
        int y = random.nextInt(GAME_HEIGHT/CELL_SIZE);

        while (gameBoard[x][y] != 0) {
            x = random.nextInt(GAME_WIDTH/CELL_SIZE);
            y = random.nextInt(GAME_HEIGHT/CELL_SIZE);
        }

        foodPosition = new Point(x, y);
    }
    private void moveSnake() {
        // Move snake head in current direction
        Point head = snakeBody.get(0);
        Point newHead = new Point(head.x, head.y);
        if (direction == KeyEvent.VK_LEFT) {
            newHead.x--;
            if (newHead.x < 0) {
                newHead.x = gameBoard.length - 1; // Wrap around to the right side
            }
        } else if (direction == KeyEvent.VK_RIGHT) {
            newHead.x++;
            if (newHead.x >= gameBoard.length) {
                newHead.x = 0; // Wrap around to the left side
            }
        } else if (direction == KeyEvent.VK_UP) {
            newHead.y--;
            if (newHead.y < 0) {
                newHead.y = gameBoard[0].length - 1; // Wrap around to the bottom
            }
        } else if (direction == KeyEvent.VK_DOWN) {
            newHead.y++;
            if (newHead.y >= gameBoard[0].length) {
                newHead.y = 0; // Wrap around to the top
            }
        }

        // Check if snake has hit food
        if (newHead.equals(foodPosition)) {
            // Grow snake by adding new head to front
            snakeBody.add(0, newHead);
            gameBoard[newHead.x][newHead.y] = snakeBody.size();
            generateFoodPosition();
        } else {
            // Move snake body by shifting all cells forward
            for (int i = snakeBody.size() - 1; i > 0; i--) {
                Point curr = snakeBody.get(i);
                Point prev = snakeBody.get(i - 1);
                gameBoard[curr.x][curr.y] = gameBoard[prev.x][prev.y];
                curr.setLocation(prev);
            }

            // Move snake head to new position
            if (gameBoard[newHead.x][newHead.y] != 0) {
                // Snake has hit its own body, game over
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game over!");
                initializeGame();
            } else {
                snakeBody.set(0, newHead);
                gameBoard[newHead.x][newHead.y] = 1;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
