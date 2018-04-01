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
    private boolean right = false;


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
        if(right && !left && xPos < Display.WIDTH-width){
            xPos += (speed * delta);
            rect.x = (int)xPos;
        }if(!right && left && xPos > 10){
            xPos -= (speed * delta);
            rect.x = (int)xPos;
        }


    }



    /**
     * Invoked when a key has been pressed.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT) {
            right = true;
            System.out.println("Moverse a la derecha");
        }else if (key == KeyEvent.VK_LEFT) {
            left = true;
            System.out.println("Moverse a la izquierda");
        }

        System.out.println("Usted esta oprimiendo"+e.getKeyCode());
    }

    /**
     * Invoked when a key has been released.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT) {
            right = false;
            System.out.println("-");
        }else if (key == KeyEvent.VK_LEFT) {
            left = false;
            System.out.println("-");
        }

    }

    /**
     * Invoked when a key has been typed.
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
