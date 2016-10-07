/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Ban;
import bean.HoaDon;
import bean.LoaiThucUong;
import bean.ThuNhap;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import library.LibraryDimension;

/**
 *
 * @author Hi
 */
public class ControllerThanhToan {
    private ControllerThuNhap controllerThuNhap;
    public ControllerThanhToan(){
        controllerThuNhap=new ControllerThuNhap();
    }
      public Vector getCols() {
        Vector v = new Vector();
        v.add("Id");
        v.add("Thức uống");
        v.add("Giá");
        v.add("Số lượng");
        return v;
    }

    public Vector getRows(HoaDon hd) {
        Vector v = new Vector();
        ArrayList<LoaiThucUong> alLtu=controllerThuNhap.getListLoaiThucUongByIdHD(hd.getId_hd());
        for (LoaiThucUong ltu:alLtu) {
            Vector v1 = new Vector();
            v1.add(ltu.getId_ltu());
            v1.add(ltu.getTen_ltu());
            v1.add(ltu.getGia_ltu());
            v1.add(ltu.getSoLuong_ltu());
            v1.add(ltu.getSoLuong_ltu()*ltu.getGia_ltu());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,HoaDon hd) {

        model.setDataVector(getRows(hd), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.CAT_HEAD_WIDTH_COL_NAME);
    }
}
