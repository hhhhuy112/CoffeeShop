/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Ban;
import bean.KhuVuc;
import bean.NhanVien;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import model.ModelAbout;

/**
 *
 * @author homin
 */
public class ModelNhanVienComboBox implements ComboBoxModel<NhanVien> {

    private ArrayList<NhanVien> alNhanVien;
    private NhanVien nhanVienSelected;
    private ModelNhanVien modelNhanVien;

    public ModelNhanVienComboBox(NhanVien nhanVienSelected) {
        modelNhanVien = new ModelNhanVien();
        alNhanVien = modelNhanVien.getNhanVien();
        alNhanVien.add(0,new NhanVien(-1,"Tất cả", null, null, null, null,0,0, null, null, true));
        if (nhanVienSelected == null) {
            this.nhanVienSelected = alNhanVien.get(0);
        } else {
            this.nhanVienSelected =nhanVienSelected;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        nhanVienSelected = (NhanVien) anItem;
    }

    @Override
    public NhanVien getSelectedItem() {
        return nhanVienSelected;
    }

    @Override
    public int getSize() {
        return alNhanVien.size();
    }

    @Override
    public NhanVien getElementAt(int index) {
        return alNhanVien.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

}
