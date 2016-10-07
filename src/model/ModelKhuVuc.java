package model;

import bean.About;
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

public class ModelKhuVuc {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelKhuVuc() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelKhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelKhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelKhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(KhuVuc item) {
        int result = 0;
        String sql = "INSERT INTO `khuvuc`(`ten_kv`) VALUES (?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, item.getTen_kv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<KhuVuc> getKhuVuc(KhuVuc kv) {
        String sql = "SELECT * FROM `khuvuc` WHERE 1 ";
        if (kv != null) {
            if (kv.getId_kv() > 0) {
                sql += "&& id_kv =" + kv.getId_kv();
            }
            if (!"".equals(kv.getTen_kv())) {
                sql += "&& ten_kv LIKE '%" + kv.getTen_kv()+"%'";
            }
        }
        System.out.println(sql);
        ArrayList<KhuVuc> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                KhuVuc khuVuc = new KhuVuc(rs.getInt(1), rs.getString(2));
                alItem.add(khuVuc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
    public ArrayList<KhuVuc> getListKhuVuc(){
        String sql = "SELECT * FROM `khuvuc` WHERE 1 ";
        System.out.println(sql);
        ArrayList<KhuVuc> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                KhuVuc khuVuc = new KhuVuc(rs.getInt(1), rs.getString(2));
                alItem.add(khuVuc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
      public KhuVuc getKhuVucById(int id) {
        String sql = "SELECT * FROM `khuvuc` WHERE id_kv= "+id;
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

    public int edit(KhuVuc kv) {
        int result = 0;
        String sql = "UPDATE `khuvuc` SET `ten_kv`=? WHERE id_kv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, kv.getTen_kv());
            pst.setInt(2, kv.getId_kv());
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
