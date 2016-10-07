/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.inc;

import bean.Account;
import bean.ChucVu;
import bean.NhanVien;
import controller.ControllerChucVu;
import controller.ControllerNhanVien;
import java.awt.Color;
import java.sql.JDBCType;
import javax.swing.JOptionPane;
import view1.PnBottomCQ;
import view1.PnBottomTN;

/**
 *
 * @author Tran Van Son
 */
public class PnBottom extends javax.swing.JPanel {
    private controller.ControllerNhanVien controllerNhanVien;
     private controller.ControllerChucVu controllerChucVu;
    private controller.ControllerAccount controllerAccount;
    /**
     * Creates new form PnTop
     */
    public PnBottom(Account a) {
        initComponents();
        controllerAccount=new controller.ControllerAccount();
        controllerNhanVien=new ControllerNhanVien();
        controllerChucVu=new ControllerChucVu();
        NhanVien nv=controllerNhanVien.getNhanViemByMaNV(a.getId_nv());
        ChucVu cv=controllerChucVu.getChucVuById(a.getId_cv());
        if(cv.getId_cv()==6){
            System.out.println("nằng 6");
            this.add(new PnBottomTN(a));
        }else{
            this.add(new PnBottomCQ(a));
        }
        
      // setForm();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}