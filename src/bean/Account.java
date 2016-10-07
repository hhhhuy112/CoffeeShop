/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Hi
 */
public class Account {
    private int id_cv;
    private String pass;
    private int id_nv;

    public Account(int id_cv, String pass, int id_nv) {
        this.id_cv = id_cv;
        this.pass = pass;
        this.id_nv = id_nv;
    }

    public Account() {
    }

    public int getId_cv() {
        return id_cv;
    }

    public void setId_cv(int id_cv) {
        this.id_cv = id_cv;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }
    
}
