package Items;

import Supplier.SupplierList;
import com.mysql.cj.jdbc.Blob;
import databaseconnection.DataBaseConnection;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.TableRowSorter;
import raven.glasspanepopup.GlassPanePopup;

public class Items extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private AddItem addItem;
    private Timer timer;
    private testItem tItem;

    public Items() throws Exception {
        initComponents();
          tItem = new testItem();
        populateTable();
        
      
//        timer = new Timer(1000, (e) -> {
//            try {
//                populateTable();
//            } catch (Exception ex) {
//                Logger.getLogger(SupplierList.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        });
//        timer.start();
        addItem = new AddItem(this);
    }

    private PreparedStatement p;

    private void populateTable() throws Exception {
        try {

            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "SELECT * FROM additems";
            PreparedStatement p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet rs = p.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Vector<Object> v = new Vector<>();
                for (int i = 0; i <= c; i++) {
                    Blob blob = (Blob) rs.getBlob("Image");
                    itemTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
                    ImageIcon imageicon = ImageRenderer.blobToImageIcon(blob, 50, 50);
                    v.add(imageicon);
                    v.add(rs.getString("supplier"));
                    v.add(rs.getString("productname"));
                    v.add(rs.getString("productId"));
                    v.add(rs.getString("category"));
                    v.add(rs.getString("quantity"));
                    v.add(rs.getString("cost"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("status"));
                    v.add(rs.getString("date"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        txtfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Supplier", "Product Name", "Product ID", "Category", "Quantity", "Cost", "Price", "Status", "Date Modifiied"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemTable);

        txtfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfieldFocusLost(evt);
            }
        });
        txtfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfieldKeyReleased(evt);
            }
        });

        jButton1.setText("Add Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(89, 89, 89)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfieldKeyReleased
        DefaultTableModel table = (DefaultTableModel) itemTable.getModel();
        TableRowSorter<DefaultTableModel> tbl = new TableRowSorter<>(table);
        itemTable.setRowSorter(tbl);
        tbl.setRowFilter(RowFilter.regexFilter(txtfield.getText()));

    }//GEN-LAST:event_txtfieldKeyReleased

    private void txtfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldFocusGained
        if (txtfield.getText().equals("Search here")) {
            txtfield.setText("");
            txtfield.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtfieldFocusGained

    private void txtfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfieldFocusLost
        if (txtfield.getText().equals("")) {
            txtfield.setText("Search here");
            txtfield.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtfieldFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GlassPanePopup.showPopup(tItem);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtfield;
    // End of variables declaration//GEN-END:variables
}
