package SpaceInvaders.State;


import java.awt.*;

public interface SuperStateMachine {

    public void update(double delta);
    public void draw(Graphics2D g);
    public void init(Canvas canvas);


}
