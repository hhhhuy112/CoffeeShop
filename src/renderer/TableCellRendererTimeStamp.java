/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author homin
 */
public class TableCellRendererTimeStamp extends DefaultTableCellRenderer {
    SimpleDateFormat sdf;
    public TableCellRendererTimeStamp(){
        sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    @Override
    protected void setValue(Object value) {
         super.setValue(sdf.format(value)); 
    }
    
}
