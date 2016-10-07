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
public class LuongCoBan {
    private int level_lcb;
    private double luong_lcb;

    public LuongCoBan(int level_lcb, double luong_lcb) {
        this.level_lcb = level_lcb;
        this.luong_lcb = luong_lcb;
    }

    public LuongCoBan() {
    }

    public int getLevel_lcb() {
        return level_lcb;
    }

    public void setLevel_lcb(int level_lcb) {
        this.level_lcb = level_lcb;
    }

    public double getLuong_lcb() {
        return luong_lcb;
    }

    public void setLuong_lcb(double luong_lcb) {
        this.luong_lcb = luong_lcb;
    }

    @Override
    public String toString() {
        return String .valueOf(this.getLevel_lcb());
    }
    
}
