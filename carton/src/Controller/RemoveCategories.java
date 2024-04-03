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
import model.CategoryModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class RemoveCategories {

    private PreparedStatement p;

    public RemoveCategories() {
    }

    public void removeCategoryFromDatabase(CategoryModel category) {
        try {
            // Ensure that the database connection is established
            DataBaseConnection.getInstance().ConnectToDatabase();

            // Construct the SQL query to delete the category and its associated image
            String sql = "DELETE FROM addcategory WHERE categoryName = ?";
            p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, category.getCategoryName());

            // Execute the delete query
            int rowsAffected = p.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Category and its associated image removed successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Category not found or could not be removed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}