/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Ban;
import bean.ChucVu;
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
public class ModelChucVuComboBox implements ComboBoxModel<ChucVu> {

    private ArrayList<ChucVu> alItem;
    private ChucVu itemSelected;
    private ModelChucVu modelChucVu;

    public ModelChucVuComboBox(ChucVu itemSelected) {
        modelChucVu = new ModelChucVu();
        alItem = modelChucVu.getChucVu(null);
        alItem.add(0,new ChucVu(0,"Tất cả"));
        if (itemSelected == null) {
            this.itemSelected = alItem.get(0);
        } else {
            this.itemSelected = itemSelected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        itemSelected = (ChucVu) anItem;
    }

    @Override
    public ChucVu getSelectedItem() {
        return itemSelected;
    }

    @Override
    public int getSize() {
        return alItem.size();
    }

    @Override
    public ChucVu getElementAt(int index) {
        return alItem.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
