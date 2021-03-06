/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view1;

import bean.Account;
import bean.NhanVien;
import controller.ControllerAccount;
import controller.ControllerNhanVien;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Hi
 */
public class FrLg extends javax.swing.JFrame {

    private controller.ControllerAccount controller;
    private controller.ControllerNhanVien controllerNhanVien;

    /**
     * Creates new form FrLg
     */
    public FrLg() {
        initComponents();
        controller = new ControllerAccount();
        controllerNhanVien = new ControllerNhanVien();
    }

    public void ktPass() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfUsername = new javax.swing.JTextField();
        pfPass = new javax.swing.JPasswordField();
        lbTB = new javax.swing.JLabel();
        ptPass = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfUsername.setForeground(new java.awt.Color(0, 102, 102));
        tfUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfUsername.setOpaque(false);
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });
        tfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsernameKeyPressed(evt);
            }
        });
        jPanel1.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 230, 30));

        pfPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pfPass.setForeground(new java.awt.Color(0, 102, 102));
        pfPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pfPass.setOpaque(false);
        pfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPassActionPerformed(evt);
            }
        });
        pfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfPassKeyPressed(evt);
            }
        });
        jPanel1.add(pfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, 30));

        lbTB.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbTB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, 30));

        ptPass.setForeground(new java.awt.Color(255, 255, 0));
        ptPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lg123.jpg"))); // NOI18N
        ptPass.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(ptPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

        btLogin.setBorder(null);
        btLogin.setOpaque(false);
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ptPass.requestFocus();
        }
    }//GEN-LAST:event_tfUsernameKeyPressed

    private void pfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPassActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pfPassActionPerformed

    private void pfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPassKeyPressed
        // TODO add your handling code here:
        Account item = null;
        int cmnd = -1;

        try {
            cmnd = Integer.parseInt(tfUsername.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập vào username là số");
            tfUsername.requestFocus();
        }

        String password = new String(pfPass.getPassword());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            item = new Account(0, password, cmnd);
            NhanVien nv = (NhanVien) controllerNhanVien.getNhanViemByMaNV(cmnd);
            if (nv == null) {
                JOptionPane.showMessageDialog(null, "Chứng minh nhân dân sai");
            } else {
                item.setId_cv(nv.getId_cv());

                if (controller.ktAccount(item) > 0) {
                    this.setVisible(false);
                    FrMain frMain = new FrMain(item);
                    frMain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Account hoặc password không hợp lệ");
                }
            }
        }
    }//GEN-LAST:event_pfPassKeyPressed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        Account item = null;
        int cmnd = -1;

        try {
            cmnd = Integer.parseInt(tfUsername.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập vào username là số");
            tfUsername.requestFocus();
        }
        String password = new String(pfPass.getPassword());
         item = new Account(0, password, cmnd);
            NhanVien nv = (NhanVien) controllerNhanVien.getNhanViemByMaNV(cmnd);
            if (nv == null) {
                JOptionPane.showMessageDialog(null, "Chứng minh nhân dân sai");
            } else {
                item.setId_cv(nv.getId_cv());

                if (controller.ktAccount(item) > 0) {
                    this.setVisible(false);
                    FrMain frMain = new FrMain(item);
                    frMain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Account hoặc password không hợp lệ");
                }
            }

    }//GEN-LAST:event_btLoginActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(FrLg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrLg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrLg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrLg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTB;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JLabel ptPass;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
