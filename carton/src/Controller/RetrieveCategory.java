/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author home
 */
import model.CategoryModel;
import databaseconnection.DataBaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class RetrieveCategory {

    private PreparedStatement p;
//    public String categorybox;
    private JComboBox<String> categorybox; // Assuming JComboBox is imported correctly

    public RetrieveCategory(JComboBox<String> categorybox) {
        this.categorybox = categorybox;
    }
  

    
    

    public RetrieveCategory() {
    }

    public void retrieveCategoryrFromDatabase(CategoryModel category) {
        try {
            // Ensure that the database connection is established
            DataBaseConnection.getInstance().ConnectToDatabase();

            String sql = "SELECT * FROM addcategory WHERE categoryname = ?";
            p = DataBaseConnection.getInstance().getConnection().prepareStatement(sql);

            p.setString(1, category.getCategoryName());

            ResultSet rs = p.executeQuery();

           while (rs.next()) {
                int CategoryName;
//                String categoryname = rs.getString(categoryname);
               categorybox.addItem(rs.getString("categoryname"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}