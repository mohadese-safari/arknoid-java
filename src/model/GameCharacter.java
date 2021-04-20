package model;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameCharacter {

    private JLabel icon;
    private Container parent;

    public GameCharacter(ImageIcon imageIcon, Container ancestor, int width, int height, int initial_x, int initial_y) {
        icon = new JLabel();
        icon.setVisible(true);
        icon.setSize(width, height);
        icon.setIcon(imageIcon);
        icon.setLocation(initial_x, initial_y);
        parent = ancestor;
        addToGame();
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

    public void addToBoard() {
        parent.add(icon);
    }

    public int getAbsoluteY() {
        return icon.getY();
    }

    public int getAbsoluteX() {
        return icon.getX();
    }

    public void setAbsoluteY(int y) {
        icon.setLocation(icon.getX(), y);
    }

    public void setAbsoluteX(int x) {
        icon.setLocation(x, icon.getY());
    }

    public Container getParent() {
        return parent;
    }

    public void addToGame() {
        parent.add(icon);
    }
}
