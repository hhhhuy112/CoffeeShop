package model;

import bean.About;
import bean.Account;
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

public class ModelAccount {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelAccount() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

   
   
      public Account getAccountById(Account a) {
        String sql = "SELECT `id_cv`, `pass`, `id_nv` FROM `acount`  WHERE id_cv= "+a.getId_cv()+" && id_nv="+a.getId_nv()+" && pass='"+library.LibraryString.md5(a.getPass())+"'";
       Account ac=null;
        try {
            System.out.println(sql);
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"s"+rs.getString(2)+"a"+rs.getInt(3));
                ac=new Account(rs.getInt(1),rs.getString(2),rs.getInt(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return ac;
    }

   
 
    public int edit(Account a) {
       
        int result = 0;
        String sql = "UPDATE `acount` SET `pass`=? WHERE id_cv=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,library.LibraryString.md5(a.getPass()));
            pst.setInt(2,a.getId_cv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }
    public int edit1(Account a) {
        int result = 0;
        String sql = "UPDATE `acount` SET `pass`=? WHERE id_cv <> ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,library.LibraryString.md5(a.getPass()));
            pst.setInt(2,a.getId_cv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<Account> getList() {
        ArrayList<Account> alItem = new ArrayList<>();
        String  sql="SELECT * FROM `acount` WHERE 1";
try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Account acc=new Account(rs.getInt(1),rs.getString(2),rs.getInt(3));
                alItem.add(acc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }

        return alItem;
    }
}
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
