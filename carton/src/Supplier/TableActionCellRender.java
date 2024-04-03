package Supplier;




import Supplier.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean b1n, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, o, b1n, hasFocus, row, column); 
        
        PanelAction action = new PanelAction();
        if(b1n == false && row % 2 == 0){
            action.setBackground(Color.WHITE);
        }else{
            action.setBackground(com.getBackground() );
        }
        action.setBackground(com.getBackground());
        return action;
    }
   
            
}
   

