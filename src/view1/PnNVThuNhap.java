/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view1;

import bean.Ban;
import bean.ChucVu;
import bean.HoaDon;
import bean.KhuVuc;
import bean.LoaiThucUong;
import bean.NhanVien;
import bean.ThuNhap;
import controller.ControllerBan;
import controller.ControllerHoaDon;
import controller.ControllerKhuVuc;
import controller.ControllerLoaiThucUong;
import controller.ControllerNhanVien;
import controller.ControllerThuNhap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import library.LibraryDimension;
import model.ModelNhanVienComboBox;
import renderer.TableCellRendererColor;
import renderer.TableCellRendererHeaderColumn;

/**
 *
 * @author Tran Van Son
 */
public class PnNVThuNhap extends javax.swing.JPanel implements ActionListener {

    private controller.ControllerBan controllerBan;
    private controller.ControllerKhuVuc controllerKhuVuc;
    private controller.ControllerLoaiThucUong controllerLoaiThucUong;
    private controller.ControllerHoaDon controllerHoaDon;
    private controller.ControllerThuNhap controllerThuNhap;
    private controller.ControllerNhanVien controllerNhanVien;
    private JButton btBan;
    private JButton btCurenttly;
    private DefaultTableModel modelLTU;
    private DefaultTableModel modelLTUHD;
    private JTableHeader header;
    private int crow;
    private int crowXoa;
    private boolean ktBT = false;
    private ArrayList<LoaiThucUong> alLTUSelected;
    private HoaDon cHD;
    private int slBd = 0;
    private int idBan = -1;

    /**
     * Creates new form PnCat
     */
    public PnNVThuNhap() {
        initComponents();
        btTNThem.addActionListener(this);
        btThuNhapLuu.addActionListener(this);
        btThuNhapXoa.addActionListener(this);
        btThuNhapThanhToan.addActionListener(this);
        //
        crow = -1;
        crowXoa = -1;
        controllerBan = new ControllerBan();
        controllerKhuVuc = new ControllerKhuVuc();
        controllerLoaiThucUong = new ControllerLoaiThucUong();
        controllerThuNhap = new ControllerThuNhap();
        controllerHoaDon = new ControllerHoaDon();
        controllerNhanVien = new ControllerNhanVien();
        tpKhuVuc.removeAll();
        alLTUSelected = new ArrayList<LoaiThucUong>();
        modelLTU = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0 || columnIndex == 3) {
                    return Integer.class;
                }
                if (columnIndex == 2) {
                    return Double.class;
                }

