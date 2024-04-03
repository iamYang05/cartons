/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author home
 */
public class AddItemsModel {
    

    /**
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    /**
     * @return the ProductId
     */
    public String getProductId() {
        return ProductId;
    }

    /**
     * @param ProductId the ProductId to set
     */
    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    /**
     * @return the ProductCategory
     */
    public String getProductCategory() {
        return ProductCategory;
    }

    /**
     * @param ProductCategory the ProductCategory to set
     */
    public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;
    }

    /**
     * @return the Supplier
     */
    public String getSupplier() {
        return Supplier;
    }

    /**
     * @param Supplier the Supplier to set
     */
    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    /**
     * @return the Quantity
     */
    public String getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the Cost
     */
    public String getCost() {
        return Cost;
    }

    /**
     * @param Cost the Cost to set
     */
    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }
    
  public String getStatus() {
    return Status;
}

public void setStatus(String Status) {
    this.Status = Status;
}
    
      public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public AddItemsModel() {
    }
    
    private String ProductName;
    private String ProductId;
    private String ProductCategory;
    private String Supplier;
    private String Quantity;
    private String Cost;
    private String Price;
    private String Date;
    private String Status;
    private byte[] image;
    
}