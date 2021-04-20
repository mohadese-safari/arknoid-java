package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ball;
import model.bricks.Brick;
import model.bricks.GiftedBrick;

public class BallMoveController extends Thread {

    private Arknoid gameManager;
    private Ball ball;
    private CollisionController collisionController;

    public BallMoveController(Ball ball, CollisionController collisionController, Arknoid gameManager) {
        this.ball = ball;
        this.collisionController = collisionController;
        this.gameManager = gameManager;
        ball.setMoveController(this);
    }

    @Override
    public void run() {
        while (true) {

            while (gameManager.getGameState() == constants.State.PLAYING) {
                if (ballOutOfBound()) {
                    gameManager.loseBall(ball);
                    return;
                }
                moveControl();
            }

            synchronized (gameManager.getGameState()) {
                while (gameManager.getGameState() == constants.State.PAUSED) {
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BallMoveController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            if (gameManager.getGameState() == constants.State.OVER) {
                break;
            }
        }
    }

    public void moveControl() {

        ball.moveOneStep();
        try {
            sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(BallMoveController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (collisionController.upBoundCollision()) {
            ball.reflection(90);
        } else if (collisionController.leftBoundCollision() || collisionController.rightBoundCollision()) {
            ball.reflection(180);
        }
        if (collisionController.zone135Collision()) {
            collisionController.handleCollission135();
        } else if (collisionController.zone45Collision()) {
            collisionController.handleCollission45();
        }

        Brick collisionedBrick = collisionController.findBrickCollision();

        synchronized (ball) {
            if (collisionedBrick != null) {
                synchronized (collisionedBrick) {
                    if (!collisionedBrick.isBroken()) {
                        if (!ball.isOnFire()) {
                            if (collisionController.brickLeftCollision(collisionedBrick)) {
                                ball.setLocation(collisionedBrick.getAbsoluteX() - ball.getWidth(), ball.getAbsoluteY());
                                ball.reflection(180);
                            } else if (collisionController.brickRightCollision(collisionedBrick)) {
                                ball.setLocation(ball.getAbsoluteX(), ball.getAbsoluteY());
                                ball.reflection(180);
                            } else {
                                ball.setLocation(ball.getAbsoluteX(), collisionedBrick.getAbsoluteY() + collisionedBrick.getHeight());
                                ball.reflection(90);
                            }
                            if (collisionedBrick instanceof GiftedBrick) {
                                GiftedBrick giftedBrick = (GiftedBrick) collisionedBrick;
                                giftedBrick.dropGift(collisionedBrick, ball, gameManager.getLumber(), collisionController, gameManager);
                            }
                        }

                    }
                    collisionedBrick.handleCollisin();
                    synchronized (collisionedBrick) {
                        if (collisionedBrick.isBroken()) {
                            collisionController.removeBrick(collisionedBrick);
                            gameManager.getLumber().score(collisionedBrick.getHitScore());
                        }
                    }
                }
            }
        }
    }

    public boolean ballOutOfBound() {
        return ball.getAbsoluteY() >= ball.getParent().getHeight();
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

}
