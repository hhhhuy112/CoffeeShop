package model;

import bean.About;
import bean.Ban;
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

public class ModelBan {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelBan() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelBan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelBan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(Ban item) {
        int result = 0;
        String sql = "INSERT INTO `ban`(  `id_kv`, `trangthai`) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item.getId_kv());
            pst.setString(2,item.getTrangThai());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<Ban> getList(Ban ban) {
        String sql = "SELECT * FROM `ban` WHERE 1 ";
        if (ban != null) {
            if (ban.getId_ban() > 0) {
                sql += "&& id_ban =" + ban.getId_ban();
                System.out.println("12");
            }
            if (ban.getId_kv()> 0) {
                sql += "&& id_kv =" + ban.getId_kv();
            }
            if (!"Trạng thái".equals(ban.getTrangThai())) {
                sql += "&& trangthai = '" + ban.getTrangThai()+"'";
            }
        }
        System.out.println(sql);
        ArrayList<Ban> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Ban ban1=new Ban(rs.getInt(1),rs.getInt(2),rs.getString(3));
                alItem.add(ban1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
    
       public ArrayList<Ban> getListBan(int idKV) {
        
           String sql = "SELECT * FROM `ban` WHERE 1";
       if(idKV!=0){
        sql = "SELECT * FROM `ban` WHERE id_kv= "+idKV+"&&trangthai<>'Đang hỏng'";
       }
        System.out.println(sql);
        ArrayList<Ban> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Ban ban1=new Ban(rs.getInt(1),rs.getInt(2),rs.getString(3));
                alItem.add(ban1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
    public int delete(Ban ban) {
        int result = 0;
        String sql = "DELETE FROM `ban` WHERE id_ban=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,ban.getId_ban());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }
    public Ban getBanById(int id){
    
             String sql = "SELECT * FROM `ban` WHERE id_ban="+id;
        System.out.println(sql);
        Ban ban = null;
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
               ban=new Ban(rs.getInt(1),rs.getInt(2),rs.getString(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return ban;
    }
    public int edit(Ban ban) {
        int result = 0;
        String sql = "UPDATE `ban` SET `id_kv`=?,`trangthai`=? WHERE `id_ban`=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,ban.getId_kv() );
            pst.setString(2, ban.getTrangThai());
              pst.setInt(3, ban.getId_ban());
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
