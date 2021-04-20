package view;

import constants.Constants;
import controller.Arknoid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.GameInitMode;

public class Board extends javax.swing.JFrame {
    
    private Arknoid gameManager;
    
    public Board() {
        initComponents();
        saveScrollPane.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public JPanel getGamePanel() {
        return gamePanel;
    }
    
    public void setGameManager(Arknoid gameManager) {
        this.gameManager = gameManager;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        saveScrollPane = new javax.swing.JScrollPane();
        savePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBarPanel = new javax.swing.JPanel();
        loadLabel = new javax.swing.JLabel();
        backToMenuLabel = new javax.swing.JLabel();
        playAgainLabel = new javax.swing.JLabel();
        pauseLabel = new javax.swing.JLabel();
        saveLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        scoreDisplayLabel = new javax.swing.JLabel();
        lifeLabel = new javax.swing.JLabel();
        lifeDisplayLabel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 750));
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setPreferredSize(new java.awt.Dimension(1000, 750));
        setSize(new Dimension(Constants.GAME_FRAME_WIDTH,Constants.GAME_FRAME_HEIGHT));
        getContentPane().setLayout(null);

        gamePanel.setMaximumSize(new java.awt.Dimension(1000, 770));
        gamePanel.setMinimumSize(new java.awt.Dimension(1000, 770));
        gamePanel.setOpaque(false);
        gamePanel.setPreferredSize(new java.awt.Dimension(1000, 770));
        gamePanel.setLayout(null);

        saveScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        saveScrollPane.setMaximumSize(new java.awt.Dimension(300, 300));
        saveScrollPane.setMinimumSize(new java.awt.Dimension(300, 300));
        saveScrollPane.setPreferredSize(new java.awt.Dimension(300, 300));

