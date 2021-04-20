package controller;

import constants.*;
import constants.State;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import model.bricks.*;
import model.bricks.GlassyBrick;
import model.bricks.WoodenBrick;
import view.Board;
import view.GameOver;
import view.MainMenu;
import view.ScoreBoard;

public class Arknoid {

    public static MainMenu getMainMenu() {
        return mainMenu;
    }

    private ArrayList<Ball> balls;
    private Lumber lumber;
    private ArrayList<ArrayList<Brick>> bricksWall;
    private Container gamePanel;
    private Board gameBoard;
    private CollisionController collisionController;
    private int score;
    private Player currentPlayer;
    private int gameScore;
    private StateChecker stateCheker;
    private boolean isPaused = false;
    private static MainMenu mainMenu;
    private String loadFilePath ;
    
    public final static int WALL_WIDTH = 10;
    public final static int WALL_HEIGHT = 5;

    private State gameState;
    private GameInitMode initMode; 

    public Arknoid(Lumber lumber, Container gamePanel, Board gameBoard) {
        this.lumber = lumber;
        this.gamePanel = gamePanel;
        this.gameBoard = gameBoard;
        gameBoard.setGameManager(this);
        balls = new ArrayList();
        gameState = State.PLAYING;
    }

    public static void initNewGame(Player player, MainMenu MainMenu) {
        mainMenu = MainMenu;
        Board board = new Board();
        Lumber lumber = new Lumber(board.getGamePanel(), board);
        Ball balll = new Ball(board.getGamePanel(), +3, 10);
        // Ball ball2 = new Ball(board.getGamePanel(), -5, 10);

        Arknoid arknoid = new Arknoid(lumber, board.getGamePanel(), board);
        arknoid.initBricks(WALL_HEIGHT, WALL_WIDTH);
        arknoid.setCurrentPlayer(player);
        arknoid.setInitMode(GameInitMode.NEW);
        //Extension controllers
        ExtensionController lumberExtensionController = new ExtensionController(lumber, board.getGamePanel(), arknoid);
        lumber.setExtensionController(lumberExtensionController);

        arknoid.addNewBall(balll);
        BrickDroper brickDroper = new BrickDroper(arknoid.bricksWall, board.getGamePanel(), arknoid);

        StateChecker stateChecker = new StateChecker(arknoid);
        Thread boardRunner = new Thread(new Runnable() {
            public void run() {
                board.setVisible(true);
            }
        });
        boardRunner.start();
        brickDroper.start();
        stateChecker.start();
        arknoid.throwAllBalls();
    }
    
    public static void initSavedGame(String filePath,MainMenu MainMenu) {
         mainMenu = MainMenu;
        Board board = new Board();
        Lumber lumber = new Lumber(board.getGamePanel(), board);
        Ball balll = new Ball(board.getGamePanel(), 3, 10);
        Arknoid arknoid = new Arknoid(lumber, board.getGamePanel(), board);

        try {
            arknoid.loadBrickWall(filePath);
        } catch (IOException ex) {
            Logger.getLogger(Arknoid.class.getName()).log(Level.SEVERE, null, ex);
        }
        arknoid.setInitMode(GameInitMode.LOAD);
        arknoid.loadFilePath = filePath;

        ExtensionController lumberExtensionController = new ExtensionController(lumber, board.getGamePanel(), arknoid);
        lumber.setExtensionController(lumberExtensionController);
        arknoid.addNewBall(balll);

        BrickDroper brickDroper = new BrickDroper(arknoid.bricksWall, board.getGamePanel(), arknoid);
        StateChecker stateChecker = new StateChecker(arknoid);

        Thread boardRunner = new Thread(new Runnable() {
            public void run() {
                board.setVisible(true);
            }
        });
        boardRunner.start();
        brickDroper.start();
        stateChecker.start();
        arknoid.throwAllBalls();

    }

