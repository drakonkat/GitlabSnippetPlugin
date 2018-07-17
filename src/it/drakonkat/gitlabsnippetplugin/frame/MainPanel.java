/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.frame;

import it.drakonkat.gitlabsnipperplugin.config.PropertiesManager;
import it.drakonkat.gitlabsnippetplugin.client.GitlabClient;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author mmazzocchetti
 */
public class MainPanel extends javax.swing.JFrame {

        /**
         * Creates new form MainPanel
         */
        public MainPanel() {
                initComponents();
                Properties p;
                try {
                        p = PropertiesManager.getInstance().loadProperties();
                        customUrl.setText(p.getProperty("url"));
                        accessToken.setText(p.getProperty("token"));
                } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jTextField1 = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                accessToken = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                customUrl = new javax.swing.JTextField();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                list1 = new java.awt.List();

                jTextField1.setText("jTextField1");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("AccessToken:");

                accessToken.setText("AccessToken");
                accessToken.setToolTipText("Generate access token from gitlab profile");
                accessToken.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                accessTokenActionPerformed(evt);
                        }
                });

                jLabel2.setText("URL");

                customUrl.setText("Url");
                customUrl.setToolTipText("Inserire url se diverso dal default");
                customUrl.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customUrlActionPerformed(evt);
                        }
                });

                jButton1.setText("Salva proprietà");
                jButton1.setToolTipText("");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("Carica");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                list1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                list1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(accessToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(customUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(accessToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(customUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void accessTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessTokenActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_accessTokenActionPerformed

        private void customUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customUrlActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_customUrlActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                try {
                        Properties p = PropertiesManager.getInstance().loadProperties();
                        p.setProperty("url", customUrl.getText());
                        p.setProperty("token", accessToken.getText());
                        PropertiesManager.getInstance().modifyProperties(p);
                } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, "Errore", ex);
                }
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                GitlabClient gitlabClient = new GitlabClient();
                try {
                        List<GitlabModel> snippets = gitlabClient.getSnippets();
                        for (GitlabModel snippet : snippets) {
                                list1.add(snippet.getTitle(), new Integer(snippet.getId()));
                        }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_jButton2ActionPerformed

        private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
                GitlabClient gitlabClient = new GitlabClient();
                try {
                        if (list1.getSelectedItem() != null) {
                                List<GitlabModel> snippets = gitlabClient.getSnippets();
                                for (GitlabModel snippet : snippets) {
                                        if (list1.getSelectedItem().equals(snippet.getTitle())) {
                                                SnippetDetailComponent panel = new SnippetDetailComponent(snippet);
                                                panel.setVisible(true);
                                                panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                                                this.setContentPane(panel);
                                                this.pack();
                                                this.setLocationByPlatform(true);
                                        }
                                }
                        }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_list1ActionPerformed

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
                        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new MainPanel().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField accessToken;
        private javax.swing.JTextField customUrl;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JTextField jTextField1;
        private java.awt.List list1;
        // End of variables declaration//GEN-END:variables
}
