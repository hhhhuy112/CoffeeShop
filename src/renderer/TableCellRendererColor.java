/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import bean.LoaiThucUong;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author homin
 */
public class TableCellRendererColor extends DefaultTableCellRenderer{
    private static final long serialVersionUID = 6703872492730589499L;
    private int ck;
    private ArrayList<Integer> alLTUBySLMax10;
    private ArrayList<Integer> alLTUBySLMin10;
    public TableCellRendererColor(ArrayList<Integer> alLTUBySLMax10,ArrayList<Integer> alLTUBySLMin10){
        this.alLTUBySLMax10=alLTUBySLMax10;
        this.alLTUBySLMin10=alLTUBySLMin10;
        
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
        
       
            for(int i=0;i<alLTUBySLMax10.size();i++){
                if(row==alLTUBySLMax10.get(i)){
                    cellComponent.setBackground(Color.RED);
                }
            }
             for(int i=0;i<alLTUBySLMin10.size();i++){
                if(row==alLTUBySLMin10.get(i)){
                    
                    cellComponent.setBackground(new Color(0, 160, 0));
                }
            }
        
//        if(row%2==0){
//            cellComponent.setBackground(Color.RED);
//             System.out.println(row);
//        }else{
//            cellComponent.setBackground(Color.BLUE);
//        }
//       
        return cellComponent;
    }

      
}
