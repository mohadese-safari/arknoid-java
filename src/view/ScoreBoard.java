package view;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.Player;

public class ScoreBoard extends javax.swing.JFrame {

    ArrayList<Player> players;

    static final String SCORE_FILE_PATH = "src\\data\\scores.txt";

    public ScoreBoard() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            players = loadScores();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collections.sort(players, Collections.reverseOrder());
        players = eliminateExtraRecords();
        showScoreBoard();
    }

    public ArrayList<Player> eliminateExtraRecords() {
        ArrayList<Player> result = new ArrayList();
        for (Player list1Player : players) {
            if (!duplicateRecord(result, list1Player)) {
                result.add(list1Player);
            }
        }
        return result;
    }

    public boolean duplicateRecord(ArrayList<Player> newList, Player player) {
        for (Player p : newList) {
            if (p.equals(player)) {
                return true;
            }
        }
        return false;
    }

    public void showScoreBoard() {
        JLabel row;
        Player player = null;
        for (int i = 0; i < 2 * players.size(); i++) {
            row = new JLabel();
            if (i % 2 == 0) {
                player = players.get(i / 2);
                row.setForeground(Color.WHITE);
                row.setText(player.getUsername());
                row.setFont(new java.awt.Font("Urdu Typesetting", 1, 30));
            } else {
                row.setForeground(Color.CYAN);
                row.setText(player.getScore() + "");
                row.setFont(new java.awt.Font("Urdu Typesetting", 1, 20));
            }
            row.setBackground(Color.BLACK);
            row.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            row.setMaximumSize(new java.awt.Dimension(340, 50));
            row.setMinimumSize(new java.awt.Dimension(340, 50));
            row.setOpaque(true);
            row.setPreferredSize(new java.awt.Dimension(340, 50));
            scorePanel.add(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreScrollPane = new javax.swing.JScrollPane();
        scorePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(null);

        scoreScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        scoreScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scorePanel.setBackground(new java.awt.Color(0, 0, 0));
        scorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Scores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Traditional Arabic", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        scorePanel.setMaximumSize(new java.awt.Dimension(340, 250));
        scorePanel.setMinimumSize(new java.awt.Dimension(340, 250));
        scorePanel.setLayout(new javax.swing.BoxLayout(scorePanel, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Urdu Typesetting", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(340, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(340, 50));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(340, 50));
        scorePanel.add(jLabel1);

        scoreScrollPane.setViewportView(scorePanel);

        getContentPane().add(scoreScrollPane);
        scoreScrollPane.setBounds(20, 20, 360, 390);

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setMaximumSize(new java.awt.Dimension(400, 500));
        background.setMinimumSize(new java.awt.Dimension(400, 500));
        background.setOpaque(true);
        background.setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().add(background);
        background.setBounds(0, 0, 410, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void appendPlayerScore(Player player) throws IOException {
        File file = new File(SCORE_FILE_PATH);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        if (file.length() != 0) {
            bufferedWriter.newLine();
        }
        bufferedWriter.append(player.toString());
        bufferedWriter.close();
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

    public static ArrayList<Player> loadScores() throws FileNotFoundException, IOException {
        FileReader filReader = new FileReader(SCORE_FILE_PATH);
        BufferedReader bufferedWriter = new BufferedReader(filReader);
        ArrayList<Player> result = new ArrayList<>();
        String[] info;
        String line = bufferedWriter.readLine();

        if (line == null) {
            return new ArrayList<>();
        }
        while (line != null) {
            info = line.split(":");
            result.add(new Player(info[0], Integer.valueOf(info[1])));
            line = bufferedWriter.readLine();
        }

        return result;
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
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JScrollPane scoreScrollPane;
    // End of variables declaration//GEN-END:variables
}
