/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view1;

import bean.KhuVuc;
import controller.ControllerKhuVuc;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import library.LibraryDimension;

/**
 *
 * @author MinhHuyHo
 */
public class PnTSKhuVuc extends javax.swing.JPanel implements ActionListener {

    private DefaultTableModel model;
    private int crow;
    private int rowCount = 0;
    private controller.ControllerKhuVuc controller;

    public PnTSKhuVuc() {
        initComponents();
        btKVThem.addActionListener(this);
        btKVSua.addActionListener(this);
        btKVXoa.addActionListener(this);
        btKVNhapLai.addActionListener(this);
        btKVSearch.addActionListener(this);
        crow=-1;
        rowCount=tbKhuVuc.getSelectedRowCount();
        controller=new ControllerKhuVuc();
        //set split pane
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnCatLeft, pnCatRight);
        sp.setOneTouchExpandable(true);
        add(sp);
//        pnCatLeft.setMinimumSize(new Dimension(LibraryDimension.PANEL_LEFT_WIDTH, pnCatLeft.getSize().height));
        model = new DefaultTableModel() {
       
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
              @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }

        };
        loadTable(null);
    ( (JComponent)  tbKhuVuc.getDefaultRenderer(Boolean.class)).setOpaque(true);

    }

    public void loadTable(KhuVuc kv) {
        controller.loadTable(tbKhuVuc, model,kv);
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
        tfKVId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfKVTen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btKVThem = new javax.swing.JButton();
        btKVSua = new javax.swing.JButton();
        btKVNhapLai = new javax.swing.JButton();
        btKVXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfKVIdFind = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfKVTenFind = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btKVSearch = new javax.swing.JButton();
        pnCatRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhuVuc = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnCatLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCatLeft.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Id Khu vực :");

        tfKVId.setEnabled(false);
        tfKVId.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel2.setText("Tên khu vực:");

        tfKVTen.setPreferredSize(new java.awt.Dimension(6, 32));

        btKVThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKVThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btKVThem.setText("Thêm");
        jPanel3.add(btKVThem);

        btKVSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKVSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btKVSua.setText("Sửa");
        btKVSua.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btKVSua);

        btKVNhapLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKVNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.gif"))); // NOI18N
        btKVNhapLai.setText("Nhập lại");
        btKVNhapLai.setPreferredSize(new java.awt.Dimension(95, 25));
        btKVNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKVNhapLaiActionPerformed(evt);
            }
        });
        jPanel3.add(btKVNhapLai);

        btKVXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btKVXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.gif"))); // NOI18N
        btKVXoa.setText("Xóa");
        btKVXoa.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btKVXoa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfKVId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfKVTen, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfKVId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfKVTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pnCatLeft.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("ID khu vực :");

        tfKVIdFind.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel4.setText("Tên khu vực :");

        tfKVTenFind.setPreferredSize(new java.awt.Dimension(6, 26));

        btKVSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        btKVSearch.setText("Tìm kiếm");
        jPanel5.add(btKVSearch);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfKVTenFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfKVIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfKVIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfKVTenFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfKVIdFind, tfKVTenFind});

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
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnCatLeft.add(jPanel2, java.awt.BorderLayout.SOUTH);

        add(pnCatLeft, java.awt.BorderLayout.LINE_START);

        pnCatRight.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N

        tbKhuVuc.setAutoCreateRowSorter(true);
        tbKhuVuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbKhuVuc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbKhuVuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhuVucMousePressed(evt);
            }
        });
        tbKhuVuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbKhuVucKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhuVuc);

        javax.swing.GroupLayout pnCatRightLayout = new javax.swing.GroupLayout(pnCatRight);
        pnCatRight.setLayout(pnCatRightLayout);
        pnCatRightLayout.setHorizontalGroup(
            pnCatRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCatRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnCatRightLayout.setVerticalGroup(
            pnCatRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCatRightLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnCatRight, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbKhuVucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbKhuVucKeyReleased
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbKhuVucKeyReleased

    private void tbKhuVucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuVucMousePressed
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbKhuVucMousePressed

    private void btKVNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKVNhapLaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btKVNhapLaiActionPerformed
    public void setForm() {
        crow=tbKhuVuc.getSelectedRow();
        tfKVId.setText(tbKhuVuc.getValueAt(crow, 0).toString());
        tfKVTen.setText(tbKhuVuc.getValueAt(crow,1).toString());
    }

    public void resetForm() {
      tfKVId.setText("");
      tfKVTen.setText("");
      tbKhuVuc.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKVNhapLai;
    private javax.swing.JButton btKVSearch;
    private javax.swing.JButton btKVSua;
    private javax.swing.JButton btKVThem;
    private javax.swing.JButton btKVXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnCatLeft;
    private javax.swing.JPanel pnCatRight;
    private javax.swing.JTable tbKhuVuc;
    private javax.swing.JTextField tfKVId;
    private javax.swing.JTextField tfKVIdFind;
    private javax.swing.JTextField tfKVTen;
    private javax.swing.JTextField tfKVTenFind;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource()==btKVThem){
       rowCount=tbKhuVuc.getRowCount();
          KhuVuc kv=new KhuVuc(0, tfKVTen.getText());
          if(controller.add(kv)>0){
          loadTable(null);
          tbKhuVuc.setRowSelectionInterval(rowCount,rowCount);
          JOptionPane.showMessageDialog(null,"Thêm thành công");
          return;
          }
      }
      if(e.getSource()==btKVXoa){
         
          int id=0;
          if(crow>=0){
              id=Integer.parseInt(tfKVId.getText());
          }
          KhuVuc kv=new KhuVuc(id,"");
          if(controller.delete(kv)>0){
                 loadTable(null);
                 resetForm();
          JOptionPane.showMessageDialog(null,"Xóa thành công");
         
          }
      }
      if(e.getSource()==btKVNhapLai){
          resetForm();
      }
      if(e.getSource()==btKVSua){
       crow=tbKhuVuc.getSelectedRow();
          System.out.println(crow);
          int id=0;
          if(crow>=0){
              id=Integer.parseInt(tfKVId.getText());
          }
          KhuVuc kv=new KhuVuc(id,tfKVTen.getText());
           if(controller.edit(kv)>0){
                 loadTable(null);
                 tbKhuVuc.setRowSelectionInterval(crow,crow);
                 resetForm();
          JOptionPane.showMessageDialog(null,"Sửa thành công");
         
          }
      }
      if(e.getSource()==btKVSearch){
         
          int id=0;
          if(!"".equals(tfKVIdFind.getText())){
              try{
              id=Integer.parseInt(tfKVIdFind.getText());
              }catch(NumberFormatException ex){
                  JOptionPane.showMessageDialog(null, "Vui lòng nhập vào Id là số");
              }
          }
           KhuVuc kv=new KhuVuc(id,tfKVTenFind.getText());
           loadTable(kv);
           resetForm();
      }
    }
}