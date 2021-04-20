package model.bricks;

import controller.Arknoid;
import controller.CollisionController;
import controller.Gift;
import java.awt.Container;
import model.Ball;
import constants.Constants;
import constants.ExtensionType;
import model.Lumber;
import model.extensions.*;

public class GiftedBrick extends Brick {

    private static final int MAXIMUM_LIFE = 1;
    private static final int SCORE = 50;
    private boolean dropped = false;

    public GiftedBrick(Container parent) {
        super(Constants.GIFTED__BRICK, parent, SCORE);
        setLife(MAXIMUM_LIFE);
    }

    public void dropGift(Brick srcBrick, Ball ball, Lumber lumber, CollisionController collisionController, Arknoid gameManager) {
        if (dropped) {
            return;
        }
        dropped = true;
        int random = (int) (Math.random() * 5) + 2;
        ExtensionType extensionType = ExtensionType.intToExtensionCode(random);
        Extension extension;
        Gift gift = null;

        switch (extensionType) {
            case FIRE_BALL:
                extension = new FireBallExtension(ball);
                gift = new Gift(ball, collisionController, srcBrick, extension, ball.getExtensionController(), Constants.FIRE_BALL_GIFT, ball.getParent());
                break;

            case EXTRA_BALL:
                extension = new ExtraBallExtension(ball, gameManager);
                gift = new Gift(ball, collisionController, srcBrick, extension, ball.getExtensionController(), Constants.EXTRA_BALL_GIFT, ball.getParent());

                break;

            case LARGE_LUMBER:
                break;

            case LITTLE_LUMBR:
                break;

            case SLOW_BALL:
                extension = new SlowBallExtension(ball);
                gift = new Gift(ball, collisionController, srcBrick, extension, ball.getExtensionController(), Constants.SPEED_DOWN, ball.getParent());
                break;

            case FAST_BALL:
                extension = new FastBallExtension(ball);
                gift = new Gift(ball, collisionController, srcBrick, extension, ball.getExtensionController(), Constants.SPEED_UP, ball.getParent());
                break;

            case CONFUSED_LUMBER:
                extension = new ConfusedLumberExtension(lumber);
                gift = new Gift(lumber, collisionController, srcBrick, extension, lumber.getExtensionController(), Constants.CONFUSED_LUMBER_GIFT, lumber.getParent());
                break;

            default:
        }

        int unknownChance = (int) (Math.random() * 6);
        if (unknownChance == 0) {
            gift.getIcon().setIcon(Constants.UNKNOW_GIFT);
        }
        Thread giftThread = new Thread(gift);
        giftThread.start();

    }

    @Override
    public void decreaseLife() {
        setLife(getLife() - 1);
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }
}
