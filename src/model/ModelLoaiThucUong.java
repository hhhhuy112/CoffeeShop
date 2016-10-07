package model;

import bean.About;
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

public class ModelLoaiThucUong {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelLoaiThucUong() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelLoaiThucUong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelLoaiThucUong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelLoaiThucUong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(LoaiThucUong item) {
        int result = 0;
        String sql = "INSERT INTO `loaithucuong`( `ten_ltu`, `gia_ltu`, `soluong`, `donvi`, `hinhanh_ltu`, `trangthai`) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, item.getTen_ltu());
            pst.setDouble(2, item.getGia_ltu());
            pst.setInt(3, item.getSoLuong_ltu());
            pst.setString(4, item.getDonVi_ltu());
            pst.setString(5, item.getHinhAnh_ltu());
            pst.setBoolean(6, item.isTrangThai_ltu());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<LoaiThucUong> getLoaiThucUong(LoaiThucUong ltu, boolean tt) {
        String sql = "SELECT * FROM `loaithucuong` WHERE 1 ";
        if (ltu != null) {
            if (ltu.getId_ltu() > 0) {
                sql += "&& id_ltu =" + ltu.getId_ltu();
            }
            if (!"".equals(ltu.getTen_ltu())) {
                sql += "&& ten_ltu LIKE '%" + ltu.getTen_ltu() + "%'";
            }
            if (tt == true) {
                sql += "&& trangthai =" + ltu.isTrangThai_ltu();
            }

            if (ltu.getGia_ltu() >= 0) {
                sql += "&& (gia_ltu >" + ltu.getGia_ltu() + "|| gia_ltu =" + ltu.getGia_ltu() + ")";
            }
            if (ltu.getGiaMax_ltu() >= 0) {
                sql += "&& (gia_ltu <" + ltu.getGiaMax_ltu() + "|| gia_ltu =" + ltu.getGiaMax_ltu() + ")";
            }
            if (ltu.getSoLuong_ltu() >= 0) {
                sql += "&& (soluong >" + ltu.getSoLuong_ltu() + "|| soluong =" + ltu.getSoLuong_ltu() + ")";
            }
            if (ltu.getSoLuongMax_ltu() >= 0) {
                sql += "&& ( soluong <" + ltu.getSoLuongMax_ltu() + "|| soluong =" + ltu.getSoLuongMax_ltu() + ")";
            }
        }

        System.out.println(sql);
        ArrayList<LoaiThucUong> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                LoaiThucUong ltu1 = new LoaiThucUong(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                alItem.add(ltu1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }

    public ArrayList<LoaiThucUong> getLoaiThucUongBySoLuong() {
        String sql = "SELECT * FROM `loaithucuong` WHERE 1";
        ArrayList<LoaiThucUong> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                LoaiThucUong ltu1 = new LoaiThucUong(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                alItem.add(ltu1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }

    public KhuVuc getKhuVucById(int id) {
        String sql = "SELECT * FROM `khuvuc` WHERE id_kv= " + id;
        KhuVuc khuVuc = new KhuVuc();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                khuVuc = new KhuVuc(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return khuVuc;
    }

    public int delete(KhuVuc kv) {
        int result = 0;
        String sql = "DELETE FROM `khuvuc` WHERE id_kv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, kv.getId_kv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public void setBan(int idKhuVuc) {

        String sql = "DELETE FROM `ban` WHERE id_kv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idKhuVuc);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }

    }

    public int edit(LoaiThucUong ltu) {
        int result = 0;
        String sql = "UPDATE `loaithucuong` SET `ten_ltu`=?,`gia_ltu`=?,`soluong`=?,`donvi`=?,`hinhanh_ltu`=?,`trangthai`=? WHERE `id_ltu`=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ltu.getTen_ltu());
            pst.setDouble(2, ltu.getGia_ltu());
            pst.setInt(3, ltu.getSoLuong_ltu());
            pst.setString(4, ltu.getDonVi_ltu());
            pst.setString(5, ltu.getHinhAnh_ltu());
            pst.setBoolean(6, ltu.isTrangThai_ltu());
            pst.setInt(7, ltu.getId_ltu());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public int edit(ArrayList<LoaiThucUong> alItem) {
        int result = 0;
        String sql = "";
        for (LoaiThucUong ltu : alItem) {
            sql = "UPDATE `loaithucuong` SET `soluong`=`soluong`-? WHERE `id_ltu`=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, ltu.getSoLuong_ltu());
                pst.setInt(2, ltu.getId_ltu());
                pst.executeUpdate();
                result = 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Loi Sql");
                ex.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<LoaiThucUong> getListLTUByList(ArrayList<ThuNhap> alTN) {
        ArrayList<LoaiThucUong> alItem = new ArrayList<>();
        String sql = "";
        for (ThuNhap tn : alTN) {
            sql = "SELECT * FROM `loaithucuong` WHERE id_ltu=" + tn.getId_ltu();

            try {

                st = conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    LoaiThucUong ltu1 = new LoaiThucUong(rs.getInt(1), rs.getString(2), rs.getDouble(3),tn.getSl_tn(), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                    alItem.add(ltu1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Loi");
                ex.printStackTrace();
            }
        }
        return alItem;
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
