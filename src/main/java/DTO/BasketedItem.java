/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author msssd
 */
public class BasketedItem {
    
    //calculated or estimated
    private Item item;
    //private boolean importedProduct; //currently this is not needed as a bool, but for a DB implementation would be good
    private int salesTaxRate; //determined by tax table lookup for exempt items
    private int importTaxRate; //determined by value of item importStatus
    private double taxAdded;
    
    //constructor - basic item
    public BasketedItem (Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(int salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public int getImportTaxRate() {
        return importTaxRate;
    }

    public void setImportTaxRate(int importTaxRate) {
        this.importTaxRate = importTaxRate;
    }

    public double getTaxAdded() {
        return taxAdded;
    }

    public void setTaxAdded(double taxAdded) {
        this.taxAdded = taxAdded;
    }


   
}

   
