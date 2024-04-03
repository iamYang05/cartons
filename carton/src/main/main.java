/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import Category.Categories;
import Items.Items;
import Supplier.SupplierList;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import raven.glasspanepopup.GlassPanePopup;

/**
 *
 * @author home
 */
public class main extends javax.swing.JFrame {

    private SupplierList supplist;
    private Categories category;
    private Items item;

    public main() throws Exception {
        initComponents();
        supplist = new SupplierList();
        category = new Categories();
        item = new Items();
        GlassPanePopup.install(this);
        
    }

    private void showForms(Component com) {
        changePanel.removeAll();
        changePanel.add(com);
        repaint();
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel1 = new fe.mainpanel();
        loginlabel = new javax.swing.JLabel();
        supplier = new javax.swing.JButton();
        categoriesbutton = new javax.swing.JButton();
        itembutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        changePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        loginlabel.setBackground(new java.awt.Color(214, 227, 223));
        loginlabel.setFont(new java.awt.Font("Segoe UI Semibold", 2, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(255, 255, 255));
        loginlabel.setText("Inventory Management System");

        supplier.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        supplier.setForeground(new java.awt.Color(255, 255, 255));
        supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/home/images/newsupplier icon.png"))); // NOI18N
        supplier.setText("        SUPPLIER");
        supplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        supplier.setContentAreaFilled(false);
        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });

        categoriesbutton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        categoriesbutton.setForeground(new java.awt.Color(255, 255, 255));
        categoriesbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/home/images/category icon.png"))); // NOI18N
        categoriesbutton.setText("     CATEGORIES");
        categoriesbutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        categoriesbutton.setContentAreaFilled(false);
        categoriesbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesbuttonActionPerformed(evt);
            }
        });

        itembutton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        itembutton.setForeground(new java.awt.Color(255, 255, 255));
        itembutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/home/images/newitemicon.png"))); // NOI18N
        itembutton.setText("      ITEMS");
        itembutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        itembutton.setContentAreaFilled(false);
        itembutton.setPreferredSize(new java.awt.Dimension(197, 104));
        itembutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembuttonActionPerformed(evt);
            }
        });

        exitbutton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        exitbutton.setForeground(new java.awt.Color(255, 255, 255));
        exitbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/home/images/newlogout icon.png"))); // NOI18N
        exitbutton.setText("       EXIT");
        exitbutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        exitbutton.setContentAreaFilled(false);
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        changePanel.setBackground(new java.awt.Color(102, 102, 255));
        changePanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainpanel1Layout = new javax.swing.GroupLayout(mainpanel1);
        mainpanel1.setLayout(mainpanel1Layout);
        mainpanel1Layout.setHorizontalGroup(
            mainpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanel1Layout.createSequentialGroup()
                .addGroup(mainpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(mainpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itembutton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainpanel1Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(loginlabel)
                        .addGap(0, 401, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainpanel1Layout.setVerticalGroup(
            mainpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(loginlabel)
                .addGap(18, 18, 18)
                .addGroup(mainpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainpanel1Layout.createSequentialGroup()
                        .addComponent(supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itembutton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(changePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed
        showForms(supplist);
    }//GEN-LAST:event_supplierActionPerformed

    private void categoriesbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesbuttonActionPerformed
        showForms(category);
    }//GEN-LAST:event_categoriesbuttonActionPerformed

    private void itembuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembuttonActionPerformed
        showForms(item);
    }//GEN-LAST:event_itembuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Warning", JOptionPane.YES_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_exitbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton categoriesbutton;
    private javax.swing.JPanel changePanel;
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton itembutton;
    private javax.swing.JLabel loginlabel;
    private fe.mainpanel mainpanel1;
    private javax.swing.JButton supplier;
    // End of variables declaration//GEN-END:variables
}
