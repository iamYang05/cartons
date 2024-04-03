/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author home
 */
public class CategoryModel {
  
   
    public CategoryModel(String categoryName, byte[] image) {
        this.categoryName = categoryName;
        this.image = image;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public CategoryModel() {
    }
    
      private String categoryName;
        private byte[] image;
    
}