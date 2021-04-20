package controller;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;
import model.Ball;
import model.bricks.Brick;
import model.Lumber;

public class CollisionController {

    private Arknoid gameManager;
    private Ball ball;
    private Lumber lumber;
    private ArrayList<ArrayList<Brick>> brickWall;

    public CollisionController(Ball ball, Lumber lumber, ArrayList<ArrayList<Brick>> bricks) {
        this.ball = ball;
        this.lumber = lumber;
        this.brickWall = bricks;
    }

    public boolean zone135Collision() {
        Rectangle ballArea = new Rectangle(ball.getAbsoluteX(),
                ball.getAbsoluteY(),
                ball.getIcon().getWidth(),
                ball.getIcon().getHeight());
        Rectangle Zone135 = new Rectangle(lumber.getAbsoluteX(),
                lumber.getAbsoluteY(),
                Lumber.NORMALL_LUMBER_135_ZONE_LENGTH, lumber.getIcon().getHeight());
        boolean ret = Zone135.intersects(ballArea);
        if (ret) {
            ball.setLocation(ball.getAbsoluteX(), lumber.getAbsoluteY() - lumber.getHeight());
        }
        // && Math.abs(ball.getAbsoluteY() - lumber.getAbsoluteY()) < 5
        return ret;
    }

    public boolean zone45Collision() {
        Rectangle ballArea = new Rectangle(ball.getAbsoluteX(),
                ball.getAbsoluteY(),
                ball.getIcon().getWidth(),
                ball.getIcon().getHeight());
        Rectangle Zone45 = new Rectangle(lumber.getAbsoluteX() + Lumber.NORMALL_LUMBER_135_ZONE_LENGTH + Lumber.NORMALL_LUMBER_90_ZONE_LENGTH,
                lumber.getAbsoluteY(),
                Lumber.NORMALL_LUMBER_45_ZONE_LENGTH, lumber.getHeight());

        boolean ret = Zone45.intersects(ballArea);
        if (ret) {
            ball.setLocation(ball.getAbsoluteX(), lumber.getAbsoluteY() - lumber.getHeight());
        }
        return Zone45.intersects(ballArea);
    }

    public void handleCollission135() {
        int reflectionDegree = Math.abs(180 - (ball.getAbsoluteX() - lumber.getAbsoluteX()));
        //System.out.println("Reflection degree : " + reflectionDegree);
        if (ball.canReflect(reflectionDegree)) {
            ball.reflection(reflectionDegree);
        } else {
            ball.reflection(90);
        }

    }

    public void handleCollission45() {
        int reflectionDegree = 180 - (ball.getAbsoluteX() - lumber.getAbsoluteX());
        // System.out.println("*Reflection degree : " + reflectionDegree);
        if (ball.canReflect(reflectionDegree)) {
            ball.reflection(reflectionDegree);
        } else {
            ball.reflection(45);
        }
    }

    public synchronized Brick findBrickCollision() {
        for (ArrayList<Brick> brickRow : brickWall) {
            for (Brick b : brickRow) {
                if (brickCollision(b)) {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean brickCollision(Brick brick) {
        Area areaA = new Area(ball.getIcon().getBounds());
        Area areaB = new Area(brick.getIcon().getBounds());
        return areaA.intersects(areaB.getBounds2D());
    }

    public synchronized void removeBrick(Brick brick) {
        brick.removeBrick();
        int rowNumber = getBrickRow(brick);
        ArrayList<Brick> brickRow = brickWall.get(rowNumber);
        brickRow.remove(brick);
        if(brickRow.isEmpty()){
            brickWall.remove(brickRow);
        }
    }

    public int getBrickRow(Brick brick) {
        for (ArrayList<Brick> brickRow : brickWall) {
            if (brickRow.contains(brick)) {
                return brickWall.indexOf(brickRow);
            }
        }
        return -1;
    }

    public boolean upBoundCollision() {
        return ball.getAbsoluteY() <= 0;
    }

    public boolean leftBoundCollision() {
        return ball.getAbsoluteX() <= 0;
    }

    public boolean downBoundCollision() {
        return ball.getAbsoluteY() >= 770;
    }

    public boolean rightBoundCollision() {
        return ball.getAbsoluteX() >= 970;
    }

    public boolean brickLeftCollision(Brick brick) {
        return ball.getAbsoluteY() < brick.getAbsoluteY() + brick.getHeight() / 2
                && ball.getAbsoluteX() < brick.getAbsoluteX();
    }

    public boolean brickRightCollision(Brick brick) {
        return ball.getAbsoluteY() < brick.getAbsoluteY() + brick.getHeight() / 2
                && ball.getAbsoluteX() + ball.getWidth() > brick.getAbsoluteX();
    }

    public boolean giftAndLumberCollision(Gift gift) {
        Area lumberArea = new Area(lumber.getIcon().getBounds());
        Area giftArea = new Area(gift.getIcon().getBounds());
        return lumberArea.intersects(giftArea.getBounds2D());
    }

}
