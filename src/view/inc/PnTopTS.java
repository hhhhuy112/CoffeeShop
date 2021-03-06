/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inc;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import view1.PnTSBan;
import view1.PnTSKhuVuc;
import view1.PnTSLoaiThucUong;
import view1.PnTSThongTinQuan;

/**
 *
 * @author Tran Van Son
 */

public class PnTopTS extends javax.swing.JPanel {
    private JButton btRecently=null;
    private PnCenter pnCenter;

    public PnTopTS(PnCenter pn,JButton bt) {
        initComponents();
        this.pnCenter = pn;
        this.btRecently=bt;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btTSThongTinQuan = new javax.swing.JButton();
        btTSKhuVuc = new javax.swing.JButton();
        btTSBan = new javax.swing.JButton();
        btTSLoaiThucUong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbTop = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        btTSThongTinQuan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btTSThongTinQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-icon.gif"))); // NOI18N
        btTSThongTinQuan.setText("<html>Quản lý <br />thông tin quán</html>");
        btTSThongTinQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTSThongTinQuanActionPerformed(evt);
            }
        });
        jPanel1.add(btTSThongTinQuan);

        btTSKhuVuc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btTSKhuVuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-icon.gif"))); // NOI18N
        btTSKhuVuc.setText("<html>Quản lý <br />khu vực</html>");
        btTSKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTSKhuVucActionPerformed(evt);
            }
        });
        jPanel1.add(btTSKhuVuc);

        btTSBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btTSBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-icon.gif"))); // NOI18N
        btTSBan.setText("<html>Quản lý <br />bàn</html>");
        btTSBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTSBanActionPerformed(evt);
            }
        });
        jPanel1.add(btTSBan);

        btTSLoaiThucUong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btTSLoaiThucUong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-icon.gif"))); // NOI18N
        btTSLoaiThucUong.setText("<html>Quản lý <br />loại thức uống</html>");
        btTSLoaiThucUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTSLoaiThucUongActionPerformed(evt);
            }
        });
        jPanel1.add(btTSLoaiThucUong);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        lbTop.setText("Quản lý tài sản ");
        jPanel2.add(lbTop);

        add(jPanel2, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btTSKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTSKhuVucActionPerformed
        // TODO add your handling code here:
        addPanel(new PnTSKhuVuc(), btTSKhuVuc);
    }//GEN-LAST:event_btTSKhuVucActionPerformed

    private void btTSThongTinQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTSThongTinQuanActionPerformed
        // TODO add your handling code here:
        addPanel(new PnTSThongTinQuan(), btTSThongTinQuan);
    }//GEN-LAST:event_btTSThongTinQuanActionPerformed

    private void btTSLoaiThucUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTSLoaiThucUongActionPerformed
        // TODO add your handling code here:
         addPanel(new PnTSLoaiThucUong(), btTSLoaiThucUong);
    }//GEN-LAST:event_btTSLoaiThucUongActionPerformed

    private void btTSBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTSBanActionPerformed
        // TODO add your handling code here:
         addPanel(new PnTSBan(), btTSBan);
    }//GEN-LAST:event_btTSBanActionPerformed

    public void addPanel(JPanel pn ,JButton bt) {
        pnCenter.removeAll();
        pnCenter.add(pn, BorderLayout.CENTER);
       
        if(btRecently!=null && btRecently!=bt){
            btRecently.setForeground(Color.BLACK);
            btRecently=bt;
             btRecently.setForeground(Color.RED);
        }else if(btRecently==null){
             btRecently=bt;
             btRecently.setForeground(Color.RED);
        }
        
        pnCenter.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTSBan;
    private javax.swing.JButton btTSKhuVuc;
    private javax.swing.JButton btTSLoaiThucUong;
    private javax.swing.JButton btTSThongTinQuan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTop;
    // End of variables declaration//GEN-END:variables
}
