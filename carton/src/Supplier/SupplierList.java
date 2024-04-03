package Supplier;

import databaseconnection.DataBaseConnection;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author home
 */
public class SupplierList extends javax.swing.JPanel {

    private AddSupplier addSupplier;
    private Timer timer;

    public SupplierList() throws Exception {
        initComponents();
        setOpaque(false);
        populateTable();
        addSupplier = new AddSupplier();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                delete(row);
            }
        };
        suppTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        suppTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));

        timer = new Timer(1000, (e) -> {
            try {
                populateTable();
            } catch (Exception ex) {
                Logger.getLogger(SupplierList.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        timer.start();

    }

    private PreparedStatement p;

    private void populateTable() throws Exception {
        try {

            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "SELECT * FROM supplier";
            PreparedStatement p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet rs = p.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) suppTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector<Object> v = new Vector<>();
                for (int i = 0; i <= c; i++) {
                    v.add(rs.getString("name"));
                    v.add(rs.getString("location"));
                    v.add(rs.getString("contactno"));
                    v.add(rs.getString("email"));
                }
                model.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.close();
            }

        }
    }

    public void delete(int row) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete the record?", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                DataBaseConnection.getInstance().ConnectToDatabase();
                DefaultTableModel model = (DefaultTableModel) suppTable.getModel();
                String name = model.getValueAt(row, 1).toString(); // Assuming name is in the first column (index 0)

                String sql = "DELETE FROM supplier WHERE name = ?";
                PreparedStatement p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
                p.setString(1, name); // Set the parameter value
                int rowsDeleted = p.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    model.removeRow(row); // Remove the row from the table view
                } else {
                    JOptionPane.showMessageDialog(null, "Record not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        suppTable = new javax.swing.JTable();
        searchFld = new javax.swing.JTextField();
        addsup = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        suppTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Location", "Contact Number", "Email", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppTable.setRowHeight(40);
        jScrollPane.setViewportView(suppTable);
        if (suppTable.getColumnModel().getColumnCount() > 0) {
            suppTable.getColumnModel().getColumn(4).setMinWidth(30);
            suppTable.getColumnModel().getColumn(4).setPreferredWidth(30);
            suppTable.getColumnModel().getColumn(4).setMaxWidth(30);
        }

        searchFld.setText("Search here");
        searchFld.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFldFocusLost(evt);
            }
        });
        searchFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFldKeyReleased(evt);
            }
        });

        addsup.setText("Add Supplier");
        addsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addsup)
                        .addGap(0, 437, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addsup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFldKeyPressed

    }//GEN-LAST:event_searchFldKeyPressed

    private void searchFldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFldFocusGained
        if (searchFld.getText().equals("Search here")) {
            searchFld.setText("");
            searchFld.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchFldFocusGained

    private void searchFldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFldFocusLost
        if (searchFld.getText().equals("")) {
            searchFld.setText("Search here");
            searchFld.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_searchFldFocusLost

    private void searchFldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFldKeyReleased
        DefaultTableModel table = (DefaultTableModel) suppTable.getModel();
        TableRowSorter<DefaultTableModel> tbl = new TableRowSorter<>(table);
        suppTable.setRowSorter(tbl);
        tbl.setRowFilter(RowFilter.regexFilter(searchFld.getText()));
    }//GEN-LAST:event_searchFldKeyReleased

    private void addsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsupActionPerformed
        GlassPanePopup.showPopup(addSupplier);
    }//GEN-LAST:event_addsupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addsup;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField searchFld;
    private javax.swing.JTable suppTable;
    // End of variables declaration//GEN-END:variables
}
