package SpaceInvaders.Display.Display;

import SpaceInvaders.Display.State.StateMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Clase que va a permitir visulizar el videojuego
 */
public class Display extends Canvas implements Runnable{
    /**
     * atributo que asigna un serial a cada objeto que es creado de esta clase
     */
    private static final long serialVersionUID = 1L;


    /**
     * Constructs a new Canvas.
     */
    public Display() {
        this.setSize(WIDTH, HEIGHT);
        this.setFocusable(true);//pone el display al frente de las demas ventanas

        state = new StateMachine(this);
        state.setStates((byte)0);
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
        frame.setTitle("Spcace Invaders");
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
    public int FPS;

    public static StateMachine state;



    /**
     * metodo propio de Runnable, es requerido si se desea trabajar con Threads
     */
    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        int frames = 0;

        this.createBufferStrategy(3);// mecanismo para organizar memoria, en programas relacionados con Canvas
        BufferStrategy bs = this.getBufferStrategy();


        while (running){
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer +=1000;
                FPS = frames;
                frames = 0;
            }
            draw(bs);
            update(delta);

            try {
                Thread.sleep(((lastLoopTime - System.nanoTime())+OPTIMAL_TIME)/1000000);
            }catch (Exception e){};
        }
    }

    public void draw(BufferStrategy bs){
        do{
            do{
                Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0,0,WIDTH, HEIGHT);

                state.draw(g);


                g.dispose();


            }while(bs.contentsRestored());
            bs.show();//
        }while(bs.contentsLost());
    }

    public void update(double delta){
        state.update(delta);
    }
}
