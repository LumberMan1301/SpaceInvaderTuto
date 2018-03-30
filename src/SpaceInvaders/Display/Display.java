package SpaceInvaders.Display;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que va a permitir visulizar el videojuego
 */
public class Display extends Canvas implements Runnable{
    /**
     * atributo que asigna un serial a cada objeto que es creado de esta clase
     */
    private static final long serialVersionUID = 1L;
    private int ele;

    /**
     * Constructs a new Canvas.
     */
    public Display() {
        this.setSize(WIDTH, HEIGHT);
        this.setFocusable(true);//pone el display al frente de las demas ventanas

    }

    /**
     * metodo principal para la ejecucion del programa
     * @param args
     */
    public static void main(String [] args){
        Display display = new Display();
        JFrame frame = new JFrame();
        frame.add(display);// agrega el canvas al Jframe
        frame.pack();
        frame.setTitle("Sp0ace Invaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);// para no cambiar el tamano de la pantalla de Juego
        frame.setVisible(true);
        // El display basico
        display.start();
    }

    /**
     * atributo tipo Thread para permitir ejecuciones en paralelo
     * atributo boolean para saber si el programa esta en ejecucion
     */
    private Thread thread;
    private boolean running = false;


    /**
     * metodo de inicio de la aplicacion, es "synchronized" para que permita a
     * diferentes threads acceder a los mismos recursos
     */
    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * atributos de la Clase Display para asignar el tamno de la ventana
      */
    public static int WIDTH = 800, HEIGHT = 600;


    /**
     * metodo propio de Runnable, es requerido si se desea trabajar con Threads
     */
    @Override
    public void run() {
        while (running){
            System.out.println("Systema en funcionamiento");
        }
    }
}
