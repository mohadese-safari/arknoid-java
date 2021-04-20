package controller;

import java.awt.Container;
import java.util.ArrayList;
import model.Ball;
import model.GameCharacter;
import model.extensions.Extension;

public class ExtensionController<T extends GameCharacter> implements Cloneable {

    private Arknoid gameManager;
    private Container board;
    T owner;
    ArrayList<Extension> extensions;

    public ExtensionController(T owner, Container board,Arknoid gameManager) {
        this.owner = owner;
        extensions = new ArrayList();
        this.board = board;
        this.gameManager = gameManager;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (ExtensionController<T>) super.clone();
    }

    public void addNewExtension(Extension extension){
        extensions.add(extension);
        extension.run();
    }

}
