/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ChucVu;
import bean.KhuVuc;
import bean.LuongCoBan;
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
import model.ModelLuongCoBan;

/**
 *
 * @author homin
 */
public class ControllerLuongCoBan {

    private ModelLuongCoBan model;

    public ControllerLuongCoBan() {
        model = new ModelLuongCoBan();
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("level");
        v.add("Lương");
        return v;
    }

    public Vector getRows(LuongCoBan lcb) {
        Vector v = new Vector();
        ArrayList<LuongCoBan> alItem = model.getLuongCoBan(lcb);
        for (LuongCoBan lcb1 : alItem) {
            Vector v1 = new Vector();
            v1.add(lcb1.getLevel_lcb());
          //  v1.add(library.LibraryString.vietnamMoney((long) lcb1.getLuong_lcb()));
            v1.add(lcb1.getLuong_lcb());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,LuongCoBan lcb) {

        model.setDataVector(getRows(lcb), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.CAT_HEAD_WIDTH_COL_NAME);
    }

    public int add(LuongCoBan lcb) {
        if (isValid(lcb, "add") == true) {
             ArrayList<LuongCoBan> alLcb=model.getLuongCoBan(null);
            int sl=alLcb.size()+1;
            model.add(lcb,sl);
            return 1;
        }
        return 0;
    }
     public int delete(LuongCoBan lcb) {
        if (isValid(lcb, "delete") == true) {
            model.delete(lcb);
            return 1;
        }
        return 0;
    }
     public int edit(LuongCoBan lcb) {
        if (isValid(lcb, "edit") == true) {
            model.edit(lcb);
            return 1;
        }
        return 0;
    }

    public boolean isValid(LuongCoBan lcb, String nameCN) {
        switch (nameCN) {
            case "add":
               
                 if (lcb.getLevel_lcb()<0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào lương  ");
                    return false;
                }
                
                break;
            case "delete":
                if (lcb.getLevel_lcb()<=0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                break;
            case "edit":
                 if (lcb.getLevel_lcb()<=0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để sửa");
                    return false;
                }
                if (lcb.getLuong_lcb()<0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào lương lớn hơn hoặc bằng 0");
                    return false;
                }
                
                break;    

        }
        return true;

    }

  

}
