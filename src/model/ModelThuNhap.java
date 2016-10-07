package model;

import bean.About;
import bean.ChucVu;
import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.ThuNhap;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.LibraryDBConnect;

public class ModelThuNhap {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelThuNhap() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelThuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelThuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelThuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int delTN(ThuNhap tn) {
        int result = 0;
        String sql = "DELETE FROM thunhap WHERE id_tn=?";
        try {

            pst = conn.prepareStatement(sql);
            pst.setInt(1, tn.getId_tn());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }         
        return result;
    }

    public int saveTN(ArrayList<LoaiThucUong> alLTU, int idHD) {
        int result = 0;
        String sql = "";
        for (LoaiThucUong ltu : alLTU) {
            sql = "INSERT INTO `thunhap`(`id_ltu`, `id_hd`, `sl_tn`,gia_tn, `thanhtien_tn`) VALUES (?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, ltu.getId_ltu());
                pst.setInt(2, idHD);
                pst.setInt(3, ltu.getSoLuong_ltu());
                pst.setDouble(4, ltu.getGia_ltu());
                pst.setDouble(5, ltu.getGia_ltu() * ltu.getSoLuong_ltu());
                pst.executeUpdate();
                result = 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Loi Sql1");
                ex.printStackTrace();
            }
        }

        return result;
    }

    public ArrayList<ThuNhap> getListThuNhapByIdHD(int id) {
        String sql = "SELECT * FROM `thunhap` WHERE id_hd= " + id;
        ArrayList<ThuNhap> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ThuNhap tn = new ThuNhap(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
                alItem.add(tn);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }

    public ThuNhap getThuNhapByLTUVsHD(int idLTU, int idHD) {
        String sql = "SELECT * FROM `thunhap` WHERE id_ltu=" + idLTU + " && id_hd=" + idHD;
        ThuNhap tn = null;
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                tn = new ThuNhap(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return tn;
    }

    public int editTN(ThuNhap tn, int idHD) {
        int result = 0;
        String sql = "";
       
            sql = "UPDATE `thunhap` SET `sl_tn`=?,`thanhtien_tn`=? WHERE id_ltu=? && id_hd=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, tn.getSl_tn());
                pst.setDouble(2, tn.getGia_tn() * tn.getSl_tn());
                pst.setInt(3,tn.getId_ltu());
                pst.setInt(4, tn.getId_hd());
                pst.executeUpdate();
                result = 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Loi Sql2");
                ex.printStackTrace();
            }

        return result;
    }
}
//    public ArrayList<Cat> getList(Cat item) {
//        ArrayList<Cat> alItem = new ArrayList<>();
//        String sql = "SELECT * FROM category WHERE 1 ";
//        if (item != null) {
//            if (item.getId_cat() > 0) {
//                sql += "&& id_cat=" + item.getId_cat();
//            }
//            if (!item.getName().isEmpty()) {
//                sql += "&& name LIKE '%" + item.getName() + "%'";
//            }
//        }
//        try {
//
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                Cat cat = new Cat(rs.getInt("id_cat"), rs.getString("name"));
//                alItem.add(cat);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Loi Sql");
//            ex.printStackTrace();
//        }
//
//        return alItem;
//    }
//
//    public Cat getCatById(int id) {
//        String sql = "SELECT * FROM category WHERE id_cat= " + id;
//        Cat cat = new Cat();
//        try {
//
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                cat = new Cat(rs.getInt("id_cat"), rs.getString("name"));
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Loi Sql");
//            ex.printStackTrace();
//        }
//        return cat;
//    }
//
//    public int add(Cat item) {
//        int result = 0;
//        String sql = "INSERT INTO `category`(`name`) VALUES (?)";
//        try {
//
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, item.getName());
//            pst.executeUpdate();
//            result = 1;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Loi Sql");
//            ex.printStackTrace();
//        } finally {
//            try {
//                pst.close();
//                conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ModelAbout.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        return result;
//
//    }
//
//    public int del(Cat item) {
//        int result = 0;
//        String sql = "DELETE FROM category WHERE id_cat=?";
//        try {
//
//            pst = conn.prepareStatement(sql);
//            pst.setInt(1, item.getId_cat());
//            pst.executeUpdate();
//            result = 1;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Loi Sql");
//            ex.printStackTrace();
//        } finally {
//            try {
//                pst.close();
//                conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ModelAbout.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        return result;
//    }
//
//    public int edit(Cat item) {
//        int result = 0;
//        String sql = "UPDATE category SET name=? WHERE id_cat=?";
//        try {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, item.getName());
//            pst.setInt(2, item.getId_cat());
//            pst.executeUpdate();
//            result = 1;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Loi Sql");
//            ex.printStackTrace();
//        } finally {
//            try {
//                pst.close();
//                conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ModelAbout.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        return result;
//    }
//}
