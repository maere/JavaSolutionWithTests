/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BusinessLogic.TaxCalculator;
import DAO.BIDao;
import DAO.BasketDaoMemImpl;
import DAO.InputFileReader;
import DAO.TaxLoaderDaoImpl;
import java.util.Scanner;
import DTO.Basket;
import DTO.BasketedItem;
import DTO.Item;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author msssd
 */
public class TaxCalcController {

    String cartFileName;

    InputFileReader inMemItemImpl = new InputFileReader();
    BIDao basketItemDao = new BIDao();
    BasketDaoMemImpl shoppingBasketDao = new BasketDaoMemImpl();
   
    public void run() throws FileNotFoundException {

        //ask for input file 
        cartFileName = locateData(); 
        
        //parse input file to in-memory list object of items
        List<Item> itemList = inMemItemImpl.readFromFile(cartFileName); 
        
        //create an intermediary object to carry item object and applicable tax rates with a calculation of total taxes added for a particular item
        List<BasketedItem> basketItemObjectList = basketItemDao.addTaxValuesToItems(itemList);
        
        //creates a finished shopping cart object with total taxes and calculates totals for cart
        //Basket shoppingCart = new Basket(basketItemObjectList);
        Basket finalCart = shoppingBasketDao.calculateBasket(basketItemObjectList);
        
        //outputs contents of finished cart
        shoppingBasketDao.printBasketToConsole(finalCart);
        
        //writes finished cart to file
        shoppingBasketDao.writeReceipt(cartFileName, finalCart);
        

    }

    public String locateData() throws FileNotFoundException {

        Scanner scObj = new Scanner(System.in);

        try {
            System.out.println("Enter the name of your shopping cart file:");
            cartFileName = scObj.nextLine();
            
           
        } catch (Exception e) {

            System.out.println("There was a problem. Exiting....");
            return null;
        }
        
        return cartFileName;
    }

}

