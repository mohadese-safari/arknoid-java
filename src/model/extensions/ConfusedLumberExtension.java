package model.extensions;

import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Lumber;
import view.Board;

public class ConfusedLumberExtension extends LumberExtension {

    private static final int DEFAULT_APPLYING_DURATION = 4000;

    public ConfusedLumberExtension(Lumber taker) {
        super(taker, taker.getIcon().getIcon());
    }

    @Override
    public void run() {
        removePreviousListenners();
        addConfusedListenner();
        try {
            sleep(DEFAULT_APPLYING_DURATION);
        } catch (InterruptedException ex) {
        }
        removePreviousListenners();
        restoreHealthyListenner();
    }

    public synchronized void removePreviousListenners() {
        Lumber lumber = (Lumber) getTaker();
        Board board = lumber.getBoard();
        KeyListener[] keyListeners = board.getKeyListeners();
        for (KeyListener kl : keyListeners) {
            board.removeKeyListener(kl);
        }
    }

    public synchronized void addConfusedListenner() {
        Lumber taker = (Lumber) getTaker();
        taker.addConfusedLumberKeyListener();
    }

    public synchronized void restoreHealthyListenner() {
        Lumber taker = (Lumber) getTaker();
        taker.addHealthyLumberKeyListener();
    }
}
