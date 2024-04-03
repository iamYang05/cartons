/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author home
 */
import databaseconnection.DataBaseConnection;
import model.AddItemsModel;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AddItem {

    private PreparedStatement p;

    public AddItem() {
    }

    public void addItemsToDatabase(AddItemsModel item) {
        try {
            // Ensure that the database connection is established
            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "INSERT INTO additems (image,supplier,productname,productid,category,quantity,cost,price,status,date) VALUES (?,?,?,?,?,?,?,?,?,?)";
            p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setBytes(1, item.getImage());
            p.setString(2, item.getSupplier());
            p.setString(3, item.getProductName());
            p.setString(4, item.getProductId());
            p.setString(5, item.getProductCategory());
            p.setString(6, item.getQuantity());
            p.setString(7, item.getCost());
            p.setString(8, item.getPrice());
            p.setString(9, item.getStatus());
            p.setString(10, item.getDate());

            p.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}