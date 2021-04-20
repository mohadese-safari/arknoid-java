package model;

import constants.Constants;
import controller.ExtensionController;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import view.Board;

public class Lumber extends GameCharacter implements AbsoluteLocation {
    
    private static final int step = 15;
    public final static int NORMALL_LUMBER_135_ZONE_LENGTH = 85;
    public final static int NORMALL_LUMBER_90_ZONE_LENGTH = 30;
    public final static int NORMALL_LUMBER_45_ZONE_LENGTH = 85;
    public final static int LUMBER_MAXIMUM_LIFE = 3;
    public final static int LUMBER_INITIAL_X = 500;
    public final static int LUMBER_INITIAL_Y = 600;
    public final static int NORMALL_LUMBER_WIDTH = 180;
    public final static int NORMALL_LUMBER_HEIGHT = 30;
    
    private ExtensionController extensionController;
    private int life;
    private Board board;
    private int score;
    
    public Lumber(Container parent, Board board) {
        super(Constants.LUMBER, parent, NORMALL_LUMBER_WIDTH, NORMALL_LUMBER_HEIGHT, LUMBER_INITIAL_X, LUMBER_INITIAL_Y);
        life = LUMBER_MAXIMUM_LIFE;
        this.board = board;
        addHealthyLumberKeyListener();
    }
    
    public void moveRight() {
        getIcon().setLocation(getIcon().getX() + step, getIcon().getY());
    }
    
    public void moveLeft() {
        getIcon().setLocation(getIcon().getX() - step, getIcon().getY());
    }
    
    public int getLife() {
        return life;
    }
    
    public void setLife(int life) {
        this.life = life;
    }
    
    public void setExtensionController(ExtensionController extensionController) {
        this.extensionController = extensionController;
    }
    
    public ExtensionController getExtensionController() {
        return extensionController;
    }
    
    public void addHealthyLumberKeyListener() {
        board.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (canMoveRight()) {
                        moveRight();
                    } else {
                        rightRepel();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (canMoveLeft()) {
                        moveLeft();
                    } else {
                        leftRepel();
                    }
                }
            }
        });
    }
    
    public void addConfusedLumberKeyListener() {
        board.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (canMoveRight()) {
                        moveRight();
                    } else {
                        rightRepel();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (canMoveLeft()) {
                        moveLeft();
                    } else {
                        leftRepel();
                    }
                }
            }
        });
    }
    
    public boolean canMoveRight() {
        return getAbsoluteX() + getWidth() <= getParent().getWidth();
        
    }
    
    public boolean canMoveLeft() {
        return getAbsoluteX() >= 0;
        
    }
    
    public void rightRepel() {
        setAbsoluteX(getParent().getWidth() - getWidth());
    }
    
    public void leftRepel() {
        setAbsoluteX(0);
    }
    
    public Board getBoard() {
        return board;
    }
    
    public void removeAllListeners() {
        KeyListener[] keyListeners = board.getKeyListeners();
        for (KeyListener kl : keyListeners) {
            board.removeKeyListener(kl);
        }
    }
    
    public void score(int hitScore) {
        score += hitScore;
        board.updateScore(score);
    }
    
    public void decreaseLife() {
        life--;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void setLocation(int x, int y) {
        getIcon().setLocation(x, y);
    }
    
}
