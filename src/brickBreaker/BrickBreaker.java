package brickBreaker;

import javax.swing.*;

public class BrickBreaker {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Brick Breaker");

        BrickBreakerPanel panel = new BrickBreakerPanel();

        jFrame.getContentPane().add(panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(490,600);
        jFrame.setResizable(false);
    }
}
