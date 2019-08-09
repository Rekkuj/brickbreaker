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

    BrickBreakerPanel(){
        for (int i = 0; i < 8; i++)
            bricks.add(new Brick((i*60+2), 0, 60, 25, "blue.png"));
        for (int i = 0; i < 8; i++)
            bricks.add(new Brick((i*60+2), 25, 60, 25, "green.png"));
        for (int i = 0; i < 8; i++)
            bricks.add(new Brick((i*60+2), 50, 60, 25, "yellow.png"));
        for (int i = 0; i < 8; i++)
            bricks.add(new Brick((i*60+2), 75, 60, 25, "red.png"));

        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        bricks.forEach(brick -> {
            brick.draw(g, this);
        });

        ball.draw(g,this);

        paddle.draw(g, this);
    }

    public void update() {
        ball.x += ball.movX;

        if (ball.x > (getWidth() - 25) || ball.x < 0)
            ball.movX *=-1;

        if (ball.y < 0 || ball.intersects(paddle))
            ball.movY *=-1;

        ball.y += ball.movY;

        bricks.forEach(brick -> {
            if (ball.intersects(brick) && !brick.destroyed) {
                brick.destroyed = true;
                ball.movY *= -1;
            }
        });

        repaint();
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
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException err) {
                        err.printStackTrace();
                    }
                }
            }).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.width)) {
            paddle.x += 15;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 1) {
            paddle.x -= 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
