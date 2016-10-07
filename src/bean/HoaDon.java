/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author Hi
 */
public class HoaDon {
    private int id_hd;
    private int id_ban;
    private int id_nv;
    private Timestamp timeVao;
    private Timestamp timeRa;
    private double tongTien;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int id_hd, int id_ban, int id_nv, Timestamp timeVao, Timestamp timeRa, boolean trangThai) {
        this.id_hd = id_hd;
        this.id_ban = id_ban;
        this.id_nv = id_nv;
        this.timeVao = timeVao;
        this.timeRa = timeRa;
        this.trangThai = trangThai;
    }

    public HoaDon(int id_hd, int id_ban, int id_nv, Timestamp timeVao, Timestamp timeRa, double tongTien, boolean trangThai) {
        this.id_hd = id_hd;
        this.id_ban = id_ban;
        this.id_nv = id_nv;
        this.timeVao = timeVao;
        this.timeRa = timeRa;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getId_hd() {
        return id_hd;
    }

    public void setId_hd(int id_hd) {
        this.id_hd = id_hd;
    }

    public int getId_ban() {
        return id_ban;
    }

    public void setId_ban(int id_ban) {
        this.id_ban = id_ban;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public Timestamp getTimeVao() {
        return timeVao;
    }

    public void setTimeVao(Timestamp timeVao) {
        this.timeVao = timeVao;
    }

    public Timestamp getTimeRa() {
        return timeRa;
    }

    public void setTimeRa(Timestamp timeRa) {
        this.timeRa = timeRa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
