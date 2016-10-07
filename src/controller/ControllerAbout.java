/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.About;
import java.sql.Time;
import javax.swing.JOptionPane;
import model.ModelAbout;

/**
 *
 * @author homin
 */
public class ControllerAbout {
    private ModelAbout modelAbout;
    public ControllerAbout(){
        modelAbout=new ModelAbout();
    }
    public int setAbout(About about){
      
        if(isValid(about)==true){
            modelAbout.setAbout(about);
           return 1;
        }else{
           return 0;
        }
       
         
    }
    public About getAbout(){
        return modelAbout.getAbout();
    }
    public boolean isValid(About about){
       if(about.getTenQuan_about()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng nhập vào Tên quán");
           return false;
       }else if(about.getAddress_about()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng nhập vào địa chỉ");
           return false;
       }else if(about.getChuQuan_about()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên chủ quán");
           return false;
       }else if(about.getSdt_about()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng nhập vào số điện thoại");
           return false;
       }else if(about.getGioMoCua()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng chọn giờ mở cửa");
           return false;
       }else if(about.getGioDongCua()==null){
           JOptionPane.showMessageDialog(null, "Vui lòng chọn giờ đóng cửa ");
           return false;
       }else if(about.getGioMoCua().after(about.getGioDongCua())==false){
           JOptionPane.showMessageDialog(null, "Vui lòng chọn giờ đóng cửa sau giờ mở cửa");
           return false;
       }else if(library.LibraryString.isNumBer(about.getSdt_about())==false){
           return false;
       }
       return true;
    }
}
