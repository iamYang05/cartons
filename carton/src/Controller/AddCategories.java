/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import databaseconnection.DataBaseConnection;
import model.CategoryModel;
import java.sql.PreparedStatement;

public class AddCategories {

    private PreparedStatement p;

    public AddCategories() {
    }

    public void addCategoriesToDatabase(CategoryModel category) {
        try {
            // Ensure that the database connection is established
            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "INSERT INTO addcategory (categoryname, image) VALUES (?,?)";
            p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, category.getCategoryName());
            p.setBytes(2, category.getImage());

            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}