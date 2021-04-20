package model.extensions;

import model.Ball;
import constants.Constants;

public class FireBallExtension extends BallExtension {

    private static final int DEFAULT_APPLYING_DURATION = 6000;

    public FireBallExtension(Ball taker) {
        super(taker, Constants.FIRE_BALL);
    }

    @Override
    public void run() {
        fireBall();
        try {
            sleep(DEFAULT_APPLYING_DURATION);
        } catch (InterruptedException ex) {
        }
        unfireBall();
    }

    void fireBall() {
        Ball taker = (Ball) getTaker();
        taker.setOnFire(true);
        taker.getIcon().setIcon(Constants.FIRE_BALL);
    }

    void unfireBall() {
        Ball taker = (Ball) getTaker();
        taker.setOnFire(false);
        taker.getIcon().setIcon(Constants.BALL);
    }

}
