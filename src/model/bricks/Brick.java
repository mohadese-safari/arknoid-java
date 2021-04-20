package model.bricks;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Brick {

    private int life;
    private JLabel icon;
    private Container parent;
    private int hitScore;
    public static final int BRICK_LENGTH = 100;
    public static final int BRICK_HEIGHT = 40;

    public Brick(ImageIcon imageIcon, Container parent, int hitScore) {
        icon = new JLabel();
        icon.setVisible(true);
        icon.setSize(BRICK_LENGTH, BRICK_HEIGHT);
        icon.setIcon(imageIcon);
        this.parent = parent;
        this.hitScore = hitScore;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public JLabel getIcon() {
        return icon;
    }

    public void setIcon(JLabel icon) {
        this.icon = icon;
    }

    public int getWidth() {
        return icon.getWidth();
    }

    public int getHeight() {
        return icon.getHeight();
    }

    public void placeBrick(int x, int y) {
        icon.setLocation(x, y);
    }

    public void addToBoard() {
        parent.add(icon);
    }

    public int getAbsoluteY() {
        return icon.getY();
    }

    public int getAbsoluteX() {
        return icon.getX();
    }

    public Container getParent() {
        return parent;
    }

    public void handleCollisin() {
        decreaseLife();
    }

    public boolean isBroken() {
        return getLife() <= 0;
    }

    public void removeBrick() {
        parent.remove(icon);
        parent.repaint();
    }

    public int getHitScore() {
        return hitScore;
    }

    public abstract void decreaseLife();

    @Override
    public String toString() {
        return getClass().getName() + "&" + getAbsoluteX() + "," + getAbsoluteY() + "&" + life;
    }

}
