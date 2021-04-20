package model.bricks;

import java.awt.Container;

public class InvesibleBrick extends Brick {

    private static final int MAXIMUM_LIFE = 1;
    private static final int SCORE = 150;

    public InvesibleBrick(Container ancestor) {
        super(null, ancestor, SCORE);
        setLife(MAXIMUM_LIFE);
    }

    @Override
    public void decreaseLife() {
        setLife(getLife() - 1);
    }

}
