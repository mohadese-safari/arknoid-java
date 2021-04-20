package model;

import constants.Constants;
import controller.BallMoveController;
import controller.CollisionController;
import controller.ExtensionController;
import java.awt.Container;
import javax.swing.*;

public class Ball extends GameCharacter implements AbsoluteLocation, Cloneable {

    private Vector vector;
    // private static final int STEP_UNIT = 5;
    private ExtensionController extensionController;
    private BallMoveController moveController;
    private CollisionController collisionController;
    private boolean onFire = false;

    public final static int BALL_INITIAL_X = 300;
    public final static int BALL_INITIAL_Y = 300;
    public final static int BALL_WIDTH = 27;
    public final static int BALL_HEIGHT = 27;
    private final Vector initialVector = new Vector(8, 8);

    public Ball(Container parent, double x, double y) {
        super(Constants.BALL, parent, BALL_WIDTH, BALL_HEIGHT, BALL_INITIAL_X, BALL_INITIAL_Y);
        vector = new Vector(x, y);
    }

    public Ball(Container parent) {
        super(Constants.BALL,
              parent, BALL_WIDTH, BALL_HEIGHT,
              Lumber.LUMBER_INITIAL_X + Lumber.NORMALL_LUMBER_WIDTH / 2,
              Lumber.LUMBER_INITIAL_Y - Lumber.NORMALL_LUMBER_HEIGHT );
        vector = initialVector;
    }

    public void reflection(int surface) {
        double collision = vector.getDegree() + 180;
        collision %= 360;
        double reflect = (2 * surface - collision) % 360;
        //System.out.println("this is the reftelct angle: " + reflect + " vector degree: " + vector.getDegree() + " surface: " + surface);
        vector.setDegree(reflect);
    }

    public boolean canReflect(int surface) {
        double ballDegree = (vector.getDegree() + 180) % 360;
        double reflectionDegree = (2 * surface - ballDegree) % 360;
        return reflectionDegree < 160 && reflectionDegree > 30;
    }

    public void moveOneStep() {
        int y_step = (int) vector.getY();
        int x_step = (int) vector.getX();
        setLocation(xFilter(getIcon().getX() + x_step), yFilter(getIcon().getY() - y_step));
    }

    public void setLocation(int x, int y) {
        getIcon().setLocation(x, y);
    }

    private int xFilter(int x) {
        if (x <= 0) {
            return 0;
        } else if (x >= 970) {
            return 970;
        }
        return x;
    }

    private int yFilter(int y) {
        if (y <= 0) {
            return 0;
        } else if (y >= 770) {
            return 770;
        }
        return y;
    }

    public Vector getVector() {
        return vector;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Ball cloned = new Ball(getParent(), vector.getX(), vector.getY());
        cloned.initLabel(Constants.BALL);
        return cloned;

    }

    public void initLabel(Icon image) {
        setIcon(new JLabel());
        getIcon().setVisible(true);
        getIcon().setSize(27, 27);
        getIcon().setIcon(image);
        getIcon().setLocation(300, 300);
    }

    public void setExtensionController(ExtensionController extensionController) {
        this.extensionController = extensionController;
    }

    public void boostSpeed(double factor) {
        vector.boostSpeed(factor);
    }

    public boolean isOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }

    public ExtensionController getExtensionController() {
        return extensionController;
    }

    public BallMoveController getMoveController() {
        return moveController;
    }

    public void setMoveController(BallMoveController moveController) {
        this.moveController = moveController;
    }

    public CollisionController getCollisionController() {
        return collisionController;
    }

    public void setCollisionController(CollisionController collisionController) {
        this.collisionController = collisionController;
    }

}