    public void saveGame(String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(currentPlayer.getUsername());
            bufferedWriter.newLine();
            bufferedWriter.write(lumber.getScore() + "");
            bufferedWriter.newLine();
            bufferedWriter.write(lumber.getLife() + "");
            bufferedWriter.newLine();
            for (ArrayList<Brick> brickRow : bricksWall) {
                for (Brick brick : brickRow) {
                    bufferedWriter.write(brick.toString() + "@");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(Arknoid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public void addCollisionController(Ball ball) {
        CollisionController collisionController = new CollisionController(ball, lumber, bricksWall);
        ball.setCollisionController(collisionController);
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public Lumber getLumber() {
        return lumber;
    }

    public void initBricks(int rows, int cols) {
        bricksWall = new ArrayList();
        ArrayList<Brick> bricksRow;
        Brick brick;
        for (int r = 0; r < rows; r++) {
            bricksRow = new ArrayList();
            for (int c = 0; c < cols; c++) {
                brick = getRandomBrick(gamePanel);
                brick.placeBrick(Constants.BRICK_STANDARD_WIDTH * c, Constants.BRICK_STANDARD_HEIGHT * r);
                bricksRow.add(brick);
                brick.addToBoard();
            }
            bricksWall.add(bricksRow);
        }
    }

    public static Brick getRandomBrick(Container parent) {
        int random = (int) (Math.random() * 5);
        switch (random) {
            case 0:
                return new GlassyBrick(parent);
            case 1:
                return new WoodenBrick(parent);
            case 2:
                return new InvesibleBrick(parent);
            case 3:
                return new GiftedBrick(parent);
            case 4:
                return new BlinkingBrick(parent);
        }

        return null;
    }

    public void addNewBall(Ball ball) {
        balls.add(ball);
        ExtensionController ballExtensionController = new ExtensionController(ball, gamePanel, this);
        ball.setExtensionController(ballExtensionController);
        addCollisionController(ball);
        BallMoveController bc = new BallMoveController(ball, ball.getCollisionController(), this);
    }

    public void giveNewChance() {
        lumber.setLocation(Lumber.LUMBER_INITIAL_X, Lumber.LUMBER_INITIAL_Y);
        Ball newChanceBall = new Ball(gameBoard.getGamePanel());
        addNewBall(newChanceBall);
        throwBall(newChanceBall);
    }

    public void throwAllBalls() {
        for (Ball ball : balls) {
            throwBall(ball);
        }
    }

    public void throwBall(Ball ball) {
        ball.getMoveController().start();
    }

    public ArrayList<ArrayList<Brick>> getBricksWall() {
        return bricksWall;
    }

    public Container getBoard() {
        return gamePanel;
    }

    public CollisionController getCollisionController() {
        return collisionController;
    }

    public void setCollisionController(CollisionController collisionController) {
        this.collisionController = collisionController;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public StateChecker getStateCheker() {
        return stateCheker;
    }

    public void setStateCheker(StateChecker stateCheker) {
        this.stateCheker = stateCheker;
    }

    public void loseBall(Ball ball) {
        balls.remove(ball);
        ball.getParent().remove(ball.getIcon());
        if (lumberLifeDecreaseCondition()) {
            lumberLifeDecrease();
        }
    }

    public void lumberLifeDecrease() {
        lumber.decreaseLife();
        gameBoard.updateLife(lumber.getLife());
        if (gameOverCondition()) {
            setGameState(State.OVER);
        } else {
            giveNewChance();
        }
    }

    public boolean lumberLifeDecreaseCondition() {
        return balls.size() == 0;
    }

    public boolean gameOverCondition() {
        return lumber.getLife() == 0;
    }

    public void gameOver() {
        currentPlayer.setScore(lumber.getScore());
        try {
            ScoreBoard.appendPlayerScore(currentPlayer);
        } catch (IOException ex) {
            Logger.getLogger(Arknoid.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameOver gameOverPanel =  new GameOver(this);
        Thread gameOverRunner = new Thread(new Runnable() {
            public void run() {
                gameOverPanel.setVisible(true);
            }
        });     
        gameOverRunner.start();
        gameBoard.dispose();
    }

    public void exitToMainMenu() {
        stateCheker.stop();
        this.gameState = State.OVER;
        mainMenu.setEnabled(true);
        mainMenu.setVisible(true);
        gameBoard.dispose();
    }

    public void replay() {
        stateCheker.stop();
        this.gameState = State.OVER;
        gameBoard.dispose();
        initNewGame(currentPlayer, mainMenu);
    }

    public boolean isIsPaused() {
        return isPaused;
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public Container getGamePanel() {
        return gamePanel;
    }

    public void pauseGame() {
        // pause movers
        this.setGameState(constants.State.PAUSED);
        // pause keylistener
        this.getLumber().removeAllListeners();
    }

    public void resumeGame() {
        this.setGameState(constants.State.PLAYING);
        this.getLumber().addHealthyLumberKeyListener();
    }

    public void loadBrickWall(String filePath) throws FileNotFoundException, IOException {
        FileReader filReader = new FileReader(filePath);
        BufferedReader bufferedWriter = new BufferedReader(filReader);
        bricksWall = new ArrayList<>();

        String username = bufferedWriter.readLine();
        int score = Integer.valueOf(bufferedWriter.readLine());
        int life = Integer.valueOf(bufferedWriter.readLine());
        lumber.setScore(score);
        lumber.setLife(life);
        gameBoard.updateLife(life);
        gameBoard.updateScore(score);
        currentPlayer = new Player(username);

        String rowStr = bufferedWriter.readLine();
        ArrayList<Brick> row = new ArrayList<>();

        while (rowStr != null) {
            row = generateBrickRow(rowStr);
            addRowToBoard(row);
            bricksWall.add(row);
            rowStr = bufferedWriter.readLine();
        }

    }

    public void addRowToBoard(ArrayList<Brick> brickRow) {
        bricksWall.add(brickRow);
        for (Brick brick : brickRow) {
            brick.addToBoard();
        }
    }

    public ArrayList<Brick> generateBrickRow(String row) {
        String[] bricksArray = row.split("@");
        ArrayList<Brick> brickRow = new ArrayList();
        Brick brickCell;
        String[] brickInfo;
        String[] location;
        int x, y;

        for (String brickStr : bricksArray) {
            brickInfo = brickStr.split("&");
            location = brickInfo[1].split(",");
            x = Integer.valueOf(location[0]);
            y = Integer.valueOf(location[1]);
            brickCell = generateSingleBrick(brickInfo[0], gamePanel, x, y, Integer.valueOf(brickInfo[2]));
            brickRow.add(brickCell);
        }
        return brickRow;
    }

// for generating a single brick based on its type and life and location
    public Brick generateSingleBrick(String className, Container parent, int x, int y, int life) {
        Brick brick = null;
        switch (className.trim()) {
            case "model.bricks.GlassyBrick":
                brick = new GlassyBrick(parent);
                break;

            case "model.bricks.WoodenBrick":
                brick = new WoodenBrick(parent);
                break;

            case "model.bricks.InvesibleBrick":
                brick = new InvesibleBrick(parent);
                break;

            case "model.bricks.GiftedBrick":
                brick = new GiftedBrick(parent);
                break;

            case "model.bricks.BlinkingBrick":
                brick = new BlinkingBrick(parent);
                break;

            default:
                brick = new WoodenBrick(parent);
                break;

        }
        brick.placeBrick(x, y);
        brick.setLife(life);
        return brick;
    }

    public GameInitMode getInitMode() {
        return initMode;
    }

    public void setInitMode(GameInitMode initMode) {
        this.initMode = initMode;
    }

    public String getLoadFilePath() {
        return loadFilePath;
    }

    public void setLoadFilePath(String loadFilePath) {
        this.loadFilePath = loadFilePath;
    }
 
}
