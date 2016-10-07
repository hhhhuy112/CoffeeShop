/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Hi
 */
public class TableCellRendererHeaderColumn extends MouseAdapter{
         private JTable table;
     
    public TableCellRendererHeaderColumn(JTable table) {
        this.table = table;
    }
     
    public void mouseClicked(MouseEvent event) {
        Point point = event.getPoint();
        int column = table.columnAtPoint(point);
         setRowsColor();
         
        // do your real thing here...
    }
    //Hàm set color
     public void setRowsColor() {
        ArrayList<Integer> alRowsMax10 = new ArrayList();
        ArrayList<Integer> alRowsMin10 = new ArrayList();
        ArrayList<Integer> alRowsActive = new ArrayList();

        int rowCount = table.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int sl = (int) table.getValueAt(i, 3);
            if (sl <= 10) {
                alRowsMax10.add(i);
            }
            if (sl > 10) {
                alRowsMin10.add(i);
            }

        }
        for (int j = 0; j < table.getColumnCount(); j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(new TableCellRendererColor(alRowsMax10, alRowsMin10));
        }
        
    }
}
