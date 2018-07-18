/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.frame;

import it.drakonkat.gitlabsnippetplugin.config.PropertiesManager;
import it.drakonkat.gitlabsnippetplugin.client.GitlabClient;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabVisibility;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mmazzocchetti
 */
public class DefaultPanel extends javax.swing.JPanel {

        private JFrame frame;
        private GitlabClient gitlabClient;

        /**
         * Creates new form DefaultPanel
         *
         * @param frame
         */
        public DefaultPanel(JFrame frame) {
                initComponents();
                this.frame = frame;
                gitlabClient = new GitlabClient();
                Properties p;
                try {
                        p = PropertiesManager.getInstance().loadProperties();
                        customUrl.setText(p.getProperty("url"));
                        accessToken.setText(p.getProperty("token"));
                } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
                caricaListaSnippet();
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                accessToken = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                customUrl = new javax.swing.JTextField();
                list1 = new java.awt.List();
                caricaSnippet = new java.awt.Button();
                salvaConfigurazione = new java.awt.Button();
                button1 = new java.awt.Button();
                button2 = new java.awt.Button();

                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("AccessToken");

                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("URL");

                list1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                list1ActionPerformed(evt);
                        }
                });

                caricaSnippet.setLabel("Carica snippet");
                caricaSnippet.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                caricaSnippetActionPerformed(evt);
                        }
                });

                salvaConfigurazione.setLabel("Salva Configurazione");
                salvaConfigurazione.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                salvaConfigurazioneActionPerformed(evt);
                        }
                });

                button1.setLabel("Crea snippet");
                button1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                button1ActionPerformed(evt);
                        }
                });

                button2.setLabel("Elimina");
                button2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                button2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(caricaSnippet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salvaConfigurazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(customUrl)
                                                        .addComponent(accessToken))))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(accessToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(customUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(salvaConfigurazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(caricaSnippet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                );
        }// </editor-fold>//GEN-END:initComponents

        private void caricaSnippetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricaSnippetActionPerformed
                caricaListaSnippet();
        }//GEN-LAST:event_caricaSnippetActionPerformed

        private void caricaListaSnippet() {
                try {
                        List<GitlabModel> snippets = gitlabClient.getSnippets();
                        list1.removeAll();
                        for (GitlabModel snippet : snippets) {
                                list1.add(snippet.getId() + "-" + snippet.getTitle(), new Integer(snippet.getId()));
                        }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void salvaConfigurazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaConfigurazioneActionPerformed
                Properties p;
                try {
                        p = PropertiesManager.getInstance().loadProperties();
                        p.setProperty("url", customUrl.getText());
                        p.setProperty("token", accessToken.getText());
                        PropertiesManager.getInstance().modifyProperties(p);
                } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA01", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_salvaConfigurazioneActionPerformed

        private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
                try {
                        GitlabModel snippet = gitlabClient.getSnippet(list1.getSelectedItem().split("-")[0]);
                        snippet.setContent(gitlabClient.getCode(snippet));
                        loadSnippetPanel(snippet);
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA02", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_list1ActionPerformed

        private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
                GitlabModel snippet = new GitlabModel();
                snippet.setVisibility(GitlabVisibility.PUBLIC);
                loadSnippetPanel(snippet);
        }//GEN-LAST:event_button1ActionPerformed

        private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
                try {
                        gitlabClient.deleteSnippet(list1.getSelectedItem().split("-")[0]);
                        caricaListaSnippet();
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "ErrorBox: JAVA06", JOptionPane.ERROR_MESSAGE);
                }
        }//GEN-LAST:event_button2ActionPerformed
        private void loadSnippetPanel(GitlabModel gitlabModel) {
                SnippetDetailComponent panel = new SnippetDetailComponent(gitlabModel, frame);
                panel.setVisible(true);
                panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                frame.remove(this);
                frame.setContentPane(panel);
                frame.pack();
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField accessToken;
        private java.awt.Button button1;
        private java.awt.Button button2;
        private java.awt.Button caricaSnippet;
        private javax.swing.JTextField customUrl;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private java.awt.List list1;
        private java.awt.Button salvaConfigurazione;
        // End of variables declaration//GEN-END:variables
}
