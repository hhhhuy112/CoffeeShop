/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.HoaDon;
import bean.KhuVuc;
import com.itextpdf.text.Document;
import java.awt.Dimension;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import library.LibraryDimension;
import library.LibraryPhieuHang;
import model.ModelHoaDon;
import model.ModelThuNhap;

/**
 *
 * @author homin
 */
public class ControllerHoaDon {

    private model.ModelHoaDon modelHoaDon;
    private controller.ControllerNhanVien controllerNhanVien;
    public ControllerHoaDon() {
        modelHoaDon=new ModelHoaDon();
        controllerNhanVien=new ControllerNhanVien();
    }

    public Vector<String> getCols() {
        Vector<String> v = new Vector();
        v.add("Id ");
        v.add("Bàn");
        v.add("Giờ vào");
        v.add("Giờ ra");
        v.add("Nhân viên");
        v.add("Tổng tiền");
        return v;
    }

    public Vector getRows(HoaDon hd1,boolean ctt) {
        Vector v = new Vector();
        ArrayList<HoaDon> alItem = modelHoaDon.getListHoaDon(hd1,ctt);
        for (HoaDon hd : alItem) {
            Vector v1 = new Vector();
            v1.add(hd.getId_hd());
            v1.add(hd.getId_ban());
            v1.add(hd.getTimeVao());
            v1.add(hd.getTimeRa());
            v1.add(controllerNhanVien.getNhanViemByMaNV(hd.getId_nv()).getTen_nv());
            v1.add(hd.getTongTien());
            v.add(v1);
        }
        return v;
    }

    public void loadTable(JTable tb, DefaultTableModel model,HoaDon hd,boolean ctt) {

        model.setDataVector(getRows(hd,ctt), getCols());
        tb.setModel(model);
        setWidthHeightTable(tb);
    }

    public void setWidthHeightTable(JTable table) {
        table.getTableHeader().setPreferredSize(new Dimension(table.getPreferredSize().width, 26));
        table.setRowHeight(26);
        table.getColumnModel().getColumn(1).setPreferredWidth(LibraryDimension.TK_HEAD_WIDTH_COL_BAN);
    }
    public ArrayList<HoaDon> getListHoaDon(){
        return modelHoaDon.getListHoaDon(null,false);
    } 
     public ArrayList<HoaDon> getListHoaDonEx(){
        return modelHoaDon.getListHoaDon(null,true);
    } 
    public int add(HoaDon hd) {
        if (isValid(hd, "add") == true) {
            modelHoaDon.add(hd);
            return 1;
        }
        return 0;
    }
    public HoaDon getHoaDonActiveById_ban(int idBan){
        return modelHoaDon.getHoaDonActiveById_ban(idBan);
    }
     public int delete(HoaDon hd) {
        if (isValid(hd, "delete") == true) {
            modelHoaDon.delete(hd);
            return 1;
        }
        return 0;
    }
     public int edit(HoaDon hd) {
        if (isValid(hd, "edit") == true) {
            System.out.println(String.valueOf(hd.getTimeRa()+"dấd"+hd.getTimeVao()));
            modelHoaDon.edit(hd);
            return 1;
        }
        return 0;
    }
//     public ArrayList<KhuVuc> getListKhuVuc(){
//         return model.getListKhuVuc();
//     }

    public boolean isValid(HoaDon
            hd, String nameCN) {
        switch (nameCN) {
            case "add":
                if (hd.getId_ban()==0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn");
                    return false;
                }
                 if (hd.getId_nv()<0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên");
                    return false;
                }
               
                break;
//            case "delete":
//                if (kv.getId_kv() == 0) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn để xóa");
//                    return false;
//                }
//                break;
            case "edit":
                if (hd.getId_hd() <= 0) {
                    JOptionPane.showMessageDialog(null, "Không xác định được hóa đơn");
                    return false;
                }
                if (hd.getId_ban()<=0) {
                    JOptionPane.showMessageDialog(null, "Không xác định được bàn");
                    return false;
                }
                if (hd.getId_nv()<=0) {
                    JOptionPane.showMessageDialog(null, "Không xác định được nhân viên");
                    return false;
                }
                break;    

        }
        return true;

    }

    public int createPhieuMua(Document document,String path,Date dateTO,Date dateFROM) {
        LibraryPhieuHang libraryPhieuHang=new LibraryPhieuHang(getCols(),getRows(null, true), path);
       return libraryPhieuHang.create(document,dateTO,dateFROM);
          
       
    }
    
  

}
