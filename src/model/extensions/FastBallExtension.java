package model.extensions;
import model.Ball;

public class FastBallExtension extends ChangeSpeedExtension {

    private static final double SPEED_BOOST_FACTOR = 2;

    public FastBallExtension(Ball taker) {
        super(taker,SPEED_BOOST_FACTOR);       
    }
}
