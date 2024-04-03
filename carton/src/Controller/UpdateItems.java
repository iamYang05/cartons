/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import databaseconnection.DataBaseConnection;
import model.AddItemsModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class UpdateItems {
    private PreparedStatement p;

    public UpdateItems() {
    }

    public void updateItemInDatabase(AddItemsModel item) {
        try {
            // Ensure that the database connection is established
            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "UPDATE additems SET column6 = ?, column8 = ?, column9 = ? WHERE quantity = ? AND price =? AND status =? ";
            p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);

            // Set the values you want to update
//            p.setString(1, item.getNewValueForColumn6());
//            p.setString(2, item.getNewValueForColumn8());
//             p.setString(3, item.getNewValueForColumn9());
//            // Set other columns accordingly

            // Set the condition for the update (in this case, product name)
            p.setString(4, item.getQuantity());
            p.setString(5, item.getPrice());
            p.setString(6, item.getStatus());

            int rowsAffected = p.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Product successfully updated.");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found or could not be updated.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}