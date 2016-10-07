/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author homin
 */
public class TableCellRendererDate extends Date{
    SimpleDateFormat sdf;
    public TableCellRendererDate(){
        sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
       
    
    
    
}
