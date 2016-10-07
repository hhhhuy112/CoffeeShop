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
public class KhuVuc {
    private int id_kv;
    private String ten_kv;

    public KhuVuc(int id_kv, String ten_kv) {
        this.id_kv = id_kv;
        this.ten_kv = ten_kv;
    }

    public KhuVuc() {
    }

    public int getId_kv() {
        return id_kv;
    }

    public void setId_kv(int id_kv) {
        this.id_kv = id_kv;
    }

    public String getTen_kv() {
        return ten_kv;
    }

    public void setTen_kv(String ten_kv) {
        this.ten_kv = ten_kv;
    }

    @Override
    public String toString() {
        return this.ten_kv;
    }
    
}
