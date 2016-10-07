package model;

import bean.About;
import bean.ChucVu;
import bean.KhuVuc;
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

public class ModelChucVu {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelChucVu() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelChucVu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelChucVu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelChucVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(ChucVu item) {
        int result = 0;
        String sql = "INSERT INTO `chucvu`(`ten_cv`) VALUES (?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, item.getTen_cv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<ChucVu> getChucVu(ChucVu cv) {
        String sql = "SELECT * FROM `chucvu` WHERE 1 ";
        if (cv != null) {
            if (cv.getId_cv() > 0) {
                sql += "&& id_cv =" + cv.getId_cv();
            }
            if (!"".equals(cv.getTen_cv())) {
                sql += "&& ten_cv LIKE '%" + cv.getTen_cv()+"%'";
            }
        }
        System.out.println(sql);
        ArrayList<ChucVu> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
               ChucVu cv1 = new ChucVu(rs.getInt(1), rs.getString(2));
                alItem.add(cv1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
      public ChucVu getChucVuById(int id) {
        String sql = "SELECT * FROM `chucvu` WHERE id_cv= "+id;
        ChucVu cv=new ChucVu();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
               cv = new ChucVu(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return cv;
    }

    public int delete(ChucVu cv) {
        int result = 0;
        String sql = "DELETE FROM `chucvu` WHERE id_cv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cv.getId_cv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }
    public void setBan(int idKhuVuc){
         
        String sql = "DELETE FROM `ban` WHERE id_kv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,idKhuVuc);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
      
    }

    public int edit(ChucVu cv) {
        int result = 0;
        String sql = "UPDATE `chucvu` SET `ten_cv`=? WHERE id_cv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,cv.getTen_cv());
            pst.setInt(2,cv.getId_cv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
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
