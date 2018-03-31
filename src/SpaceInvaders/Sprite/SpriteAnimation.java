package SpaceInvaders.Sprite;

import SpaceInvaders.EstructurasDeDatosLineales.Listas.Lista;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *Clase que va a permitir la animacion en pantalla
 * Por definicion: es un grafico de computadora que puede ser movido en pantalla y puede manipularse como una sola entidad
 */
public class SpriteAnimation {


    private Lista<BufferedImage> sprites = new Lista<BufferedImage>();

    private boolean loop = false;
    private boolean play = false;
    private boolean destroyAfterAnim = false;



    /**
     * variables de la animacion, ubicacion en pantalla y velocidad de animacion
     */
    private double xPos;
    private double yPos;
    private int animationSpeed;

    /**
     * Constructor de la clase
     * "Controlador"
     * @param xPos posicion horizontal en la pantalla
     * @param yPos posicion vertical en la pantalla
     * @param animationSpeed velocidad de animacion
     */
    public SpriteAnimation(double xPos, double yPos, int animationSpeed) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.animationSpeed = animationSpeed;
    }

    public void draw(Graphics2D g){

    }

    public void update(double delta){

    }

    /**
     * metodo que agrega las animaciones a una lista de animaciones
     * @param spriteMap
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     */
    public void addSprite(BufferedImage spriteMap, int xPos, int yPos, int width, int height){
        sprites.agregar(spriteMap.getSubimage(xPos,yPos,width,height));
    }

    /**
     * metodo para iniciar la animacion
     * @param play
     * @param destroyAfterAnim
     */
    public void PlayAnimation(boolean play, boolean destroyAfterAnim){
        this.play = play;
        this.destroyAfterAnim = destroyAfterAnim;
    }

}
