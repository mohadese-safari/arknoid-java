package view;

import controller.Arknoid;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Player;
import static view.ScoreBoard.SCORE_FILE_PATH;

public class MainMenu extends javax.swing.JFrame {

    final String WELCOME = "src\\images\\welcome.png";
    final String EDIT_PROFILE = "src\\images\\edit_profile.PNG";
    final String MAIN_MENU = "src\\images\\main_menu_background.png";
    final String PLAY_GAME = "src\\images\\play.PNG";
    final String PLAY_GAME_HIGHLIGHT = "src\\images\\play_highlight.PNG";

    ArrayList<Player> players;
    Player current_player;

    public MainMenu() {
        initComponents();
        saveScrollPane.setVisible(false);
        try {
            players = ScoreBoard.loadScores();
            addPlayer();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);     
    }

    void addPlayer() throws IOException {
        String username = JOptionPane.showInputDialog("Please enter a username");
        if (playerExists(username)) {
            JOptionPane.showMessageDialog(this, null, "Username already taken", JOptionPane.ERROR_MESSAGE);
            addPlayer();
        }

        if (username.equals("") /*&& players.size() == 0*/) {
            addPlayer();
        }

        Player p = new Player(username);
        players.add(p);
        current_player = p;
        player_name.setText(p.getUsername());
        
    }

    public void saveScores() throws IOException {
        FileWriter fileWriter = new FileWriter(SCORE_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Player player : players) {
            bufferedWriter.write(player.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    boolean playerExists(String username) {
        for (Player p : players) {
            if (p.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveScrollPane = new javax.swing.JScrollPane();
        savePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loadSavedGameLabel = new javax.swing.JLabel();
        showScoreTableLabel = new javax.swing.JLabel();
        player_score = new javax.swing.JLabel();
        player_name = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        new_player = new javax.swing.JLabel();
        play_game = new javax.swing.JLabel();
        edit_profile = new javax.swing.JLabel();
        menu_backgroung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space Invaders");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        getContentPane().setLayout(null);

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
        jLabel1.setText("Saved games");
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

        getContentPane().add(saveScrollPane);
        saveScrollPane.setBounds(210, 100, 300, 300);

        loadSavedGameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        loadSavedGameLabel.setForeground(new java.awt.Color(255, 153, 255));
        loadSavedGameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadSavedGameLabel.setText("Load saved game");
        loadSavedGameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadSavedGameLabelMouseClicked(evt);
            }
        });
        getContentPane().add(loadSavedGameLabel);
        loadSavedGameLabel.setBounds(200, 250, 310, 30);

        showScoreTableLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        showScoreTableLabel.setForeground(new java.awt.Color(51, 255, 102));
        showScoreTableLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showScoreTableLabel.setText("Show score table");
        showScoreTableLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showScoreTableLabelMouseClicked(evt);
            }
        });
        getContentPane().add(showScoreTableLabel);
        showScoreTableLabel.setBounds(210, 290, 300, 30);

        player_score.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        player_score.setForeground(new java.awt.Color(153, 255, 153));
        player_score.setText("Your Score : 0");
        player_score.setName(""); // NOI18N
        getContentPane().add(player_score);
        player_score.setBounds(420, 20, 220, 60);

        player_name.setFont(new java.awt.Font("Tekton Pro Cond", 1, 36)); // NOI18N
        player_name.setForeground(new java.awt.Color(153, 255, 0));
        getContentPane().add(player_name);
        player_name.setBounds(250, 30, 370, 50);

        welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcome.png"))); // NOI18N
        getContentPane().add(welcome);
        welcome.setBounds(10, 20, 250, 50);

        new_player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new_player.PNG"))); // NOI18N
        new_player.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new_playerMouseClicked(evt);
            }
        });
        getContentPane().add(new_player);
        new_player.setBounds(210, 160, 320, 30);

        play_game.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.PNG"))); // NOI18N
        play_game.setText("jLabel2");
        play_game.setPreferredSize(new java.awt.Dimension(305, 31));
        play_game.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                play_gameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                play_gameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                play_gameMouseExited(evt);
            }
        });
        getContentPane().add(play_game);
        play_game.setBounds(200, 110, 305, 31);

        edit_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_profile.PNG"))); // NOI18N
        edit_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_profileMouseClicked(evt);
            }
        });
        getContentPane().add(edit_profile);
        edit_profile.setBounds(250, 210, 210, 30);

        menu_backgroung.setBackground(new java.awt.Color(0, 0, 0));
        menu_backgroung.setMaximumSize(new java.awt.Dimension(700, 500));
        menu_backgroung.setMinimumSize(new java.awt.Dimension(700, 500));
        menu_backgroung.setOpaque(true);
        menu_backgroung.setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().add(menu_backgroung);
        menu_backgroung.setBounds(0, 0, 700, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void play_gameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_gameMouseEntered
        play_game.setIcon(new ImageIcon(PLAY_GAME_HIGHLIGHT));
    }//GEN-LAST:event_play_gameMouseEntered

    private void play_gameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_gameMouseExited
        play_game.setIcon(new ImageIcon(PLAY_GAME));
    }//GEN-LAST:event_play_gameMouseExited

    private void play_gameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_gameMouseClicked
        this.setVisible(false);
        this.setEnabled(false);
        Arknoid.initNewGame(current_player, this);
    }//GEN-LAST:event_play_gameMouseClicked

    private void new_playerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_playerMouseClicked
        try {
            addPlayer();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_new_playerMouseClicked

    private void edit_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_profileMouseClicked

        String username = JOptionPane.showInputDialog("Please enter your new username");
        if (username == null) {
            return;
        }
        if (playerExists(username)) {
            JOptionPane.showMessageDialog(this, null, "Username already taken", JOptionPane.ERROR_MESSAGE);
            return;
        }
        current_player.setUsername(username);
        player_name.setText(username);
    }//GEN-LAST:event_edit_profileMouseClicked

    private void showScoreTableLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showScoreTableLabelMouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }//GEN-LAST:event_showScoreTableLabelMouseClicked

    private void loadSavedGameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadSavedGameLabelMouseClicked
        saveScrollPane.setVisible(true);
        preLoadSavedGame();
    }//GEN-LAST:event_loadSavedGameLabelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        saveScrollPane.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked
    public void preLoadSavedGame() {
        File folder = new File("src\\data\\saved games");
        File[] listOfFiles = folder.listFiles();
        JLabel slotLabel;
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
            MainMenu menu = this;
            slotLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setVisible(false);
                    setEnabled(false);
                    Arknoid.initSavedGame(fullRelativePath, menu);
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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });

    }

    void setScore() {
        player_score.setText("Your Score : " + current_player.getScore());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel edit_profile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loadSavedGameLabel;
    private javax.swing.JLabel menu_backgroung;
    private javax.swing.JLabel new_player;
    private javax.swing.JLabel play_game;
    private javax.swing.JLabel player_name;
    public javax.swing.JLabel player_score;
    private javax.swing.JPanel savePanel;
    private javax.swing.JScrollPane saveScrollPane;
    private javax.swing.JLabel showScoreTableLabel;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
