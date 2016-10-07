/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author homin
 */
public class NhanVien {
    private int ma_nv;
    private String ten_nv;
    private Date ngaySinh_nv;
    private String diaChi_nv;
    private String sdt_nv;
    private String email_nv;
    private int  level_lcb;
    private int id_cv;
    private Date ngayVao_nv;
    private Date ngayRa_nv;
    private boolean trangThai_nv;

    public NhanVien(int ma_nv, String ten_nv, Date ngaySinh_nv, String diaChi_nv, String sdt_nv, String email_nv, int level_lcb, int id_cv, Date ngayVao_nv, Date ngayRa_nv, boolean trangThai_nv) {
        this.ma_nv = ma_nv;
        this.ten_nv = ten_nv;
        this.ngaySinh_nv = ngaySinh_nv;
        this.diaChi_nv = diaChi_nv;
        this.sdt_nv = sdt_nv;
        this.email_nv = email_nv;
        this.level_lcb = level_lcb;
        this.id_cv = id_cv;
        this.ngayVao_nv = ngayVao_nv;
        this.ngayRa_nv = ngayRa_nv;
        this.trangThai_nv = trangThai_nv;
    }

   

   
  
  

    public NhanVien() {
    }

    public boolean isTrangThai_nv() {
        return trangThai_nv;
    }

    public void setTrangThai_nv(boolean trangThai_nv) {
        this.trangThai_nv = trangThai_nv;
    }

    public int getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(int ma_nv) {
        this.ma_nv = ma_nv;
    }

   

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public Date getNgaySinh_nv() {
        return ngaySinh_nv;
    }

    public void setNgaySinh_nv(Date ngaySinh_nv) {
        this.ngaySinh_nv = ngaySinh_nv;
    }

    public String getDiaChi_nv() {
        return diaChi_nv;
    }

    public void setDiaChi_nv(String diaChi_nv) {
        this.diaChi_nv = diaChi_nv;
    }

    public String getSdt_nv() {
        return sdt_nv;
    }

    public void setSdt_nv(String sdt_nv) {
        this.sdt_nv = sdt_nv;
    }

    public String getEmail_nv() {
        return email_nv;
    }

    public void setEmail_nv(String email_nv) {
        this.email_nv = email_nv;
    }

    public int getLevel_lcb() {
        return level_lcb;
    }

    public void setLevel_lcb(int level_lcb) {
        this.level_lcb = level_lcb;
    }

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public Date getNgayVao_nv() {
        return ngayVao_nv;
    }

    public void setNgayVao_nv(Date ngayVao_nv) {
        this.ngayVao_nv = ngayVao_nv;
    }

    public Date getNgayRa_nv() {
        return ngayRa_nv;
    }

    public void setNgayRa_nv(Date ngayRa_nv) {
        this.ngayRa_nv = ngayRa_nv;
    }

    @Override
    public String toString() {
        return this.getTen_nv();
    }
    
}
