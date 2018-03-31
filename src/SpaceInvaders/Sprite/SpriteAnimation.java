package SpaceInvaders.Sprite;

/**
 *Clase que va a permitir la animacion en pantalla
 * Por definicion: es un grafico de computadora que puede ser movido en pantalla y puede manipularse como una sola entidad
 */
public class SpriteAnimation {
    /**
     * variables de la animacion, ubicacion en pantalla y velocidad de animacion
     */
    private double xPos;
    private double yPos;
    private int animationSpeed;

    /**
     * Constructor de la clase
     * @param xPos
     * @param yPos
     * @param animationSpeed
     */
    public SpriteAnimation(double xPos, double yPos, int animationSpeed) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.animationSpeed = animationSpeed;
    }
}
