package SpaceInvaders.GameScreen;

import SpaceInvaders.Display.Display;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Player implements KeyListener {

    private final double speed = 5.0;

    private double xPos, yPos;
    private int width, height;

    private BufferedImage pSrite;
    private Rectangle rect;

    private boolean left = false;
    private boolean rigth = false;


    public Player(double xPos, double yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        rect = new Rectangle((int)xPos,(int)yPos,width,height);

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
        if(rigth && !left && xPos < Display.WIDTH-width){
            xPos += (speed * delta);
            rect.x = (int)xPos;
        }if(!rigth && left && xPos > 10){
            xPos -= (speed * delta);
            rect.x = (int)xPos;
        }


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
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rigth = true;
        }else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = true;
        }
    }

    /**
     * Invoked when a key has been released.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rigth = false;
        }else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = false;
        }
    }
}
