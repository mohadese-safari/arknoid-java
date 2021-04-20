package model.extensions;

import constants.Constants;
import controller.Arknoid;
import controller.ExtensionController;
import model.Ball;

public class ExtraBallExtension extends BallExtension {

    private ExtensionController extensionController;
    private Arknoid gameManager;

    public ExtraBallExtension(Ball taker, Arknoid gameManager) {
        super(taker, Constants.EXTRA_BALL_GIFT);
        this.extensionController = taker.getExtensionController();
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        try {
            addExtraBall();
        } catch (CloneNotSupportedException ex) {
        }

    }

    void addExtraBall() throws CloneNotSupportedException {
        System.out.println("So wtf");
        // clone balls
        //Ball clone1 = (Ball) taker.clone();
        //Ball clone2 = (Ball) taker.clone();

        Ball clone1 = new Ball(gameManager.getGamePanel(), +3, 10);
        Ball clone2 = new Ball(gameManager.getGamePanel(), -5, 10);

        // add them to game
        gameManager.addNewBall(clone1);
        gameManager.addNewBall(clone2);

        //throw them
        gameManager.throwBall(clone1);
        gameManager.throwBall(clone2);

    }

}
