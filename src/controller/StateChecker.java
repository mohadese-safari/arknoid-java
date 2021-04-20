package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StateChecker extends Thread {

    Arknoid gameManager;

    public StateChecker(Arknoid gameManager) {
        this.gameManager = gameManager;
        gameManager.setStateCheker(this);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (gameManager.getGameState()) {
                while (gameManager.getGameState() == constants.State.PLAYING) {
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BallMoveController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            switch (gameManager.getGameState()) {
                case PLAYING:
                    break;
                case OVER:
                    gameManager.gameOver();
                    return ;
            }
            
           // gameManager.setGameState(Arknoid.State.PLAYING);
           // notifyAll();
        }
    }

}
