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
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class RemoveItems {
       private PreparedStatement p;
    public RemoveItems() {
    }
  public void retrieveItemFromDatabase(AddItemsModel item) {
    try {
        // Ensure that the database connection is established
        DataBaseConnection.getInstance().ConnectToDatabase();
        
        String sql = "SELECT * FROM additems WHERE productname = ?";
        p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);

        p.setString(1, item.getProductName());
       
         int rowsAffected = p.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Product successfully removed.");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found or could not be removed.");
            }
       
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}