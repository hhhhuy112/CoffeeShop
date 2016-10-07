/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.ThuNhap;
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
import model.ModelLoaiThucUong;

/**
 *
 * @author homin
 */
public class ControllerLoaiThucUong {

    private ModelLoaiThucUong model;

    public ControllerLoaiThucUong() {
        model = new ModelLoaiThucUong();
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("Id");
        v.add("Tên ");
        v.add("Giá");
        v.add("Số lượng");
        v.add("Đơn vị");
        v.add("Hình ảnh");
        v.add("Trang thai");
        return v;
    }

    public Vector getCols1() {
        Vector v = new Vector();
        v.add("Id");
        v.add("Tên ");
        v.add("Giá");
        v.add("Số lượng");
        v.add("Đơn vị");
        return v;
    }
    public Vector getCols2() {
        Vector v = new Vector();
        v.add("Id");
        v.add("Tên ");
        v.add("Giá");
        v.add("Số lượng");
        v.add("Đơn vị");
          v.add("Thành tiền");
        return v;
    }

    public Vector getRows(LoaiThucUong ltu, boolean ctt) {
        Vector v = new Vector();
        ArrayList<LoaiThucUong> alItem = model.getLoaiThucUong(ltu, ctt);
        for (LoaiThucUong ltu1 : alItem) {
            Vector v1 = new Vector();
            v1.add(ltu1.getId_ltu());
            v1.add(ltu1.getTen_ltu());
            v1.add(ltu1.getGia_ltu());
            v1.add(ltu1.getSoLuong_ltu());
            v1.add(ltu1.getDonVi_ltu());
            v1.add(ltu1.getHinhAnh_ltu());
            v1.add(ltu1.isTrangThai_ltu());
            v.add(v1);
        }
        return v;
    }

    public Vector getRows1(LoaiThucUong ltu, boolean ctt) {
        Vector v = new Vector();
        ArrayList<LoaiThucUong> alItem = model.getLoaiThucUong(ltu, ctt);
        for (LoaiThucUong ltu1 : alItem) {
            Vector v1 = new Vector();
            v1.add(ltu1.getId_ltu());
            v1.add(ltu1.getTen_ltu());
            v1.add(ltu1.getGia_ltu());
            v1.add(ltu1.getSoLuong_ltu());
            v1.add(ltu1.getDonVi_ltu());
            v.add(v1);
        }
        return v;
    }

    public Vector getRows2(ArrayList<LoaiThucUong> alItem) {
        Vector v = new Vector();
        if (alItem !=null) {
            for (LoaiThucUong ltu1 : alItem) {
                Vector v1 = new Vector();
                v1.add(ltu1.getId_ltu());
                v1.add(ltu1.getTen_ltu());
                v1.add(ltu1.getGia_ltu());
                v1.add(ltu1.getSoLuong_ltu());
                v1.add(ltu1.getDonVi_ltu());
                v1.add(ltu1.getGia_ltu()*ltu1.getSoLuong_ltu());
                v.add(v1);
            }
        }
        return v;
    }
  
    public void loadTable(JTable tb, DefaultTableModel model, LoaiThucUong ltu, boolean ctt) {

        model.setDataVector(getRows(ltu, ctt), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void loadTable1(JTable tb, DefaultTableModel model, LoaiThucUong ltu, boolean ctt) {

        model.setDataVector(getRows1(ltu, ctt), getCols1());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void loadTable1(JTable tb, DefaultTableModel model, ArrayList<LoaiThucUong> alItem) {

        model.setDataVector(getRows2(alItem), getCols2());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(0).setPreferredWidth(LibraryDimension.LTU_HEAD_WIDTH_COL_ID);
        table.getColumnModel().getColumn(2).setPreferredWidth(LibraryDimension.LTU_HEAD_WIDTH_COL_GIA);
        table.getColumnModel().getColumn(3).setPreferredWidth(LibraryDimension.LTU_HEAD_WIDTH_COL_DONVIs);

    }

    public ArrayList<LoaiThucUong> getLoaiThucUongBySoLuong() {
        return model.getLoaiThucUongBySoLuong();
    }

    public int add(LoaiThucUong ltu) {
        if (isValid(ltu, "add") == true) {
            model.add(ltu);
            return 1;
        }
        return 0;
    }

    public int edit(LoaiThucUong ltu) {
        if (isValid(ltu, "edit") == true) {
            model.edit(ltu);
            return 1;
        }
        return 0;
    }
     public int edit(ArrayList<LoaiThucUong> alItem) {
          return  model.edit(alItem);
    }
    public ArrayList<LoaiThucUong> getListLTUByList(ArrayList<ThuNhap> alTN){
        return model.getListLTUByList(alTN);
    }
    
    public boolean isValid(LoaiThucUong ltu, String nameCN) {
        switch (nameCN) {
            case "add":
                if ("".equals(ltu.getTen_ltu())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên loại thức uống");
                    return false;
                }
                if ("".equals(ltu.getDonVi_ltu())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào đơn vị tính");
                    return false;
                }
                if (ltu.getGia_ltu() <= 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn giá bán");
                    return false;
                }
                if (ltu.getGia_ltu() < 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng");
                    return false;
                }
                break;
            case "edit":
                if (ltu.getId_ltu() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
                    return false;
                }
                if (ltu.getGia_ltu() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn giá");
                    return false;
                }
                if ("".equals(ltu.getDonVi_ltu())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào đơn vị");
                    return false;
                }
                break;

        }
        return true;

    }

}
