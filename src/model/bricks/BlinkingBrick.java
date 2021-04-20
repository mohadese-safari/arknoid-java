package model.bricks;

import java.awt.Container;
import javax.swing.ImageIcon;

public class BlinkingBrick extends Brick {

    boolean enabled;
    private static final int MAXIMUM_LIFE = 1;
    private static final int SCORE = 200;

    public BlinkingBrick(Container parent) {
        super(null, parent, SCORE);
        setLife(MAXIMUM_LIFE);
    }

    @Override
    public void decreaseLife() {
        setLife(getLife() - 1);
    }
}