                return super.getColumnClass(columnIndex);
            }

        };
        modelLTUHD = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0 || columnIndex == 3) {
                    return Integer.class;
                }
                if (columnIndex == 2 || columnIndex == 5) {
                    return Double.class;
                }

                return super.getColumnClass(columnIndex);
            }

        };

        setTabPane(null);
        loadTableLTU();
        loadTableLTU1(null);
        loadCombobox(null);
        ((JComponent) tbLTU.getDefaultRenderer(Boolean.class)).setOpaque(true);
        //sự kiện header column
        header = tbLTU.getTableHeader();
        header.addMouseListener(new TableCellRendererHeaderColumn(tbLTU));
    }

    public void loadCombobox(NhanVien nv) {
        cbThuNhapNhanVien.setModel(new ModelNhanVienComboBox(nv));
    }

    public void loadTableLTU() {
           String ten =tfLTUTenTimKiem.getText();
        controllerLoaiThucUong.loadTable1(tbLTU, modelLTU, new LoaiThucUong(0, ten, -1, -1, -1, -1, "", "", true), true);
        setRowsColor();
    }

    public void loadTableLTU1(ArrayList<LoaiThucUong> alLTU) {

        controllerLoaiThucUong.loadTable1(tbLTUHD, modelLTUHD, alLTU);

    }

    public void setRowsColor() {
        ArrayList<Integer> alRowsMax10 = new ArrayList();
        ArrayList<Integer> alRowsMin10 = new ArrayList();
        ArrayList<Integer> alRowsActive = new ArrayList();

        int rowCount = tbLTU.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int sl = (int) tbLTU.getValueAt(i, 3);
            if (sl <= 10) {
                alRowsMax10.add(i);
            }
            if (sl > 10) {
                alRowsMin10.add(i);
            }

        }
        for (int j = 0; j < tbLTU.getColumnCount(); j++) {
            tbLTU.getColumnModel().getColumn(j).setCellRenderer(new TableCellRendererColor(alRowsMax10, alRowsMin10));
        }
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        pnBan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        tpKhuVuc = new javax.swing.JTabbedPane();
        jLabel3 = new javax.swing.JLabel();
        pnCatLeft = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBanTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btThuNhapThanhToan = new javax.swing.JButton();
        btThuNhapLuu = new javax.swing.JButton();
        btThuNhapXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        spinThuNhapTimeVao = new javax.swing.JSpinner();
        cbThuNhapNhanVien = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfKhuVucName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLTUHD = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        spinTongTien = new javax.swing.JSpinner();
        pnCatRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLTU = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btTNThem = new javax.swing.JButton();
        btThuNhapNhaplai = new javax.swing.JButton();
        btThuNhapTimKiem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfLTUTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        spinLTUGia = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        spinLTUSoLuong = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        tfLTUDonVI = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfLTUTenTimKiem = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        pnBan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bàn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnBan.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        pnBan.add(jPanel7, java.awt.BorderLayout.CENTER);

        jLabel3.setText("jLabel3");
        tpKhuVuc.addTab("Sân vườn", jLabel3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pnBan.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        add(pnBan, java.awt.BorderLayout.WEST);

        pnCatLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hóa đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCatLeft.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Bàn:");

        tfBanTen.setEnabled(false);
        tfBanTen.setPreferredSize(new java.awt.Dimension(6, 26));
        tfBanTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBanTenActionPerformed(evt);
            }
        });

        jLabel2.setText("Giờ vào:");

        btThuNhapThanhToan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThuNhapThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btThuNhapThanhToan.setText("Thanh toán");
        btThuNhapThanhToan.setEnabled(false);
        btThuNhapThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuNhapThanhToanActionPerformed(evt);
            }
        });
        jPanel3.add(btThuNhapThanhToan);

        btThuNhapLuu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThuNhapLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.gif"))); // NOI18N
        btThuNhapLuu.setText("Lưu");
        btThuNhapLuu.setEnabled(false);
        btThuNhapLuu.setPreferredSize(new java.awt.Dimension(95, 25));
        btThuNhapLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuNhapLuuActionPerformed(evt);
            }
        });
        jPanel3.add(btThuNhapLuu);

        btThuNhapXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThuNhapXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.gif"))); // NOI18N
        btThuNhapXoa.setText("Xóa");
        btThuNhapXoa.setEnabled(false);
        btThuNhapXoa.setPreferredSize(new java.awt.Dimension(85, 25));
        btThuNhapXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuNhapXoaActionPerformed(evt);
            }
        });
        jPanel3.add(btThuNhapXoa);

        jLabel7.setText("Nhân viên :");

        spinThuNhapTimeVao.setModel(new javax.swing.SpinnerDateModel());
        spinThuNhapTimeVao.setEditor(new javax.swing.JSpinner.DateEditor(spinThuNhapTimeVao, "dd/MM/yyyy hh:mm a"));

        cbThuNhapNhanVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbThuNhapNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThuNhapNhanVienActionPerformed(evt);
            }
        });

        jLabel4.setText("Khu vực:");

        tfKhuVucName.setEnabled(false);
        tfKhuVucName.setPreferredSize(new java.awt.Dimension(6, 26));
        tfKhuVucName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKhuVucNameActionPerformed(evt);
            }
        });

        tbLTUHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tên", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbLTUHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbLTUHDMousePressed(evt);
            }
        });
        tbLTUHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbLTUHDKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbLTUHD);

        jLabel5.setText("Tổng tiền:");

        spinTongTien.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        spinTongTien.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinTongTien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(cbThuNhapNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)
                                .addComponent(spinThuNhapTimeVao, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfBanTen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfKhuVucName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spinThuNhapTimeVao, tfKhuVucName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBanTen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfKhuVucName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinThuNhapTimeVao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbThuNhapNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, spinThuNhapTimeVao, tfBanTen, tfKhuVucName});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, spinTongTien});

        pnCatLeft.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(pnCatLeft, java.awt.BorderLayout.EAST);

        pnCatRight.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N
        pnCatRight.setLayout(new java.awt.BorderLayout());

        tbLTU.setAutoCreateRowSorter(true);
        tbLTU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "5l", "6", "7"
            }
        ));
        tbLTU.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbLTU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbLTUMousePressed(evt);
            }
        });
        tbLTU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbLTUKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbLTU);

        pnCatRight.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new java.awt.GridLayout(3, 1, 0, 8));

        btTNThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btTNThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btTNThem.setText("Thêm");
        btTNThem.setPreferredSize(new java.awt.Dimension(130, 23));
        btTNThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTNThemActionPerformed(evt);
            }
        });
        jPanel5.add(btTNThem);

        btThuNhapNhaplai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThuNhapNhaplai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.gif"))); // NOI18N
        btThuNhapNhaplai.setText("Nhập lại");
        btThuNhapNhaplai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuNhapNhaplaiActionPerformed(evt);
            }
        });
        jPanel5.add(btThuNhapNhaplai);

        btThuNhapTimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThuNhapTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        btThuNhapTimKiem.setText("Tìm kiếm");
        btThuNhapTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuNhapTimKiemActionPerformed(evt);
            }
        });
        jPanel5.add(btThuNhapTimKiem);

        jPanel2.add(jPanel5, java.awt.BorderLayout.EAST);

        jLabel11.setText("Tên thức uống:");

        tfLTUTen.setEnabled(false);
        tfLTUTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLTUTenActionPerformed(evt);
            }
        });

        jLabel16.setText("Giá :");

        spinLTUGia.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(5.0d)));
        spinLTUGia.setEnabled(false);

        jLabel18.setText("Số lượng:");

        spinLTUSoLuong.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel19.setText("Đơn vị:");

        tfLTUDonVI.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinLTUSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinLTUGia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLTUTen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLTUDonVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spinLTUGia, tfLTUTen});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spinLTUSoLuong, tfLTUDonVI});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfLTUTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(spinLTUGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(spinLTUSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLTUDonVI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel16, jLabel18, jLabel19, spinLTUGia, spinLTUSoLuong, tfLTUDonVI, tfLTUTen});

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel6.setText("Tên tìm kiếm :");

        tfLTUTenTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLTUTenTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tfLTUTenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfLTUTenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pnCatRight.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(pnCatRight, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbLTUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLTUMousePressed
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbLTUMousePressed

    private void tbLTUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbLTUKeyReleased
        // TODO add your handling code here:
        setForm();
    }//GEN-LAST:event_tbLTUKeyReleased

    private void btThuNhapLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuNhapLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btThuNhapLuuActionPerformed

    private void btThuNhapThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuNhapThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btThuNhapThanhToanActionPerformed

    private void btTNThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTNThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btTNThemActionPerformed

    private void tfKhuVucNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKhuVucNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKhuVucNameActionPerformed

    private void tfBanTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBanTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBanTenActionPerformed

    private void cbThuNhapNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThuNhapNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThuNhapNhanVienActionPerformed

    private void tfLTUTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLTUTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLTUTenActionPerformed

    private void btThuNhapNhaplaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuNhapNhaplaiActionPerformed
        // TODO add your handling code here:
        tfLTUTen.setText("");
        spinLTUGia.setValue(0);
        spinLTUSoLuong.setValue(1);
        tfLTUDonVI.setText("");
        tbLTU.clearSelection();
    }//GEN-LAST:event_btThuNhapNhaplaiActionPerformed

    private void btThuNhapXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuNhapXoaActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btThuNhapXoaActionPerformed

    private void tbLTUHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbLTUHDKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tbLTUHDKeyReleased

    private void tbLTUHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLTUHDMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbLTUHDMousePressed

    private void tfLTUTenTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLTUTenTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLTUTenTimKiemActionPerformed

    private void btThuNhapTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuNhapTimKiemActionPerformed
        // TODO add your handling code here:
        LoaiThucUong ltu=new LoaiThucUong(0, TOOL_TIP_TEXT_KEY, 0,0,"", "",true);
        loadTableLTU();
    }//GEN-LAST:event_btThuNhapTimKiemActionPerformed
    public void setForm() {
        crow = tbLTU.getSelectedRow();
        tfLTUTen.setText(tbLTU.getValueAt(crow, 1).toString());
        spinLTUGia.setValue(tbLTU.getValueAt(crow, 2));
        tfLTUDonVI.setText((tbLTU.getValueAt(crow, 4)).toString());
    }

    public void resetForm() {
        tfLTUTen.setText("");
        tfLTUDonVI.setText("");
        tfLTUTen.setText("");
        tfBanTen.setText("");
        tfKhuVucName.setText("");
        spinThuNhapTimeVao.setValue(new Date());
        loadCombobox(null);
        spinTongTien.setValue(0);
        tbLTU.clearSelection();
        loadTableLTU1(null);
    }

    public void setTabPane(Ban ban) {

        ArrayList<KhuVuc> alKhuVuc = controllerKhuVuc.getListKhuVuc();

        for (int i = 0; i < alKhuVuc.size(); i++) {
            JPanel p1 = new JPanel();

            ArrayList<Ban> alBan = controllerBan.getListBan(alKhuVuc.get(i).getId_kv());
            for (Ban b : alBan) {
                btBan = createBan(b, alKhuVuc.get(i));
                p1.add(btBan);
                
            }

            tpKhuVuc.addTab(alKhuVuc.get(i).getTen_kv(), p1);
           
        }
    }

    public JButton createBan(Ban ban, KhuVuc kv) {

        btBan = new javax.swing.JButton();

        btBan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btCurenttly = btBan;
                btThuNhapLuu.setEnabled(true);
                btThuNhapXoa.setEnabled(true);
                tfBanTen.setText(String.valueOf(ban.getId_ban()));
                tfKhuVucName.setText(kv.getTen_kv());
                if ("Đang sử dụng".equals(ban.getTrangThai())) {
                    spinThuNhapTimeVao.setEnabled(false);
                    ktBT = true;
                    btThuNhapThanhToan.setEnabled(true);
                    HoaDon hd = controllerHoaDon.getHoaDonActiveById_ban(ban.getId_ban());
                    cHD = hd;
                    spinThuNhapTimeVao.setValue(hd.getTimeVao());
                    NhanVien nv = controllerNhanVien.getNhanViemByMaNV(hd.getId_nv());
                    loadCombobox(nv);
                    ArrayList<LoaiThucUong> alItem = controllerThuNhap.getListLoaiThucUongByIdHD(hd.getId_hd());

                    alLTUSelected = alItem;
                    slBd = alItem.size();
                    loadTableLTU1(alItem);
                    setTongTien();
                } else if ("Chưa sử dụng".equals(ban.getTrangThai())) {
                    ktBT = false;
                    spinThuNhapTimeVao.setEnabled(true);
                    btThuNhapThanhToan.setEnabled(false);
                    alLTUSelected = new ArrayList<>();
                    loadTableLTU1(alLTUSelected);
                    loadCombobox(null);
                }
            }
        });
        btBan.setIcon(new ImageIcon(getClass().getResource("/images/ban.png")));
        btBan.setFont(new Font("tahoma", Font.BOLD, 14));
        if ("Chưa sử dụng".equals(ban.getTrangThai())) {
            btBan.setForeground(Color.BLUE);
        }
        if ("Đang sử dụng".equals(ban.getTrangThai())) {
            btBan.setForeground(Color.RED);
        }
        btBan.setText(kv.getTen_kv() + String.valueOf(ban.getId_ban()));
        return btBan;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTNThem;
    private javax.swing.JButton btThuNhapLuu;
    private javax.swing.JButton btThuNhapNhaplai;
    private javax.swing.JButton btThuNhapThanhToan;
    private javax.swing.JButton btThuNhapTimKiem;
    private javax.swing.JButton btThuNhapXoa;
    private javax.swing.JComboBox cbThuNhapNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel pnBan;
    private javax.swing.JPanel pnCatLeft;
    private javax.swing.JPanel pnCatRight;
    private javax.swing.JSpinner spinLTUGia;
    private javax.swing.JSpinner spinLTUSoLuong;
    private javax.swing.JSpinner spinThuNhapTimeVao;
    private javax.swing.JSpinner spinTongTien;
    private javax.swing.JTable tbLTU;
    private javax.swing.JTable tbLTUHD;
    private javax.swing.JTextField tfBanTen;
    private javax.swing.JTextField tfKhuVucName;
    private javax.swing.JTextField tfLTUDonVI;
    private javax.swing.JTextField tfLTUTen;
    private javax.swing.JTextField tfLTUTenTimKiem;
    private javax.swing.JTabbedPane tpKhuVuc;
    // End of variables declaration//GEN-END:variables

    public void ktLoaiThucUong(LoaiThucUong ltu) {
        int ck = 0;
        if (alLTUSelected.size() > 0) {
            for (LoaiThucUong ltu1 : alLTUSelected) {
                if (ltu1.getId_ltu() == ltu.getId_ltu()) {
                    if ((ltu1.getSoLuong_ltu() + ltu.getSoLuong_ltu()) > (int) tbLTU.getValueAt(crow, 3)) {
                        JOptionPane.showMessageDialog(null, "Số lượng không đủ ");
                        return;
                    } else {
                        ltu1.setSoLuong_ltu(ltu1.getSoLuong_ltu() + ltu.getSoLuong_ltu());

                    }
                    ck++;
                }
            }
        }
        if (ck == 0) {
            alLTUSelected.add(ltu);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btTNThem) {
            if(!kt()){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn");
                resetForm();
                return;
            }
            crow = tbLTU.getSelectedRow();
            LoaiThucUong ltu = new LoaiThucUong();
            ltu.setId_ltu((int) tbLTU.getValueAt(crow, 0));
            ltu.setTen_ltu(tbLTU.getValueAt(crow, 1).toString());
            ltu.setGia_ltu((double) tbLTU.getValueAt(crow, 2));
            ltu.setSoLuong_ltu((int) spinLTUSoLuong.getValue());
            if (ltu.getSoLuong_ltu() > (int) tbLTU.getValueAt(crow, 3)) {
                JOptionPane.showMessageDialog(null, "Số lượng không đủ ");
                return;
            } else {
                ltu.setDonVi_ltu(tfLTUDonVI.getText());
                ktLoaiThucUong(ltu);
                loadTableLTU1(alLTUSelected);

                setTongTien();
            }
        }

        if (e.getSource() == btThuNhapLuu) {
            Timestamp timeS = new Timestamp(new Date().getTime());
             if(!kt()){
                resetForm();
                 JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn");
                return;
            }
            if (ktBT == false) {
                HoaDon hd = new HoaDon(0, Integer.parseInt(tfBanTen.getText()), ((NhanVien) cbThuNhapNhanVien.getSelectedItem()).getMa_nv(), timeS, null, (double) spinTongTien.getValue(), true);
                if (controllerHoaDon.add(hd) > 0) {
                    ArrayList<HoaDon> alItem = controllerHoaDon.getListHoaDon();
                    int idHD = 0;
                    if (alItem.size() > 0) {
                        //Lấy id Hóa vừa được thêm 
                        idHD = alItem.get((alItem.size() - 1)).getId_hd();
                    }
                    if (controllerThuNhap.saveTN(alLTUSelected, idHD, false) > 0) {
                        //Sửa thông tin laoij thức uống
                        controllerLoaiThucUong.edit(alLTUSelected);
                        loadTableLTU();
                        //Sửa thông tin bàn
                        Ban ban = controllerBan.getBanById(hd.getId_ban());
                        controllerBan.edit(new Ban(Integer.parseInt(tfBanTen.getText()), ban.getId_kv(), "Đang sử dụng"));
                        tpKhuVuc.removeAll();
                        setTabPane(ban);
                        resetForm();
                        btCurenttly.setForeground(Color.red);
                        btCurenttly.setSelected(true);
                        JOptionPane.showMessageDialog(null, "Lưu thành công");
                        ktBT = true;
                        btThuNhapThanhToan.setEnabled(true);
                    } else {
                        controllerHoaDon.delete(alItem.get((alItem.size() - 1)));
                        JOptionPane.showMessageDialog(null, "Lưu thất bại");
                    }
                }
            } else {
                System.out.println(alLTUSelected + "dđ" + cHD.getId_hd());
                if (controllerThuNhap.saveTN(alLTUSelected, cHD.getId_hd(), true) > 0) {
                    controllerLoaiThucUong.edit(alLTUSelected);
                    loadTableLTU();
                    Ban ban = controllerBan.getBanById(cHD.getId_ban());
                    controllerBan.edit(new Ban(Integer.parseInt(tfBanTen.getText()), ban.getId_kv(), "Đang sử dụng"));
                    btThuNhapThanhToan.setEnabled(true);
                    resetForm();
                    JOptionPane.showMessageDialog(null, "Lưu thành công");

                } else {
                    JOptionPane.showMessageDialog(null, "Lưu thất bại");
                }
            }
        }
        if (e.getSource() == btThuNhapThanhToan) {
            if("".equals(tfBanTen.getText())){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn để thanh toán");
            }
            if(!kt()){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn");
                return;
            }
            HoaDon hd = controllerHoaDon.getHoaDonActiveById_ban(Integer.parseInt(tfBanTen.getText()));
            hd.setTrangThai(false);
            hd.setTimeRa(new Timestamp(new Date().getTime()));
            if (controllerHoaDon.edit(hd) > 0) {
                Ban ban = controllerBan.getBanById(hd.getId_ban());
                controllerBan.edit(new Ban(Integer.parseInt(tfBanTen.getText()), ban.getId_kv(), "Chưa sử dụng"));
               
                tpKhuVuc.removeAll();
                setTabPane(ban);
                resetForm();
                JOptionPane.showMessageDialog(null, " Thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Chưa thành công");
            }
        }
        if (e.getSource() == btThuNhapXoa) {
            System.out.println(String.valueOf(ktBT));
            crowXoa = tbLTUHD.getSelectedRow();
            System.out.println(alLTUSelected);
            System.out.println(crowXoa);
            int id = (int) tbLTUHD.getValueAt(crowXoa, 0);

            for (int i = 0; i < alLTUSelected.size(); i++) {
                if (alLTUSelected.get(i).getId_ltu() == id) {
                    alLTUSelected.remove(i);
                }
            }
            loadTableLTU1(alLTUSelected);
        }

    }

    public void setTongTien() {
        double sumMoney = 0;
        for (int i = 0; i < tbLTUHD.getRowCount(); i++) {
            sumMoney += (double) tbLTUHD.getValueAt(i, 5);
        }
        spinTongTien.setValue(sumMoney);
    }

    public boolean kt() {
        if ("".equals(tfBanTen.getText())) {
            return false;
        }
        return true;
    }
}
