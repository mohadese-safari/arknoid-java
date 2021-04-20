package model.extensions;

import static java.lang.Thread.sleep;
import model.Ball;

public class SlowBallExtension extends ChangeSpeedExtension {

    private static final double SPEED_BOOST_FACTOR = 0.5;

    public SlowBallExtension(Ball taker) {
        super(taker, SPEED_BOOST_FACTOR);
    }

}
