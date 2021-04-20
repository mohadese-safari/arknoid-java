package model.extensions;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Ball;

public class BallExtension extends Extension {

    private static final int DEFAULT_APPLYING_DURATION = 10;
    Ball taker;

    public BallExtension(Ball taker, Icon imageIcon) {
        super(taker,imageIcon);
        this.taker = taker;
    }

    public static int getDEFAULT_APPLYING_DURATION() {
        return DEFAULT_APPLYING_DURATION;
    }

    @Override
    public void run() {
        try {
            synchronized(this){
            wait(DEFAULT_APPLYING_DURATION);
            }
        } catch (InterruptedException ex) {
            // Logger.getLogger(Extension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
