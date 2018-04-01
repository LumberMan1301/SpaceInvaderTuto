package SpaceInvaders.Sprite;

import SpaceInvaders.EstructurasDeDatosLineales.Listas.Lista;
import SpaceInvaders.Timer.Timer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *Clase que va a permitir la animacion en pantalla
 * Por definicion: es un grafico de computadora que puede ser movido en pantalla y puede manipularse como una sola entidad
 */
public class SpriteAnimation {


    private Lista<BufferedImage> sprites = new Lista<BufferedImage>();
    private byte currentSprite;

    private boolean loop = false;
    private boolean play = false;
    private boolean destroyAfterAnim = false;



    /**
     * variables de la animacion, ubicacion en pantalla y velocidad de animacion
     */
    private Timer timer;
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

        timer = new Timer();
    }

    public void draw(Graphics2D g){
        g.drawImage(sprites.get(currentSprite),(int) getxPos(),(int)getyPos(), null);
        return;
    }

    public void update(double delta){
        if(isDestroyAfterAnim())
            return;
        if(loop && !play)
            loopAni();
        if (play && !loop)
            playAni();
    }

    public void stopAni(){
        loop = false;
        play = false;
    }
    public void resetSprite(){
        loop = false;
        play = false;
        currentSprite = 0;
    }

    private void loopAni(){
        if(timer.isTimerReady(animationSpeed) && currentSprite == sprites.getCapacidad()-1 ){
            currentSprite = 0;
            timer.resetTimer();
        }else if(timer.timerEvent(animationSpeed) && currentSprite != sprites.getCapacidad()-1 ){
            currentSprite++;
        }
    }

    private void playAni(){
        if(timer.timerEvent(animationSpeed) && currentSprite != sprites.getCapacidad()-1 && !isDestroyAfterAnim()){
            play = false;
            currentSprite = 0;
        }else if(timer.timerEvent(animationSpeed) && currentSprite == sprites.getCapacidad()&& isDestroyAfterAnim()){
            sprites = null;
        }else if(timer.timerEvent(animationSpeed) && currentSprite != sprites.getCapacidad()-1 ){
            currentSprite++;
        }
    }

    public boolean isSpriteAniDest(){
        if(sprites == null)
            return true;
        return false;
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

//#########################################################################################################
    /**
     * metodo para obtener la posicion horizontal
     * @return
     */
    public double getxPos() {
        return xPos;
    }

    /**
     * metodo para asignar la posicion horizontal
     * @param xPos
     */
    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * metodo para obtener la posicion vertical
     * @return
     */
    public double getyPos() {
        return yPos;
    }

    /**
     * metodo para asignar la posicion vertical
     * @param yPos
     */
    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    /**
     * metodo para obtener el estado de la animacion
     * @return
     */
    public boolean isDestroyAfterAnim() {
        return destroyAfterAnim;
    }

    /**
     * metodo para asignar el estado de la animacion
     * @param destroyAfterAnim
     */
    public void setDestroyAfterAnim(boolean destroyAfterAnim) {
        this.destroyAfterAnim = destroyAfterAnim;
    }

    public byte getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(byte currentSprite) {
        this.currentSprite = currentSprite;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
