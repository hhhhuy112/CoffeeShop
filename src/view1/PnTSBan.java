/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view1;

import bean.Ban;
import bean.KhuVuc;
import controller.ControllerBan;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import library.LibraryDimension;
import model.ModelKhuVucComboBox;
import model.ModelTrangThaiComboBox;

/**
 *
 * @author MinhHuyHo
 */
public class PnTSBan extends javax.swing.JPanel implements ActionListener {

    private DefaultTableModel model;
    private int crow;
    private int rowCount = 0;
    private String lKT = "";
    private controller.ControllerBan controller;
    private  Vector v;
    public PnTSBan() {
        initComponents();
        v=new Vector();
        btBanNhapLai.addActionListener(this);
        btBanSua.addActionListener(this);
        btBanThem.addActionListener(this);
        btBanXoa.addActionListener(this);
        btBanSearch.addActionListener(this);
          crow=-1;
        rowCount=tbBan.getSelectedRowCount();
        controller=new ControllerBan();
        //set split pane
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnCatLeft, pnCatRight);
        sp.setOneTouchExpandable(true);
        add(sp);
        pnCatLeft.setMinimumSize(new Dimension(LibraryDimension.PANEL_LEFT_WIDTH, pnCatLeft.getSize().height));
        model = new DefaultTableModel() {
       
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                if (columnIndex == 3) {
//                    return Boolean.class;
//                }
//                return super.getColumnClass(columnIndex);
//            }

        };
        loadTable( null);
        for(int i=0;i<tbBan.getRowCount();i++){
            if("Đang sử dụng".equals(tbBan.getValueAt(i,2))){
            }
        
        }
     ( (JComponent)  tbBan.getDefaultRenderer(Boolean.class)).setOpaque(true);
        loadComboBox(null, cbBanKhuVuc,false);
        loadComboBox(null, cbBanKhuVucFind,true);
        loadTrangThaiComboBox(null, cbBanTrangThai);
        loadTrangThaiComboBox(null, cbBanTrangThaiFind);

    }

    public void loadTable(Ban ban) {
        controller.loadTable(tbBan, model, ban);
    }
    public void loadComboBox(KhuVuc kv,JComboBox cb,boolean sFind){
        cb.setModel(new ModelKhuVucComboBox(kv,sFind));
    }
     public void loadTrangThaiComboBox(String tt,JComboBox cb){
        cb.setModel(new ModelTrangThaiComboBox(tt));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCatLeft = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btBanThem = new javax.swing.JButton();
        btBanSua = new javax.swing.JButton();
        btBanNhapLai = new javax.swing.JButton();
        btBanXoa = new javax.swing.JButton();
        cbBanKhuVuc = new javax.swing.JComboBox();
        tfBanId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbBanTrangThai = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfBanIdFind = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btBanSearch = new javax.swing.JButton();
        cbBanKhuVucFind = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbBanTrangThaiFind = new javax.swing.JComboBox();
        pnCatRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnCatLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCatLeft.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Mã bàn :");

        jLabel2.setText("Khu vực:");

        btBanThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBanThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btBanThem.setText("Thêm");
        jPanel3.add(btBanThem);

        btBanSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBanSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btBanSua.setText("Sửa");
        btBanSua.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btBanSua);

        btBanNhapLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBanNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.gif"))); // NOI18N
        btBanNhapLai.setText("Nhập lại");
        btBanNhapLai.setPreferredSize(new java.awt.Dimension(95, 25));
        btBanNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanNhapLaiActionPerformed(evt);
            }
        });
        jPanel3.add(btBanNhapLai);

        btBanXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBanXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.gif"))); // NOI18N
        btBanXoa.setText("Xóa");
        btBanXoa.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btBanXoa);

        cbBanKhuVuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfBanId.setEnabled(false);
        tfBanId.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel6.setText("Trạng thái:");

        cbBanTrangThai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang sử dụng", "Chưa sử dụng", "Đang hỏng" }));
        cbBanTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBanTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBanTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbBanKhuVuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfBanId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(264, 264, 264)))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBanId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBanKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbBanTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbBanKhuVuc, cbBanTrangThai, tfBanId});

        pnCatLeft.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("Mã bàn:");

        tfBanIdFind.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel4.setText("Khu vực :");

        btBanSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        btBanSearch.setText("Tìm kiếm");
        jPanel5.add(btBanSearch);

        cbBanKhuVucFind.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Trạng thái:");

        cbBanTrangThaiFind.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang sử dụng", "Chưa sử dụng", "Đang hỏng" }));
        cbBanTrangThaiFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBanTrangThaiFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfBanIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbBanTrangThaiFind, 0, 154, Short.MAX_VALUE))
                            .addComponent(cbBanKhuVucFind, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfBanIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBanTrangThaiFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbBanKhuVucFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbBanKhuVucFind, cbBanTrangThaiFind, tfBanIdFind});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnCatLeft.add(jPanel2, java.awt.BorderLayout.SOUTH);

        add(pnCatLeft, java.awt.BorderLayout.LINE_START);

        pnCatRight.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N

        tbBan.setAutoCreateRowSorter(true);
        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbBan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbBanMousePressed(evt);
            }
        });
        tbBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbBanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbBan);

        javax.swing.GroupLayout pnCatRightLayout = new javax.swing.GroupLayout(pnCatRight);
        pnCatRight.setLayout(pnCatRightLayout);
        pnCatRightLayout.setHorizontalGroup(
            pnCatRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCatRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCatRightLayout.setVerticalGroup(
            pnCatRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCatRightLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnCatRight, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBanKeyReleased
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbBanKeyReleased

    private void tbBanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMousePressed
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbBanMousePressed

    private void cbBanTrangThaiFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBanTrangThaiFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBanTrangThaiFindActionPerformed

    private void cbBanTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBanTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBanTrangThaiActionPerformed

    private void btBanNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBanNhapLaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btBanNhapLaiActionPerformed
    public void setForm() {
     crow=tbBan.getSelectedRow();
        
     KhuVuc kv=(KhuVuc)tbBan.getValueAt(crow, 1);
        System.out.println(kv.getTen_kv());
       if(kv.getTen_kv()==null){
           loadComboBox(null, cbBanKhuVuc, false);
       }else{
        loadComboBox(kv , cbBanKhuVuc, false);
       }
        loadTrangThaiComboBox(tbBan.getValueAt(crow,2).toString(), cbBanTrangThai);
        tfBanId.setText( tbBan.getValueAt(crow,0).toString());
    }
  

    public void resetForm() {
       loadComboBox(null , cbBanKhuVuc, false);
        loadTrangThaiComboBox(null, cbBanTrangThai);
        tfBanId.setText("");
        tbBan.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBanNhapLai;
    private javax.swing.JButton btBanSearch;
    private javax.swing.JButton btBanSua;
    private javax.swing.JButton btBanThem;
    private javax.swing.JButton btBanXoa;
    private javax.swing.JComboBox cbBanKhuVuc;
    private javax.swing.JComboBox cbBanKhuVucFind;
    private javax.swing.JComboBox cbBanTrangThai;
    private javax.swing.JComboBox cbBanTrangThaiFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnCatLeft;
    private javax.swing.JPanel pnCatRight;
    private javax.swing.JTable tbBan;
    private javax.swing.JTextField tfBanId;
    private javax.swing.JTextField tfBanIdFind;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btBanThem){
          rowCount=tbBan.getRowCount();
          int id=((KhuVuc) cbBanKhuVuc.getSelectedItem()).getId_kv();
          String tt=cbBanTrangThai.getSelectedItem().toString();
          Ban ban=new Ban(0, id,tt);
          if(controller.add(ban)>0){
          loadTable(null);
          tbBan.setRowSelectionInterval(rowCount,rowCount);
          resetForm();
          JOptionPane.showMessageDialog(null,"Thêm thành công");
          return;
          }
      }
      if(e.getSource()==btBanXoa){
          rowCount=tbBan.getRowCount();
          int id=0;
          crow=tbBan.getSelectedRow();
          if(crow>=0){
              id=Integer.parseInt( tfBanId.getText());
          }
          Ban ban=new Ban(id, 0,"");
          if(controller.delete(ban)>0){
          loadTable(null);
          resetForm();
          JOptionPane.showMessageDialog(null,"Xóa thành công");
          return;
          }
      }
      if(e.getSource()==btBanNhapLai){
          resetForm();
      }
       if(e.getSource()==btBanSua){
          rowCount=tbBan.getRowCount();
          int id=0;
          crow=tbBan.getSelectedRow();
          if(crow>=0){
              id=Integer.parseInt( tfBanId.getText());
          }
          Ban ban=new Ban(id,((KhuVuc)cbBanKhuVuc.getSelectedItem()).getId_kv(),  cbBanTrangThai.getSelectedItem().toString());
          if(controller.edit(ban)>0){
          loadTable(null);
          resetForm();
          JOptionPane.showMessageDialog(null,"Sửa thành công");
          return;
          }
      }
       if(e.getSource()==btBanSearch){
           int id=0;
           if(!"".equals(tfBanIdFind.getText())){
               try{
                   id=Integer.parseInt(tfBanIdFind.getText());
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null,"Vui lòng nhập vào id là số");
               
               }
           }
           Ban ban=new Ban(id,((KhuVuc)cbBanKhuVucFind.getSelectedItem()).getId_kv(),cbBanTrangThaiFind.getSelectedItem().toString());
           System.out.println(id+" "+((KhuVuc)cbBanKhuVucFind.getSelectedItem()).getId_kv());
           loadTable(ban);
           resetForm();
       }
    }
}