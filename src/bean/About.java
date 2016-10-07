/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Time;

/**
 *
 * @author homin
 */
public class About {

    private String tenQuan_about;
    private String address_about;
    private String sdt_about;
    private String chuQuan_about;
    private Time gioMoCua;
    private Time gioDongCua;

    public String getTenQuan_about() {
        return tenQuan_about;
    }

    public void setTenQuan_about(String tenQuan_about) {
        this.tenQuan_about = tenQuan_about;
    }

    public String getAddress_about() {
        return address_about;
    }

    public void setAddress_about(String address_about) {
        this.address_about = address_about;
    }

    public String getSdt_about() {
        return sdt_about;
    }

    public void setSdt_about(String sdt_about) {
        this.sdt_about = sdt_about;
    }

    public String getChuQuan_about() {
        return chuQuan_about;
    }

    public void setChuQuan_about(String chuQuan_about) {
        this.chuQuan_about = chuQuan_about;
    }

    public Time getGioMoCua() {
        return gioMoCua;
    }

    public void setGioMoCua(Time gioMoCua) {
        this.gioMoCua = gioMoCua;
    }

    public Time getGioDongCua() {
        return gioDongCua;
    }

    public void setGioDongCua(Time gioDongCua) {
        this.gioDongCua = gioDongCua;
    }

    public About() {
    }

    public About(String tenQuan_about, String address_about, String sdt_about, String chuQuan_about, Time gioMoCua, Time gioDongCua) {
        this.tenQuan_about = tenQuan_about;
        this.address_about = address_about;
        this.sdt_about = sdt_about;
        this.chuQuan_about = chuQuan_about;
        this.gioMoCua = gioMoCua;
        this.gioDongCua = gioDongCua;
    }

}
