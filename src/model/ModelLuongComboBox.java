/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Ban;
import bean.ChucVu;
import bean.KhuVuc;
import bean.LuongCoBan;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import model.ModelAbout;

/**
 *
 * @author homin
 */
public class ModelLuongComboBox implements ComboBoxModel<LuongCoBan> {

    private ArrayList<LuongCoBan> alItem;
    private LuongCoBan itemSelected;
    private ModelLuongCoBan modelLuongCoBan;

    public ModelLuongComboBox(LuongCoBan itemSelected) {
        modelLuongCoBan = new ModelLuongCoBan();
        alItem = modelLuongCoBan.getLuongCoBan(null);
        alItem.add(0,new LuongCoBan(0,0));
        if (itemSelected == null) {
            this.itemSelected = alItem.get(0);
        } else {
            this.itemSelected = itemSelected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        itemSelected = (LuongCoBan) anItem;
    }

    @Override
    public LuongCoBan getSelectedItem() {
        return itemSelected;
    }

    @Override
    public int getSize() {
        return alItem.size();
    }

    @Override
    public LuongCoBan getElementAt(int index) {
        return alItem.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
