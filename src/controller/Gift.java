package controller;

import java.awt.Container;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.bricks.Brick;
import constants.Constants;
import model.GameCharacter;
import model.extensions.Extension;

public class Gift<T extends GameCharacter> extends GameCharacter implements Runnable {

    private T probableOwner;
    private CollisionController collisionController;
    private Brick sourceBrick;
    private Extension extension;
    private ExtensionController extensionController;

    private static final int GIFT_WIDTH = 60;
    private static final int GIFT_HEIGHT = 60;
    private static final int MOVE_STEP = 10;

    public Gift(T probableOwner, CollisionController collisionController, Brick sourceBrick, Extension extension, ExtensionController extensionController, ImageIcon imageIcon, Container parent) {
        super(imageIcon,
                parent,
                GIFT_WIDTH,
                GIFT_HEIGHT,
                sourceBrick.getAbsoluteX() + sourceBrick.getWidth() / 2,
                sourceBrick.getAbsoluteY() + sourceBrick.getHeight());

        this.probableOwner = probableOwner;
        this.collisionController = collisionController;
        this.sourceBrick = sourceBrick;
        this.extension = extension;
        this.extensionController = extensionController;
    }

    public void moveDown() {
        getIcon().setLocation(getAbsoluteX(), getAbsoluteY() + MOVE_STEP);
    }

    @Override
    public void run() {
        while (this.getIcon().getHeight() < Constants.GAME_FRAME_HEIGHT ) {
        
            moveDown();
            try {
                sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Gift.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (collisionController.giftAndLumberCollision(this)) {
                disappear();
                extensionController.addNewExtension(extension); 
                break;
            }
        }
        
        disappear();
    }
    
    

    public void disappear() {
        getIcon().setVisible(false);
        getParent().remove(getIcon());
        getParent().repaint();
    }

}
