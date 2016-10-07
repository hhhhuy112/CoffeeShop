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
public class Ban {
  private int id_ban;
  private int id_kv;
  private String trangThai;
 
    public Ban() {
    }

    public Ban(int id_ban, int id_kv) {
        this.id_ban = id_ban;
        this.id_kv = id_kv;
    }

    public Ban(int id_ban, int id_kv, String trangThai) {
        this.id_ban = id_ban;
        this.id_kv = id_kv;
        this.trangThai = trangThai;
    }

   

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public int getId_ban() {
        return id_ban;
    }

    public void setId_ban(int id_ban) {
        this.id_ban = id_ban;
    }

    public int getId_kv() {
        return id_kv;
    }

    public void setId_kv(int id_kv) {
        this.id_kv = id_kv;
    }
  
}
