package model.extensions;

import model.Ball;
public class ChangeSpeedExtension extends BallExtension {

    private static final int DEFAULT_APPLYING_DURATION = 4000;
    private double speedBoostFactor;

    public ChangeSpeedExtension(Ball taker, double speedBoostFactor) {
        super(taker, taker.getIcon().getIcon());
        this.speedBoostFactor = speedBoostFactor;
    }

    @Override
    public void run() {
        inceaseBallSpeedBy();
        try {
            sleep(DEFAULT_APPLYING_DURATION);
        } catch (InterruptedException ex) {
        }
        restoreBallSpeed();
    }

    void inceaseBallSpeedBy() {
        Ball taker = (Ball) getTaker();
        taker.boostSpeed(speedBoostFactor);
    }

    void restoreBallSpeed() {
        Ball taker = (Ball) getTaker();
        taker.boostSpeed((1 / speedBoostFactor));
    }

}
