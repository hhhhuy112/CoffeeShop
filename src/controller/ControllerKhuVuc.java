/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.KhuVuc;
import java.awt.Dimension;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import library.LibraryDimension;
import model.ModelKhuVuc;

/**
 *
 * @author homin
 */
public class ControllerKhuVuc {

    private ModelKhuVuc model;

    public ControllerKhuVuc() {
        model = new ModelKhuVuc();
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("Id khu vực");
        v.add("Tên khu vực");
        return v;
    }

    public Vector getRows(KhuVuc kvS) {
        Vector v = new Vector();
        ArrayList<KhuVuc> alItem = model.getKhuVuc(kvS);
        for (KhuVuc kv : alItem) {
            Vector v1 = new Vector();
            v1.add(kv.getId_kv());
            v1.add(kv.getTen_kv());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,KhuVuc kv) {

        model.setDataVector(getRows(kv), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.CAT_HEAD_WIDTH_COL_NAME);
    }

    public int add(KhuVuc kv) {
        if (isValid(kv, "add") == true) {
            model.add(kv);
            return 1;
        }
        return 0;
    }
     public int delete(KhuVuc kv) {
        if (isValid(kv, "delete") == true) {
            model.delete(kv);
            return 1;
        }
        return 0;
    }
     public int edit(KhuVuc kv) {
        if (isValid(kv, "edit") == true) {
            model.edit(kv);
            return 1;
        }
        return 0;
    }
     public ArrayList<KhuVuc> getListKhuVuc(){
         return model.getListKhuVuc();
     }

    public boolean isValid(KhuVuc kv, String nameCN) {
        switch (nameCN) {
            case "add":
                if ("".equals(kv.getTen_kv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên khu vực");
                    return false;
                }
                break;
            case "delete":
                if (kv.getId_kv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                break;
            case "edit":
                if (kv.getId_kv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                if ("".equals(kv.getTen_kv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên khu vực");
                    return false;
                }
                break;    

        }
        return true;

    }

  

}
