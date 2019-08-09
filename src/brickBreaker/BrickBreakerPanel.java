package brickBreaker;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreakerPanel extends JPanel implements KeyListener {

    BrickBreakerPanel(){
        Brick paddle = new Brick(175,480,150,25,"paddle.svg");

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
