/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author msssd
 */
public class Item {

    private int itemId; //this will be assigned by the eventual DB, but here we'll make the ArrayList in the Basket our inMem DB
    
    private int quantity; 
    private String itemName; //right now, in the fileImpl, this is serving as the itemId/identifier, but in a more complex app this would be a number 
    private String importStatus; //will refactor this into boolean in a later iteration
    private boolean importProduct;
    private double price;


    //constructor - basic item
    public Item (int quantity, String itemName, String importStatus, double price) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.importStatus = importStatus;
        this.price = price;
       
    }

//    public int getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(int itemId) {
//        this.itemId = itemId;
//    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String isImportStatus() {
        return importStatus;
    }

    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus;
    }

 

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getImportStatus() {
        return importStatus;
    }

    public boolean isImportProduct() {
        return importProduct;
    }

    public void setImportProduct(boolean importProduct) {
        this.importProduct = importProduct;
    }


}
