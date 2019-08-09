package brickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BrickBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Brick> bricks = new ArrayList<Brick>();
    Brick ball = new Brick(237, 435, 25, 25, "ball.png");
    Brick paddle = new Brick(175,480,150,25,"paddle.png");
    Animate animate;

    BrickBreakerPanel(){


        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        paddle.draw(g, this);
    }

    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            new Thread(() -> {
                while(true) {
                    update();
                    System.out.println("running");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException err) {
                        err.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
