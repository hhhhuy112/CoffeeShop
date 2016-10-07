/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Ban;
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
import model.ModelBan;
import model.ModelKhuVuc;

/**
 *
 * @author homin
 */
public class ControllerBan {

    private ModelKhuVuc modelKV;
    private ModelBan  modelBan;

    public ControllerBan() {
        modelKV = new ModelKhuVuc();
        modelBan=new ModelBan();
                
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("Id bàn");
        v.add("Tên khu vực");
        v.add("Trạng thái");
        return v;
    }

    public Vector getRows(Ban ban1) {
        Vector v = new Vector();
        ArrayList<Ban> alBan=modelBan.getList(ban1);
        for (Ban ban : alBan) {
            Vector v1 = new Vector();
            v1.add(ban.getId_ban());
            v1.add(modelKV.getKhuVucById(ban.getId_kv()));
            v1.add(ban.getTrangThai());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,Ban ban) {

        model.setDataVector(getRows(ban), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.CAT_HEAD_WIDTH_COL_NAME);
    }
    public ArrayList<Ban> getListBan(int idKV){
        return modelBan.getListBan(idKV);
    }
    public Ban getBanById(int id){
        return modelBan.getBanById(id);
    }

    public int add(Ban ban) {
        if (isValid(ban, "add") == true) {
            modelBan.add(ban);
            return 1;
        }
        return 0;
    }
     public int delete(Ban ban) {
        if (isValid(ban, "delete") == true) {
            modelBan.delete(ban);
            return 1;
        }
        return 0;
    }
      public int edit(Ban ban) {
        if (isValid(ban, "edit") == true) {
            modelBan.edit(ban);
            return 1;
        }
        return 0;
    }
//     public int delete(KhuVuc kv) {
//        if (isValid(kv, "delete") == true) {
//            model.delete(kv);
//            return 1;
//        }
//        return 0;
//    }
//     public int edit(KhuVuc kv) {
//        if (isValid(kv, "edit") == true) {
//            model.edit(kv);
//            return 1;
//        }
//        return 0;
//    }

    public boolean isValid(Ban ban, String nameCN) {
        switch (nameCN) {
            case "add":
                if (ban.getId_kv()<=0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khu vực");
                    return false;
                }
                   if ("Trạng thái".equals(ban.getTrangThai())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái");
                    return false;
                }
                break;
            case "delete":
                if (ban.getId_ban() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                break;
            case "edit":
                if (ban.getId_ban() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để sửa");
                    return false;
                }
                if (ban.getId_kv()<=0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập chọn tên khu vực");
                    return false;
                }
                if ("Trạng thái".equals(ban.getTrangThai())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập chọn trạng thái");
                    return false;
                }
                break;    

        }
        return true;

    }

  

}
