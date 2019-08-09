package brickBreaker;

import javax.swing.*;

public class BrickBreaker {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Brick Breaker");

        JFrame startScreen = new JFrame();
        JButton start = new JButton("Start");

        BrickBreakerPanel panel = new BrickBreakerPanel(jFrame, startScreen);

        start.addActionListener(listener -> {
            startScreen.setVisible(false);
            jFrame.setVisible(true);
        });

        jFrame.getContentPane().add(panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(false);
        jFrame.setSize(490,600);
        jFrame.setResizable(false);

        startScreen.getContentPane().add(start);
        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setVisible(true);
        startScreen.setSize(490,600);
        startScreen.setResizable(false);
    }
}
