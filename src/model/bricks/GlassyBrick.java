package model.bricks;

import java.awt.Container;
import constants.Constants;

public class GlassyBrick extends Brick{
    private static final int MAXIMUM_LIFE = 1;
    private static final int SCORE = 100 ;
    public GlassyBrick(Container ancestor) {
        super(Constants.GLASSY_BRICK,ancestor, SCORE);
        setLife(MAXIMUM_LIFE);
    }
     
    @Override
    public void decreaseLife(){
        setLife(getLife() - 1);
    }
    
}
