package model.extensions;

import javax.swing.Icon;
import model.GameCharacter;

public class Extension<T extends GameCharacter> extends Thread {

    protected static final int DEFAULT_APPLYING_DURATION = 10;
    private Icon icon;
    private T taker;

    public Extension(T taker, Icon imageIcon) {
        icon = imageIcon;
        this.taker = taker ;
    }

    public static int getDEFAULT_APPLYING_DURATION() {
        return DEFAULT_APPLYING_DURATION;
    }

    @Override
    public void run() {
        //taker.
        try {
            wait(DEFAULT_APPLYING_DURATION);
        } catch (InterruptedException ex) {
            // Logger.getLogger(Extension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Extension) super.clone();
    }

    public T getTaker() {
        return taker;
    }

    public void setTaker(T taker) {
        this.taker = taker;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
}
