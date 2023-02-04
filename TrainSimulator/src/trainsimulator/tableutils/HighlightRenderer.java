/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trainsimulator.tableutils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author I14746
 */
public class HighlightRenderer extends DefaultTableCellRenderer {


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // everything as usual
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // added behavior
        if(row == table.getSelectedRow() && column == table.getSelectedColumn()) {

            // this will customize that kind of border that will be use to highlight a row
            setBorder(null);
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        }

        return this;
    }

}
