package controller;

import java.awt.Container;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import constants.Constants;
import model.bricks.Brick;
import model.bricks.GlassyBrick;
import model.bricks.InvesibleBrick;
import model.bricks.WoodenBrick;

public class BrickDroper extends Thread {

    private ArrayList<ArrayList<Brick>> brickWall;
    private Container board;
    private static final int DROP_DOWN_DURATION = 500;
    private Arknoid gameManager;
    private static final int maximumBrickRows = 16 ;

    public BrickDroper(ArrayList<ArrayList<Brick>> brickWall, Container board, Arknoid gameManager) {
        this.brickWall = brickWall;
        this.board = board;
        this.gameManager = gameManager;
    }

    public void addNewBrickRow() {
        dropPreviousBricks();
        ArrayList<Brick> bricksRow = new ArrayList();
        Brick brick;
        int cols = Arknoid.WALL_WIDTH;
        for (int c = 0; c < cols; c++) {
            brick = getRandomBrickType();
            brick.placeBrick(Constants.BRICK_STANDARD_WIDTH * c, Constants.BRICK_STANDARD_HEIGHT * 0);
            bricksRow.add(brick);
            brick.addToBoard();
        }
        brickWall.add(0, bricksRow);
    }

    public Brick getRandomBrickType() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                return new WoodenBrick(board);
            case 1:
                return new GlassyBrick(board);
            default:
                return new InvesibleBrick(board);
        }
    }

    public synchronized void dropPreviousBricks() {
        for (ArrayList<Brick> brickRow : brickWall) {
            for (Brick brick : brickRow) {
                brick.placeBrick(brick.getAbsoluteX(), brick.getAbsoluteY() + Brick.BRICK_HEIGHT);
            }
        }
    }

    @Override
    public void run() {
        while (gameManager.getGameState() != constants.State.OVER) {
            synchronized (brickWall) {
                try {
                    sleep(DROP_DOWN_DURATION);
                    while (gameManager.getGameState() == constants.State.PAUSED) {
                        sleep(500);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(BrickDroper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (brickWallOutOfBound()) {             
                    gameManager.setGameState(constants.State.OVER);
                    break;             
            }
            addNewBrickRow();
        }
    }

    public synchronized boolean brickWallOutOfBound() {
        return brickWall.size() == maximumBrickRows;
    }

}
