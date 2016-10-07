/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ChucVu;
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
import model.ModelChucVu;
import model.ModelKhuVuc;

/**
 *
 * @author homin
 */
public class ControllerChucVu {

    private ModelChucVu model;

    public ControllerChucVu() {
        model = new ModelChucVu();
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("Id chức vụ");
        v.add("Tên chức vụ");
        return v;
    }

    public Vector getRows(ChucVu cv) {
        Vector v = new Vector();
        ArrayList<ChucVu> alItem = model.getChucVu(cv);
        for (ChucVu cv1 : alItem) {
            Vector v1 = new Vector();
            v1.add(cv1.getId_cv());
            v1.add(cv1.getTen_cv());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,ChucVu cv) {

        model.setDataVector(getRows(cv), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.CAT_HEAD_WIDTH_COL_NAME);
    }
    public int add(ChucVu cv) {
        if (isValid(cv, "add") == true) {
            model.add(cv);
            return 1;
        }
        return 0;
    }
     public int delete(ChucVu cv) {
        if (isValid(cv, "delete") == true) {
            model.delete(cv);
            return 1;
        }
        return 0;
    }
     public int edit(ChucVu cv) {
        if (isValid(cv, "edit") == true) {
            model.edit(cv);
            return 1;
        }
        return 0;
    }
     public ChucVu getChucVuById(int id){
     return     model.getChucVuById(id);
     }

    public boolean isValid(ChucVu cv, String nameCN) {
        switch (nameCN) {
            case "add":
                if ("".equals(cv.getTen_cv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên chức vụ");
                    return false;
                }
                break;
            case "delete":
                if (cv.getId_cv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                break;
            case "edit":
                if (cv.getId_cv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để sửa");
                    return false;
                }
                if ("".equals(cv.getTen_cv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên chức vụ");
                    return false;
                }
                break;    

        }
        return true;

    }

  

}
