/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view1;

import bean.ChucVu;
import bean.KhuVuc;
import controller.ControllerChucVu;
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
public class PnNVChucVu extends javax.swing.JPanel implements ActionListener {

    private DefaultTableModel model;
    private int crow;
    private int rowCount = 0;
    private String lKT = "";
    private controller.ControllerChucVu controller;
    public PnNVChucVu() {
        initComponents();
        controller=new ControllerChucVu();
        crow=-1;
        //set action
        btUserThem.addActionListener(this);
        btUserSua.addActionListener(this);
        btUserXoa.addActionListener(this);
        btUserNhapLai.addActionListener(this);
        btUserSearch.addActionListener(this);
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

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

        };
        loadTable( null);
     ( (JComponent)  tbChucVu.getDefaultRenderer(Boolean.class)).setOpaque(true);

    }

    public void loadTable(ChucVu
            cv) {
        controller.loadTable(tbChucVu, model,cv);
        rowCount=tbChucVu.getRowCount();
               
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
        tfUserId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfUserUsername = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btUserThem = new javax.swing.JButton();
        btUserSua = new javax.swing.JButton();
        btUserNhapLai = new javax.swing.JButton();
        btUserXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfUserIdFind = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfUsernameFind = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btUserSearch = new javax.swing.JButton();
        pnCatRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChucVu = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        pnCatLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCatLeft.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Id Chức vụ :");

        tfUserId.setEnabled(false);
        tfUserId.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel2.setText("Tên chức vụ:");

        tfUserUsername.setPreferredSize(new java.awt.Dimension(6, 32));

        btUserThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btUserThem.setText("Thêm");
        jPanel3.add(btUserThem);

        btUserSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btUserSua.setText("Sửa");
        btUserSua.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btUserSua);

        btUserNhapLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.gif"))); // NOI18N
        btUserNhapLai.setText("Nhập lại");
        btUserNhapLai.setPreferredSize(new java.awt.Dimension(95, 25));
        btUserNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserNhapLaiActionPerformed(evt);
            }
        });
        jPanel3.add(btUserNhapLai);

        btUserXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.gif"))); // NOI18N
        btUserXoa.setText("Xóa");
        btUserXoa.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel3.add(btUserXoa);

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
                            .addComponent(tfUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUserUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfUserUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pnCatLeft.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("ID Chức vụ :");

        tfUserIdFind.setPreferredSize(new java.awt.Dimension(6, 32));

        jLabel4.setText("Tên chức vụ :");

        tfUsernameFind.setPreferredSize(new java.awt.Dimension(6, 26));

        btUserSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        btUserSearch.setText("Tìm kiếm");
        jPanel5.add(btUserSearch);

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
                            .addComponent(tfUsernameFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tfUserIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUserIdFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfUsernameFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfUserIdFind, tfUsernameFind});

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

        tbChucVu.setAutoCreateRowSorter(true);
        tbChucVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbChucVu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbChucVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbChucVuMousePressed(evt);
            }
        });
        tbChucVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbChucVuKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbChucVu);
        if (tbChucVu.getColumnModel().getColumnCount() > 0) {
            tbChucVu.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tbChucVu.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tbChucVu.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tbChucVu.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

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

    private void tbChucVuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbChucVuKeyReleased
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbChucVuKeyReleased

    private void tbChucVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChucVuMousePressed
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbChucVuMousePressed

    private void btUserNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserNhapLaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btUserNhapLaiActionPerformed
    public void setForm() {
        crow=tbChucVu.getSelectedRow();
        tfUserId.setText(tbChucVu.getValueAt(crow, 0).toString());
        tfUserUsername.setText(tbChucVu.getValueAt(crow,1).toString());
    }

    public void resetForm() {
      tfUserId.setText("");
      tfUserUsername.setText("");
      tbChucVu.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUserNhapLai;
    private javax.swing.JButton btUserSearch;
    private javax.swing.JButton btUserSua;
    private javax.swing.JButton btUserThem;
    private javax.swing.JButton btUserXoa;
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
    private javax.swing.JTable tbChucVu;
    private javax.swing.JTextField tfUserId;
    private javax.swing.JTextField tfUserIdFind;
    private javax.swing.JTextField tfUserUsername;
    private javax.swing.JTextField tfUsernameFind;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btUserThem){
       rowCount=tbChucVu.getRowCount();
          ChucVu cv=new ChucVu(0, tfUserUsername.getText());
          if(controller.add(cv)>0){
          loadTable(null);
          //tbChucVu.setRowSelectionInterval(rowCount,rowCount);
          JOptionPane.showMessageDialog(null,"Thêm thành công");
          return;
          }
      }
      if(e.getSource()==btUserXoa){
         
          int id=0;
          if(crow>=0){
              id=Integer.parseInt(tfUserId.getText());
          }
         ChucVu cv=new ChucVu(id,"");
          if(controller.delete(cv)>0){
                 loadTable(null);
                 resetForm();
          JOptionPane.showMessageDialog(null,"Xóa thành công");
         
          }
      }
      if(e.getSource()==btUserNhapLai){
          resetForm();
      }
      if(e.getSource()==btUserSua){
       crow=tbChucVu.getSelectedRow();
          System.out.println(crow);
          int id=0;
          if(crow>=0){
              id=Integer.parseInt(tfUserId.getText());
          }
          ChucVu cv=new ChucVu(id,tfUserUsername.getText());
           if(controller.edit(cv)>0){
                 loadTable(null);
                 tbChucVu.setRowSelectionInterval(crow,crow);
                 resetForm();
          JOptionPane.showMessageDialog(null,"Sửa thành công");
         
          }
      }
      if(e.getSource()==btUserSearch){
          int id=0;
          if(!"".equals(tfUserIdFind.getText())){
              try{
              id=Integer.parseInt(tfUserIdFind.getText());
              }catch(NumberFormatException ex){
                  JOptionPane.showMessageDialog(null, "Vui lòng nhập vào Id là số");
              }
          }
           ChucVu cv=new ChucVu(id,tfUsernameFind.getText());
           loadTable(cv);
           resetForm();
      }
    }
}
