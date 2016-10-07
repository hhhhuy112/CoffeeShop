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
public class ModelKhuVucComboBox implements ComboBoxModel<KhuVuc> {

    private ArrayList<KhuVuc> alKhuVuc;
    private KhuVuc khuVucSelected;
    private ModelKhuVuc modelKhuVuc;

    public ModelKhuVucComboBox(KhuVuc khuVucSelected,Boolean find) {
        modelKhuVuc = new ModelKhuVuc();
        alKhuVuc = modelKhuVuc.getKhuVuc(null);
        alKhuVuc.add(0,new KhuVuc(0,"Tất cả"));
        if (khuVucSelected == null) {
            this.khuVucSelected = alKhuVuc.get(0);
        } else {
            this.khuVucSelected = khuVucSelected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        khuVucSelected = (KhuVuc) anItem;
    }

    @Override
    public KhuVuc getSelectedItem() {
        return khuVucSelected;
    }

    @Override
    public int getSize() {
        return alKhuVuc.size();
    }

    @Override
    public KhuVuc getElementAt(int index) {
        return alKhuVuc.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
