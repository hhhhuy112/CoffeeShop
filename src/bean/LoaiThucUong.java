/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author homin
 */
public class LoaiThucUong {
    private int id_ltu;
    private String ten_ltu;
    private double gia_ltu;
    private double giaMax_ltu;
    private int soLuong_ltu;
    private int soLuongMax_ltu;
    private String donVi_ltu;
    private String hinhAnh_ltu;
    private boolean trangThai_ltu;

    public LoaiThucUong(int id_ltu, String ten_ltu, double gia_ltu, int soLuong_ltu, String donVi_ltu, String hinhAnh_ltu, boolean trangThai_ltu) {
        this.id_ltu = id_ltu;
        this.ten_ltu = ten_ltu;
        this.gia_ltu = gia_ltu;
        this.soLuong_ltu = soLuong_ltu;
        this.donVi_ltu = donVi_ltu;
        this.hinhAnh_ltu = hinhAnh_ltu;
        this.trangThai_ltu = trangThai_ltu;
    }

    public LoaiThucUong(int id_ltu, String ten_ltu, double gia_ltu, double giaMax_ltu, int soLuong_ltu, int soLuongMax_ltu, String donVi_ltu, String hinhAnh_ltu, boolean trangThai_ltu) {
        this.id_ltu = id_ltu;
        this.ten_ltu = ten_ltu;
        this.gia_ltu = gia_ltu;
        this.giaMax_ltu = giaMax_ltu;
        this.soLuong_ltu = soLuong_ltu;
        this.soLuongMax_ltu = soLuongMax_ltu;
        this.donVi_ltu = donVi_ltu;
        this.hinhAnh_ltu = hinhAnh_ltu;
        this.trangThai_ltu = trangThai_ltu;
    }

    public LoaiThucUong(boolean trangThai_ltu) {
        this.trangThai_ltu = trangThai_ltu;
    }

    public LoaiThucUong() {
    }

    public double getGiaMax_ltu() {
        return giaMax_ltu;
    }

    public void setGiaMax_ltu(double giaMax_ltu) {
        this.giaMax_ltu = giaMax_ltu;
    }

    public int getSoLuongMax_ltu() {
        return soLuongMax_ltu;
    }

    public void setSoLuongMax_ltu(int soLuongMax_ltu) {
        this.soLuongMax_ltu = soLuongMax_ltu;
    }
    
    public boolean isTrangThai_ltu() {
        return trangThai_ltu;
    }

    public void setTrangThai_ltu(boolean trangThai_ltu) {
        this.trangThai_ltu = trangThai_ltu;
    }

    public String getDonVi_ltu() {
        return donVi_ltu;
    }

    public void setDonVi_ltu(String donVi_ltu) {
        this.donVi_ltu = donVi_ltu;
    }

    public int getId_ltu() {
        return id_ltu;
    }

    public void setId_ltu(int id_ltu) {
        this.id_ltu = id_ltu;
    }

    public String getTen_ltu() {
        return ten_ltu;
    }

    public void setTen_ltu(String ten_ltu) {
        this.ten_ltu = ten_ltu;
    }

    public double getGia_ltu() {
        return gia_ltu;
    }

    public void setGia_ltu(double gia_ltu) {
        this.gia_ltu = gia_ltu;
    }
    public int getSoLuong_ltu() {
        return soLuong_ltu;
    }

    public void setSoLuong_ltu(int soLuong_ltu) {
        this.soLuong_ltu = soLuong_ltu;
    }

    public String getHinhAnh_ltu() {
        return hinhAnh_ltu;
    }

    public void setHinhAnh_ltu(String hinhAnh_ltu) {
        this.hinhAnh_ltu = hinhAnh_ltu;
    }

    @Override
    public String toString() {
        return this.getTen_ltu(); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
