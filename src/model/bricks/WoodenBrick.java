package model.bricks;

import java.awt.Component;
import java.awt.Container;
import constants.Constants;

public class WoodenBrick extends Brick {

    private static final int MAXIMUM_LIFE = 2;
    private static final int SCORE = 200;

    public WoodenBrick(Container parent) {
        super(Constants.WOODEN_BRICK, parent, SCORE);
        setLife(MAXIMUM_LIFE);
    }
 
    public void crackBrick() {
        getIcon().setIcon(Constants.CRACKED_WOODEN__BRICK);
    }

    @Override
    public void decreaseLife() {
        setLife(getLife() - 1);
        crackBrick();
    }
}
