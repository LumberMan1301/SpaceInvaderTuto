package SpaceInvaders.GameScreen;

import SpaceInvaders.Display.Display;
import SpaceInvaders.State.SuperStateMachine;

import java.awt.*;

public class GameScreen implements SuperStateMachine {

    private Player player;
    private BasicBlocks bb;

    public GameScreen(){
        player = new Player(Display.WIDTH/2-50, Display.HEIGHT-75, 50,50);
        bb = new BasicBlocks();
    }

    @Override
    public void update(double delta) {
        player.update(delta);
    }

    @Override
    public void draw(Graphics2D g) {
        player.draw(g);
        bb.draw(g);
    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(player);
    }
}
