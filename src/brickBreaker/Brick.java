package brickBreaker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Brick extends Rectangle {

    Image pic;
    boolean destroyed;

    int posX, posY;

    Brick(int posX, int posY, int width, int height, String imageLocation){
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        try {
            pic = ImageIO.read(new File("src/" + imageLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, Component c) {
        if (!destroyed)
            g.drawImage(pic, posX, posY, width, height, c);
    }
}
