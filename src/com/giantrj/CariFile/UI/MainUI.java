/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.giantrj.CariFile.UI;

import com.giantrj.CariFile.handler.DB.DBHandler;
import com.giantrj.CariFile.handler.File.GetFiles;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author PCMASTERRACE
 */
public class MainUI extends javax.swing.JFrame {
    DBHandler dbh ;
    String DirLama = "";
    File iconFile = new File("./icon.png");
    Image iconImage = new ImageIcon(iconFile.getAbsolutePath()).getImage();
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNamaFile = new javax.swing.JLabel();
        jTextFieldNamaFile = new javax.swing.JTextField();
        jLabelDirektori = new javax.swing.JLabel();
        jTextFieldDirektori = new javax.swing.JTextField();
        jButtonPilihDirektori = new javax.swing.JButton();
        jButtonCari = new javax.swing.JButton();
        jLabelHasilPencarian = new javax.swing.JLabel();
        jScrollPaneHasilCari = new javax.swing.JScrollPane();
        jTextAreaHasilCari = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pencarian File");
        setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        setIconImage(iconImage);

        jLabelNamaFile.setText("Nama File");

        jLabelDirektori.setText("Direktori");

        jTextFieldDirektori.setEditable(false);

        jButtonPilihDirektori.setText("Pilih Direktori");
        jButtonPilihDirektori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPilihDirektoriActionPerformed(evt);
            }
        });

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jLabelHasilPencarian.setText("Hasil Pencarian");

        jTextAreaHasilCari.setColumns(20);
        jTextAreaHasilCari.setRows(5);
        jScrollPaneHasilCari.setViewportView(jTextAreaHasilCari);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneHasilCari)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCari)
                                    .addComponent(jLabelHasilPencarian))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNamaFile)
                            .addComponent(jLabelDirektori))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldNamaFile, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 171, Short.MAX_VALUE))
                            .addComponent(jTextFieldDirektori))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPilihDirektori)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNamaFile)
                    .addComponent(jTextFieldNamaFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirektori)
                    .addComponent(jTextFieldDirektori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPilihDirektori))
                .addGap(18, 18, 18)
                .addComponent(jButtonCari)
                .addGap(18, 18, 18)
                .addComponent(jLabelHasilPencarian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneHasilCari, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPilihDirektoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPilihDirektoriActionPerformed
        // Membuat JFileChooser
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // Menampilkan dialog JFileChooser dan menangani pilihan pengguna
        int option = directoryChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = directoryChooser.getSelectedFile();
            jTextFieldDirektori.setText(selectedDirectory.getAbsolutePath());
        } else {
            System.out.println("No Directory Selected");
        }
    }//GEN-LAST:event_jButtonPilihDirektoriActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        GetFiles gfs = new GetFiles();
        
        if(!DirLama.equals(jTextFieldDirektori.getText()))
        {
            dbh = new DBHandler(gfs.scrapFiles(jTextFieldDirektori.getText()));
            DirLama = jTextFieldDirektori.getText();
        }
        jTextAreaHasilCari.setText("");
        boolean AdaHasil = false;
        
        for (String result : dbh.searchFiles(jTextFieldNamaFile.getText())) {
            jTextAreaHasilCari.append(result + System.lineSeparator());
            AdaHasil = true;
        }
        if (!AdaHasil) {
            jTextAreaHasilCari.append("File tidak ditemukan");
        }
    }//GEN-LAST:event_jButtonCariActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonPilihDirektori;
    private javax.swing.JLabel jLabelDirektori;
    private javax.swing.JLabel jLabelHasilPencarian;
    private javax.swing.JLabel jLabelNamaFile;
    private javax.swing.JScrollPane jScrollPaneHasilCari;
    private javax.swing.JTextArea jTextAreaHasilCari;
    private javax.swing.JTextField jTextFieldDirektori;
    private javax.swing.JTextField jTextFieldNamaFile;
    // End of variables declaration//GEN-END:variables
}
