/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.NhanVien;
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
import model.ModelLoaiThucUong;
import model.ModelLuongCoBan;
import model.ModelNhanVien;

/**
 *
 * @author homin
 */
public class ControllerNhanVien {

    private model.ModelNhanVien model;
    private model.ModelChucVu modelCV;
    private model.ModelLuongCoBan modelLuong;

    public ControllerNhanVien() {
        model = new ModelNhanVien();
        modelCV = new ModelChucVu();
        modelLuong = new ModelLuongCoBan();
    }

    public Vector getCols() {
        Vector v = new Vector();
        v.add("CMND");
        v.add("Họ và tên");
        v.add("Ngày sinh");
        v.add("SĐT");
        v.add("Chức vụ");
        v.add("Level");
        v.add("Trạng thái");
        return v;
    }

    public Vector getRows(NhanVien nv, boolean ctt,boolean cn) {
        Vector v = new Vector();
        ArrayList<NhanVien> alItem = model.getNhanVien(nv, ctt,cn);
        for (NhanVien nv1 : alItem) {
            Vector v1 = new Vector();
            v1.add(nv1.getMa_nv());
            v1.add(nv1.getTen_nv());
            v1.add(nv1.getNgaySinh_nv());
            v1.add(nv1.getSdt_nv());
            v1.add(modelCV.getChucVuById(nv1.getId_cv()));
            v1.add(modelLuong.getLuongById(nv1.getLevel_lcb()));
            v1.add(nv1.isTrangThai_nv());

            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model, NhanVien nv, boolean ctt,boolean cn) {

        model.setDataVector(getRows(nv, ctt,cn), getCols());
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

    public int add(NhanVien nv) {
        if (isValid(nv, "add", 0) == true) {
            model.add(nv);
            return 1;
        }
        return 0;
    }

    public int delete(NhanVien nv) {
        if (isValid(nv, "delete", 0) == true) {
            model.delete(nv);
            return 1;
        }
        return 0;
    }

    public int edit(NhanVien nv, int ccmnd) {

        if (isValid(nv, "edit", ccmnd) == true) {
            model.edit(nv,ccmnd);
            return 1;
        }
        return 0;
    }

    public boolean isValid(NhanVien nv, String nameCN, int ccmnd) {

        switch (nameCN) {
            case "add":
                 NhanVien nv2 = model.getNhanViemByMaNV(nv.getMa_nv());
                if (nv2 != null) {
                    JOptionPane.showMessageDialog(null, "CMND bị trùng");
                    return false;
                }
                if (nv.getMa_nv() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập CMND của bạn");
                    return false;
                }
                if ("".equals(nv.getTen_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào họ và tên");
                    return false;
                }
                if ("".equals(nv.getDiaChi_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào địa chỉ");
                    return false;
                }
                if ("".equals(nv.getEmail_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào email");
                    return false;
                }
                if ("".equals(nv.getSdt_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào số điện thoại");
                    return false;
                }
                if (nv.getLevel_lcb() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn lương");
                    return false;
                }
                if (nv.getId_cv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chức vụ");
                    return false;
                }
                if (nv.getNgayRa_nv() != null) {
                    if (nv.getNgayVao_nv().after(nv.getNgayRa_nv())) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày vào bằng ngày ra");
                        return false;
                    }
                }
                break;
            case "delete":
                if (nv.getMa_nv() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa ");
                    return false;
                }
                break;
            case "edit":
                NhanVien nv1 = model.getNhanViemByMaNV(nv.getMa_nv());
                if (nv1 != null) {
                    if (nv1.getMa_nv() != ccmnd && nv1.getMa_nv() == nv.getMa_nv()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập CMND của bạn bị trùng");
                        return false;

                    }
                }

                if (nv.getMa_nv() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập CMND của bạn");
                    return false;
                }
                if ("".equals(nv.getTen_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào họ và tên");
                    return false;
                }
                if ("".equals(nv.getDiaChi_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào địa chỉ");
                    return false;
                }
                if ("".equals(nv.getEmail_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào email");
                    return false;
                }
                if ("".equals(nv.getSdt_nv())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào số điện thoại");
                    return false;
                }
                if (nv.getLevel_lcb() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn lương");
                    return false;
                }
                if (nv.getId_cv() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chức vụ");
                    return false;
                }
                if (nv.getNgayRa_nv() != null) {
                    if (nv.getNgayVao_nv().after(nv.getNgayRa_nv())) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày vào bằng ngày ra");
                        return false;
                    }
                }
                if (nv.getMa_nv() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa ");
                    return false;
                }
                break;

        }

        return true;

    }

    public NhanVien getNhanViemByMaNV(int id) {
        return model.getNhanViemByMaNV(id);
    }

    

}
