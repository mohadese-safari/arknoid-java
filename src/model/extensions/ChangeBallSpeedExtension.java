package model.extensions;

import model.Ball;

public class ChangeBallSpeedExtension extends BallExtension{

    public ChangeBallSpeedExtension(Ball taker) {
        super(taker, taker.getIcon().getIcon());
    }
    
}
