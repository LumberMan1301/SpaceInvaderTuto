package SpaceInvaders.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Player implements KeyListener {

    private double xPos, yPos;
    private int width, height;

    private BufferedImage pSrite;
    private Rectangle rectangle;

    public Player(double xPos, double yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        rectangle = new Rectangle((int)xPos,(int)yPos,width,height);

        try{
            URL url = this.getClass().getResource("/SpaceInvaders/Imagenes/Player.png");
            pSrite = ImageIO.read(url);
        }catch (Exception e){

        }
    }

    public void draw(Graphics2D g){
        g.drawImage(pSrite,(int)xPos,(int)yPos ,width ,height ,null);
    }

    public void update(double delta){

    }

    /**
     * Invoked when a key has been typed.
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Invoked when a key has been released.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
