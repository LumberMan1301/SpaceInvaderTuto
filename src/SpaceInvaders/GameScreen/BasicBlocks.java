package SpaceInvaders.GameScreen;

import SpaceInvaders.EstructurasDeDatosLineales.Listas.Lista;

import java.awt.*;


public class BasicBlocks {


    public Lista <Rectangle> wall = new Lista<Rectangle>();

    private int xPos, yPos;

    public BasicBlocks() {
        BasicBlocks(75, 450);
        BasicBlocks(275, 450);
        BasicBlocks(475, 450);
        BasicBlocks(675, 450);
    }

    public void draw(Graphics2D g){
        g.setColor(Color.GREEN);
        for(int i=0; i < wall.getCapacidad();i++){
            g.fill(wall.get(i));
        }
    }

    public void BasicBlocks(int xPos, int yPos) {

        int wallWidth = 3;

        int x=0, y=0;

        for(int i=0; i<13; i++){
            if((14+(i*2)+wallWidth < 22 + wallWidth)){
                row(14+(i*2)+wallWidth,xPos-(i*3),yPos+(i*3));
                x = (i*3);
            }else {
                row(22+wallWidth, xPos-x,yPos+(i*3));
                y=(i*3);
            }
        }
    }

    public void row(int rows, int xPos, int yPos){
        for(int i=0; i<rows; i++){
            Rectangle brick = new Rectangle(xPos +(i*3),yPos,3,3 );
            wall.agregar(brick);
        }
    }


}
