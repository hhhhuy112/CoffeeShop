/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ChucVu;
import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.ThuNhap;
import java.awt.Dimension;
import java.awt.TextField;
import java.sql.Array;
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

/**
 *
 * @author homin
 */
public class ControllerThuNhap {

    private model.ModelThuNhap modelThuNhap;
    private ControllerLoaiThucUong controllerLoaiThucUong;

    public ControllerThuNhap() {
        modelThuNhap = new model.ModelThuNhap();
        controllerLoaiThucUong = new ControllerLoaiThucUong();
    }

    public int saveTN(ArrayList<LoaiThucUong> alLTU, int idHD, boolean check) {
        int i = 0;
        if (check == false) {
            if (isValid(alLTU, "saveTN") == true) {
                modelThuNhap.saveTN(alLTU, idHD);
                i = 1;
            }
        } else {
            ArrayList<ThuNhap> alThuNhapDelete = new ArrayList<>();
            ArrayList<LoaiThucUong> alThuNhapAdd = new ArrayList<>();
            ArrayList<ThuNhap> alThuNhapEdit = new ArrayList<>();
            ArrayList<ThuNhap> alThuNhap = modelThuNhap.getListThuNhapByIdHD(idHD);
            for (ThuNhap tn : alThuNhap) {
                int ckTN = 0;
                for (LoaiThucUong ltu : alLTU) {
                    System.out.println("ID:"+ltu.getId_ltu());
                    ThuNhap tn1 = modelThuNhap.getThuNhapByLTUVsHD(ltu.getId_ltu(), idHD);
                    if (tn1 != null) {
                        System.out.println("tn1:"+tn1.getId_tn());
                        System.out.println("tn:"+tn.getId_tn());
                        if (tn.getId_tn() == tn1.getId_tn()) {
                            ckTN++;
                        }
                    }
                   
                }
                if (ckTN == 0) {
                    System.out.println("Xoa: "+tn.getId_ltu());
                        alThuNhapDelete.add(tn);
                    } 
            }
            for (LoaiThucUong ltu : alLTU) {
                ThuNhap tn1 = modelThuNhap.getThuNhapByLTUVsHD(ltu.getId_ltu(), idHD);
                if (tn1 != null) {

                    alThuNhapEdit.add(tn1);

                } else {
                    alThuNhapAdd.add(ltu);
                }
            }
            if (alThuNhapDelete.size() > 0) {
                for (ThuNhap tn : alThuNhapDelete) {
                    modelThuNhap.delTN(tn);
                }
            }
            if (alThuNhapAdd.size() > 0) {
                if (modelThuNhap.saveTN(alThuNhapAdd, idHD) > 0) {
                    i = 1;
                }
            }
            if (alThuNhapEdit.size() > 0) {
                i = 1;
                for (ThuNhap tn : alThuNhap) {
                    modelThuNhap.editTN(tn, idHD);
                }
            }
        }

        return i;

    }

    public ArrayList<LoaiThucUong> getListLoaiThucUongByIdHD(int id) {
        ArrayList<ThuNhap> alTN = modelThuNhap.getListThuNhapByIdHD(id);
        ArrayList<LoaiThucUong> alLTU = new ArrayList<>();
        if (alTN != null) {
            System.out.println("sddddddđ" + alLTU.size());
            alLTU = controllerLoaiThucUong.getListLTUByList(alTN);
        }
        return alLTU;
    }

//    public int add(ChucVu cv) {
//        if (isValid(cv, "add") == true) {
//            model.add(cv);
//            return 1;
//        }
//        return 0;
//    }
//     public int delete(ChucVu cv) {
//        if (isValid(cv, "delete") == true) {
//            model.delete(cv);
//            return 1;
//        }
//        return 0;
//    }
//     public int edit(ChucVu cv) {
//        if (isValid(cv, "edit") == true) {
//            model.edit(cv);
//            return 1;
//        }
//        return 0;
//    }
    public boolean isValid(ArrayList<LoaiThucUong> alItem, String nameCN) {
        switch (nameCN) {
            case "saveTN":
                if (alItem.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Chưa có Thức uống được chọn");
                    return false;
                }
                break;
//            case "delete":
//                if (cv.getId_cv() == 0) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
//                    return false;
//                }
//                break;
//            case "edit":
//                if (cv.getId_cv() == 0) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để sửa");
//                    return false;
//                }
//                if ("".equals(cv.getTen_cv())) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên chức vụ");
//                    return false;
//                }
//                break;    

        }
        return true;

    }

}
