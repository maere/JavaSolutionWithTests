/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author msssd
 */
public class Basket {
   
    private int basketId; //right now would be assigned with the constructor, but in a DB implementation these would get auto-incremented
    private List<BasketedItem> basketedItems;
    private double totalTaxOnBasket; //these could be either doubles cast from BigDecimal, or leave as BigDecimals and work with that
    private double basketGrandTotal;
    
    static int counter = 0;
    
   
   //constructor
   public Basket(List<BasketedItem> basketedItems) { 
        this.basketId = ++counter; //id gets incremented each time we make a basket, but could use numbering on txt file, or DB id
        this.basketedItems = basketedItems;
    
   }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public List<BasketedItem> getBasketedItems() {
        return basketedItems;
    }

    public void setBasketedItems(List<BasketedItem> basketedItems) {
        this.basketedItems = basketedItems;
    }

    public double getTotalTax() {
        return totalTaxOnBasket;
    }

    public void setTotalTax(double totalTax) {
        this.totalTaxOnBasket = totalTax;
    }

    public double getBasketTotal() {
        return basketGrandTotal;
    }

    public void setBasketTotal(double basketTotal) {
        this.basketGrandTotal = basketTotal;
    }


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Basket.counter = counter;
    }

  
   
}
