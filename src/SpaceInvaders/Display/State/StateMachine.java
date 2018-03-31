package SpaceInvaders.Display.State;

import SpaceInvaders.Display.EstructurasDeDatosLineales.Listas.Lista;

import java.awt.*;


public class StateMachine  {



    private Lista<SuperStateMachine> states = new Lista<SuperStateMachine>();
    private Canvas canvas;
    private byte selectState = 0;

    public StateMachine (Canvas canvas){
        this.canvas = canvas;
    }
    public void draw(Graphics2D g){
        states.get(selectState).draw(g);
    }
    public void update(double delta){
        states.get(selectState).update(delta);
    }
    public void setStates (byte i){
        for (int r =0; r<canvas.getKeyListeners().length; r++){
            canvas.removeKeyListener(canvas.getKeyListeners()[r]);
            selectState = i;
            states.get(selectState).init(canvas);
        }
    }
    public byte getStates(){
        return selectState;
    }


}
