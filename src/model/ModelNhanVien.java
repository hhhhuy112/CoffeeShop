package model;

import bean.About;
import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.NhanVien;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.LibraryDBConnect;

public class ModelNhanVien {

    private Connection conn = null;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryDBConnect libraryDBConnect;

    public ModelNhanVien() {
        try {
            libraryDBConnect = new LibraryDBConnect();
            conn = libraryDBConnect.getConnectMySQL();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int add(NhanVien item) {
        int result = 0;
        
        String sql = "INSERT INTO `nhanvien`(`cmnd`, `ten_nv`, `ngaysinh_nv`, `diachi_nv`, `sdt_nv`, `email_nv`, `level_lcb`, `id_cv`, `ngayvao_nv`, `ngayra_nv`, `trangThai_nv`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item.getMa_nv());
            pst.setString(2, item.getTen_nv());
            pst.setDate(3, item.getNgaySinh_nv());
            pst.setString(4, item.getDiaChi_nv());
            pst.setString(5, item.getSdt_nv());
            pst.setString(6, item.getEmail_nv());
            pst.setInt(7, item.getLevel_lcb());
            pst.setInt(8, item.getId_cv());
            pst.setDate(9,item.getNgayVao_nv());
            pst.setDate(10,item.getNgayRa_nv());
            pst.setBoolean(11, item.isTrangThai_nv());
            pst.executeUpdate();
            result = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi Sql");
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<NhanVien> getNhanVien(NhanVien nv, boolean tt,boolean cn) {
        String sql = "SELECT * FROM `nhanvien` WHERE 1 ";
        if (nv!= null) {
            if (nv.getMa_nv() >=0) {
                sql += "&& cmnd =" + nv.getMa_nv();
            }
            if(!"".equals(nv.getTen_nv())){
             sql += "&& `ten_nv` LIKE '%" + nv.getTen_nv()+"%'";
            }
            if (tt == true) {
                sql += "&&  `trangThai_nv`=" + nv.isTrangThai_nv();
            }
            if (cn ==true ) {
                if(nv.getNgayRa_nv()!=null){
                 sql += "&&  `ngayra_nv`=" + nv.getNgayRa_nv();
                }
                sql += "&&  `ngayvao_nv`=" + nv.getNgayVao_nv();
            }
            
            if(nv.getId_cv()>0){
               sql+="&&`id_cv`= "+nv.getId_cv();
            }
            if(nv.getLevel_lcb()>0){
               sql+="&&`level_lcb`= "+nv.getLevel_lcb();
            }
           
        }

        System.out.println(sql);
        ArrayList<NhanVien> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                NhanVien item = new NhanVien(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10), rs.getBoolean(11));
                alItem.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return alItem;
    }
     public ArrayList<NhanVien> getNhanVien() {
        String sql = "SELECT * FROM `nhanvien` WHERE trangThai_nv=true ";
        System.out.println(sql);
        ArrayList<NhanVien> alItem = new ArrayList<>();
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                NhanVien item = new NhanVien(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10), rs.getBoolean(11));
                alItem.add(item);
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

    public NhanVien getNhanViemByMaNV(int id) {
        String sql = "SELECT  `ten_nv`, `ngaysinh_nv`, `diachi_nv`, `sdt_nv`, `email_nv`, `level_lcb`, `id_cv`, `ngayvao_nv`, `ngayra_nv`, `trangThai_nv` FROM `nhanvien` WHERE `cmnd`="+id;
        NhanVien nv=null;
        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { 
                nv=new NhanVien(id,rs.getString(1),rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6), rs.getInt(7),rs.getDate(8),rs.getDate(9),rs.getBoolean(10));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi");
            ex.printStackTrace();
        }
        return nv;
    }
    

    public int delete(NhanVien nv) {
        int result = 0;
        String sql = "DELETE FROM `nhanvien` WHERE cmnd=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, nv.getMa_nv());
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

    public int edit(NhanVien item,int ccmnd) {
        System.out.println(ccmnd);
        int result = 0;
        String sql = "UPDATE `nhanvien` SET `cmnd`=?,`ten_nv`=?,`ngaysinh_nv`=?,`diachi_nv`=?,`sdt_nv`=?,`email_nv`=?,`level_lcb`=?,`id_cv`=?,`ngayvao_nv`=?,`ngayra_nv`=?,`trangThai_nv`=? WHERE `cmnd`=?";
        try {
            pst = conn.prepareStatement(sql);
             pst.setInt(1, item.getMa_nv());
            pst.setString(2, item.getTen_nv());
            pst.setDate(3, item.getNgaySinh_nv());
            pst.setString(4, item.getDiaChi_nv());
            pst.setString(5, item.getSdt_nv());
            pst.setString(6, item.getEmail_nv());
            pst.setInt(7, item.getLevel_lcb());
            pst.setInt(8, item.getId_cv());
            pst.setDate(9,item.getNgayVao_nv());
            pst.setDate(10,item.getNgayRa_nv());
            pst.setBoolean(11, item.isTrangThai_nv());
            pst.setInt(12, ccmnd);
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
