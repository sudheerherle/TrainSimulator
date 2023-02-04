/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsimulator.tableutils;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author I14746
 */
public class tableModel extends DefaultTableModel {

    public tableModel() {
    }
     @Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
}
