package view;
import controller.Arknoid;
import model.Player;

public class GameOver extends javax.swing.JFrame {
    Arknoid gameManager;

    public GameOver(Arknoid gameManager) {
        initComponents();
        this.gameManager = gameManager;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play_again = new javax.swing.JLabel();
        main_menu_label = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 300));
        setMaximumSize(new java.awt.Dimension(356, 258));
        setMinimumSize(new java.awt.Dimension(356, 258));
        setPreferredSize(new java.awt.Dimension(365, 285));
        setResizable(false);
        getContentPane().setLayout(null);

        play_again.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        play_again.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PLAY_AGAIN_WHITE.png"))); // NOI18N
        play_again.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                play_againMouseClicked(evt);
            }
        });
        getContentPane().add(play_again);
        play_again.setBounds(160, 130, 30, 30);

        main_menu_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        main_menu_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/main_menu.PNG"))); // NOI18N
        main_menu_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                main_menu_labelMouseClicked(evt);
            }
        });
        getContentPane().add(main_menu_label);
        main_menu_label.setBounds(70, 180, 210, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/game_over_panel.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 356, 258);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void play_againMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_againMouseClicked
        gameManager.replay();
        dispose();
    }//GEN-LAST:event_play_againMouseClicked

    private void main_menu_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_main_menu_labelMouseClicked
        gameManager.exitToMainMenu();
        dispose();
    }//GEN-LAST:event_main_menu_labelMouseClicked

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
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel main_menu_label;
    private javax.swing.JLabel play_again;
    // End of variables declaration//GEN-END:variables
}
