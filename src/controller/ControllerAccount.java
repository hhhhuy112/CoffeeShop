/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Account;
import bean.Ban;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelAccount;

/**
 *
 * @author Hi
 */
public class ControllerAccount {
    private ModelAccount model;
    public ControllerAccount(){
        model=new ModelAccount();
    }
    public int ktAccount(Account a){
    int i=0;
    Account ac= model.getAccountById(a);
    if(ac!=null){
          i=1;
    }
        return i;
    }
    public int edit(Account a){
        int result=0;
        if(isValid(a,"edit")==true){
           
         model.edit(a);
          result=1;
        }
        return result;
    }
     public int edit1(Account a){
        int result=0;
        if(isValid(a,"edit")==true){
           
         model.edit1(a);
          result=1;
        }
        return result;
    }
     public ArrayList<Account> getListAcc(){
         return model.getList();
     }
      public boolean isValid(Account a, String nameCN) {
        switch (nameCN) {
            case "edit":
                if ("".equals(a.getPass())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập vào password mới");
                    return false;
                }
                if(!library.LibraryString.isPassword(a.getPass())){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng");
                    return  false;
                }
                break;    

        }
        return true;

    }

   
}
