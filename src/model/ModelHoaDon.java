package model;

import bean.About;
import bean.HoaDon;
import bean.KhuVuc;
import bean.LoaiThucUong;
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

public class ModelHoaDon {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelHoaDon() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(HoaDon hd) {
        int result = 0;
        String sql = "INSERT INTO `hoadon`(`id_ban`, `id_nv`, `time_vao`, `time_ra`,tongtien, `trangthai`) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,hd.getId_ban());
            pst.setInt(2,hd.getId_nv());
            pst.setTimestamp(3,hd.getTimeVao());
            pst.setTimestamp(4,hd.getTimeRa());
            pst.setDouble(5,hd.getTongTien());
            pst.setBoolean(6,hd.isTrangThai());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<HoaDon> getListHoaDon(HoaDon hd,boolean ck) {
        String sql = "SELECT * FROM `hoadon` WHERE 1 ";
        if (hd != null) {
            if (hd.getTimeVao()!=null&&hd.getTimeRa()!=null) {
                sql += "&& (time_vao BETWEEN '"+ hd.getTimeVao()+"' AND '"+hd.getTimeRa()+"')";
            }
        }
        if(ck==true){
        sql+= "&& trangthai=false";
        }
        System.out.println(sql);
        ArrayList<HoaDon> alItem = new ArrayList<>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd1=new HoaDon(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4),rs.getTimestamp(5),rs.getDouble(6),rs.getBoolean(7));
                alItem.add(hd1);
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

    public int delete(HoaDon hd) {
        int result = 0;
        String sql = "DELETE FROM `hoadon` WHERE id_hd=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, hd.getId_hd());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }
   public HoaDon getHoaDonActiveById_ban(int idBan){
        String sql = "SELECT * FROM `hoadon` WHERE id_ban= "+idBan+" &&trangthai=true";

        System.out.println(sql);
        HoaDon hd=null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
          hd=new HoaDon(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getTimestamp(4), null,rs.getBoolean(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return hd;
   }

    public int edit(HoaDon hd) {
        int result = 0;
        String sql = "UPDATE `hoadon` SET `time_ra`=?,`trangthai`=? WHERE id_hd=?";
        System.out.println("h ra"+hd.getTimeVao()+"sdfsdf"+hd.getTimeRa());
              
        try {
            pst = conn.prepareStatement(sql);
            pst.setTimestamp(1, hd.getTimeRa());
            pst.setBoolean(2,hd.isTrangThai());
            pst.setInt(3,hd.getId_hd());
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
