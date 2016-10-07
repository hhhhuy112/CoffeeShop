/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Ban;
import bean.KhuVuc;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import model.ModelAbout;

/**
 *
 * @author homin
 */
public class ModelTrangThaiComboBox implements ComboBoxModel {

    private ArrayList alTrangThai;
    private String trangThaiSelected;

    public ModelTrangThaiComboBox(String tt) {
      alTrangThai=new ArrayList();
        alTrangThai.add("Trạng thái");
      alTrangThai.add("Đang sử dụng");
      alTrangThai.add("Chưa sử dụng");
      alTrangThai.add("Đang hỏng");
      if(tt==null){
      trangThaiSelected=alTrangThai.get(0).toString();
      }else{
         
          for(Object a:alTrangThai){
              if(tt.equals(a)){
                  trangThaiSelected=(String) a;
              }
          }
      }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        trangThaiSelected = (String) anItem;
    }

    @Override
    public String getSelectedItem() {
        return trangThaiSelected;
    }

    @Override
    public int getSize() {
        return alTrangThai.size();
    }

    @Override
    public String getElementAt(int index) {
        return  (String) alTrangThai.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
