/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author homin
 */
public class ThuNhap {
    private int id_tn;
    private int id_ltu;
    private int id_hd;
    private int sl_tn;
    private double gia_tn;
    private double tien_tn;

    public ThuNhap() {
    }

    public ThuNhap(int id_tn, int id_ltu, int id_hd, int sl_tn, double gia_tn, double tien_tn) {
        this.id_tn = id_tn;
        this.id_ltu = id_ltu;
        this.id_hd = id_hd;
        this.sl_tn = sl_tn;
        this.gia_tn = gia_tn;
        this.tien_tn = tien_tn;
    }
    
    public ThuNhap(int id_tn, int id_ltu, int id_hd, int sl_tn, double tien_tn) {
        this.id_tn = id_tn;
        this.id_ltu = id_ltu;
        this.id_hd = id_hd;
        this.sl_tn = sl_tn;
        this.tien_tn = tien_tn;
    }

    public int getId_tn() {
        return id_tn;
    }

    public void setId_tn(int id_tn) {
        this.id_tn = id_tn;
    }

    public double getGia_tn() {
        return gia_tn;
    }

    public void setGia_tn(double gia_tn) {
        this.gia_tn = gia_tn;
    }

    public int getId_ltu() {
        return id_ltu;
    }

    public void setId_ltu(int id_ltu) {
        this.id_ltu = id_ltu;
    }

    public int getId_hd() {
        return id_hd;
    }

    public void setId_hd(int id_hd) {
        this.id_hd = id_hd;
    }

    public int getSl_tn() {
        return sl_tn;
    }

    public void setSl_tn(int sl_tn) {
        this.sl_tn = sl_tn;
    }

    public double getTien_tn() {
        return tien_tn;
    }

    public void setTien_tn(double tien_tn) {
        this.tien_tn = tien_tn;
    }

  
}