        savePanel.setBackground(new java.awt.Color(0, 0, 0));
        savePanel.setMaximumSize(new java.awt.Dimension(300, 300));
        savePanel.setMinimumSize(new java.awt.Dimension(300, 300));
        savePanel.setPreferredSize(new java.awt.Dimension(300, 300));
        savePanel.setLayout(new javax.swing.BoxLayout(savePanel, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Saved games(Click here to cancel)");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(300, 22));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 22));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        savePanel.add(jLabel1);

        saveScrollPane.setViewportView(savePanel);

        gamePanel.add(saveScrollPane);
        saveScrollPane.setBounds(40, 20, 300, 300);

        getContentPane().add(gamePanel);
        gamePanel.setBounds(0, 0, 1000, 630);

        menuBarPanel.setBackground(new java.awt.Color(51, 51, 255));
        menuBarPanel.setMaximumSize(new java.awt.Dimension(1000, 50));
        menuBarPanel.setMinimumSize(new java.awt.Dimension(1000, 50));
        menuBarPanel.setPreferredSize(new java.awt.Dimension(1000, 100));
        menuBarPanel.setLayout(new java.awt.GridLayout());

        loadLabel.setBackground(new java.awt.Color(51, 51, 255));
        loadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOAD_GAME.png"))); // NOI18N
        loadLabel.setOpaque(true);
        loadLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadLabelMouseClicked(evt);
            }
        });
        menuBarPanel.add(loadLabel);

        backToMenuLabel.setBackground(new java.awt.Color(51, 51, 255));
        backToMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backToMenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BACK_TO_MENU.png"))); // NOI18N
        backToMenuLabel.setOpaque(true);
        backToMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToMenuLabelMouseClicked(evt);
            }
        });
        menuBarPanel.add(backToMenuLabel);

        playAgainLabel.setBackground(new java.awt.Color(51, 51, 255));
        playAgainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playAgainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PLAY_AGAIN.png"))); // NOI18N
        playAgainLabel.setOpaque(true);
        playAgainLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playAgainLabelMouseClicked(evt);
            }
        });
        menuBarPanel.add(playAgainLabel);

        pauseLabel.setBackground(new java.awt.Color(51, 51, 255));
        pauseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PAUSE.png"))); // NOI18N
        pauseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseLabelMouseClicked(evt);
            }
        });
        menuBarPanel.add(pauseLabel);

        saveLabel.setBackground(new java.awt.Color(51, 51, 255));
        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SAVE_GAME.png"))); // NOI18N
        saveLabel.setOpaque(true);
        saveLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveLabelMouseEntered(evt);
            }
        });
        menuBarPanel.add(saveLabel);

        scoreLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scoreLabel.setText(" Score : ");
        menuBarPanel.add(scoreLabel);

        scoreDisplayLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scoreDisplayLabel.setText("0");
        menuBarPanel.add(scoreDisplayLabel);

        lifeLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lifeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lifeLabel.setText("Life : ");
        menuBarPanel.add(lifeLabel);

        lifeDisplayLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lifeDisplayLabel.setText("3");
        menuBarPanel.add(lifeDisplayLabel);

        getContentPane().add(menuBarPanel);
        menuBarPanel.setBounds(0, 630, 1000, 100);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BACKGROUND2.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1000, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseLabelMouseClicked
        if (gameManager.getGameState() == constants.State.PLAYING) {
            gameManager.pauseGame();
            pauseLabel.setIcon(Constants.RESUME_GAME);
        } else {
            gameManager.resumeGame();
            pauseLabel.setIcon(Constants.PAUSE_GAME);
        }
    }//GEN-LAST:event_pauseLabelMouseClicked

    private void loadLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadLabelMouseClicked
        gameManager.pauseGame();
        saveScrollPane.setVisible(true);
        loadSavedGame();      
    }//GEN-LAST:event_loadLabelMouseClicked

    public void loadSavedGame(){
        File folder = new File("src\\data\\saved games");
        File[] listOfFiles = folder.listFiles();
        JLabel slotLabel;
        final Board board = this;
        for (int i = 0; i < listOfFiles.length; i++) {
            slotLabel = new JLabel();
            slotLabel.setBackground(Color.LIGHT_GRAY);
            slotLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            slotLabel.setMaximumSize(new java.awt.Dimension(340, 50));
            slotLabel.setMinimumSize(new java.awt.Dimension(340, 50));
            slotLabel.setOpaque(true);
            slotLabel.setPreferredSize(new java.awt.Dimension(340, 50));
            slotLabel.setText(listOfFiles[i].getName());
            String fullRelativePath = "src\\data\\saved games\\" + listOfFiles[i].getName();
            slotLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    board.dispose();
                    Arknoid.initSavedGame(fullRelativePath,gameManager.getMainMenu());
                }
            }
            );
            savePanel.add(slotLabel);
            slotLabel.setVisible(true);
            savePanel.repaint();
            saveScrollPane.repaint();
            this.repaint();
            System.out.println("File " + listOfFiles[i].getName());
    }
    }
    
    private void saveLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLabelMouseClicked
        gameManager.pauseGame();
        if (gameManager.getInitMode() == GameInitMode.LOAD) {
            int choise = JOptionPane.showConfirmDialog(null, "Overwrite " + gameManager.getLoadFilePath() + " ?", "Save game", JOptionPane.YES_NO_OPTION);
            if (choise == JOptionPane.YES_OPTION) {
                gameManager.saveGame(gameManager.getLoadFilePath());
                gameManager.resumeGame();
                return;
            }
        }
        String fileName = JOptionPane.showInputDialog(null, "Save file as : ", "Save game", JOptionPane.OK_CANCEL_OPTION);
        if (fileName != null) {
            gameManager.saveGame(Constants.SAVE_PATH + fileName + ".txt");
        }
        gameManager.resumeGame();
    }//GEN-LAST:event_saveLabelMouseClicked

    private void saveLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_saveLabelMouseEntered

    private void playAgainLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playAgainLabelMouseClicked
        gameManager.replay();
    }//GEN-LAST:event_playAgainLabelMouseClicked

    private void backToMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToMenuLabelMouseClicked
        gameManager.exitToMainMenu();
    }//GEN-LAST:event_backToMenuLabelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        saveScrollPane.setVisible(false);
        gameManager.resumeGame();
    }//GEN-LAST:event_jLabel1MouseClicked
    
    public void updateScore(int score) {
        scoreDisplayLabel.setText(score + "");
    }
    
    public void updateLife(int life) {
        lifeDisplayLabel.setText(life + "");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Board().setVisible(true);
//            }
//        });
    }

    javax.swing.JScrollPane getSaveScrollPane(){
        return saveScrollPane ;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backToMenuLabel;
    private javax.swing.JLabel background;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lifeDisplayLabel;
    private javax.swing.JLabel lifeLabel;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JPanel menuBarPanel;
    private javax.swing.JLabel pauseLabel;
    private javax.swing.JLabel playAgainLabel;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JPanel savePanel;
    private javax.swing.JScrollPane saveScrollPane;
    private javax.swing.JLabel scoreDisplayLabel;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
