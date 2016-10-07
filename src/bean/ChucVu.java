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
public class ChucVu {
    private int id_cv;
    private String ten_cv;

    public ChucVu(int id_cv, String ten_cv) {
        this.id_cv = id_cv;
        this.ten_cv = ten_cv;
    }

    public ChucVu() {
    }

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public String getTen_cv() {
        return ten_cv;
    }

    public void setTen_cv(String ten_cv) {
        this.ten_cv = ten_cv;
    }

    @Override
    public String toString() {
        return this.getTen_cv();
    }
    
}
