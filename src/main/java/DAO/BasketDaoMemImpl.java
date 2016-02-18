/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BusinessLogic.TaxCalculator;
import DTO.Basket;
import DTO.BasketedItem;
import DTO.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msssd
 */
public class BasketDaoMemImpl implements BasketDao {

    TaxCalculator calculator = new TaxCalculator();
    InputFileReader itemDao = new InputFileReader();

    @Override
    public Basket calculateBasket(List<BasketedItem> basketedItems) {
        Basket shoppingBasket = new Basket(basketedItems);
        shoppingBasket.setBasketedItems(basketedItems);
        shoppingBasket.setTotalTax(calculator.basketTaxTotal(basketedItems));
        shoppingBasket.setBasketTotal(calculator.calculateShoppingBasketTotal(basketedItems));
        return shoppingBasket;
    }

    //this method prints out the results of a basket to the console for user to see onscreen
    public void printBasketToConsole(Basket basket) {

        List<BasketedItem> basketItems = basket.getBasketedItems();
        DecimalFormat d = new DecimalFormat("0.00");
        String imported;
        //System.out.println(d.format(100));
        System.out.println("Below is your final order.\nThe order has been written to file as well as 'Receipt_inputfilename'.");
        System.out.println("---------------------");

        for (BasketedItem i : basketItems) {

            System.out.print(i.getItem().getQuantity());
            imported = i.getItem().getImportStatus();
            if (imported.contains("imported")) {
                System.out.print(" imported ");
            } else {
                System.out.print(" ");
            }

            System.out.print(i.getItem().getItemName() + ": ");
            System.out.println(d.format(calculator.pricePlusTax(i)));

        }
        System.out.println("Sales Taxes: " + d.format(basket.getTotalTax()));
        System.out.println("Total: " + d.format(basket.getBasketTotal()));

    }

    //this method reads out a calculatedBasket and writes it back to a file
    public void writeReceipt(String fileName, Basket basket) { //needs IoException etc. 

        //parse input file name and create output file name
        String receiptFileName = ("Receipt_" + fileName);

        DecimalFormat d = new DecimalFormat("0.00");
        String imported;

        //create print writer
        PrintWriter fileOut;

        try {
            fileOut = new PrintWriter(new FileWriter(receiptFileName));
            
                  //var Arraylist that we will pull out of our Arraylist hash
            List<BasketedItem> basketItemsForOutput = basket.getBasketedItems();

            for (BasketedItem i : basketItemsForOutput) {

                fileOut.print(i.getItem().getQuantity());
                imported = i.getItem().getImportStatus();

                if (imported.contains("imported")) {
                    fileOut.print(" imported ");
                } else {
                    fileOut.print(" ");
                }

                fileOut.print(i.getItem().getItemName() + ": ");
                fileOut.println(d.format(calculator.pricePlusTax(i)));

            }

            fileOut.println("Sales Taxes: " + d.format(basket.getTotalTax()));
            fileOut.println("Total: " + d.format(basket.getBasketTotal()));

            fileOut.flush();
            fileOut.close();
            

        } catch (IOException ex) {
            Logger.getLogger(InputFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }

     
  
    }

}

//    @Override
//    public Basket getBasket(String basketId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void updateBasket(Basket basket) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void deleteBasket(String basketId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


