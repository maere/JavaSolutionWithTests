/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BusinessLogic.TaxCalculator;
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
public class BIDao {

    TaxLoaderDaoImpl taxFileToMem = new TaxLoaderDaoImpl();
    Map<String, Integer> salesTaxMap;
    TaxCalculator calculator = new TaxCalculator();

    //create basketedItem and add values
    public BasketedItem addValuesToBasketedItem(Item item) throws FileNotFoundException {

        BasketedItem currItem = new BasketedItem(item);

        currItem.setImportTaxRate(checkImportTaxRate(item));
        currItem.setSalesTaxRate(checkSalesTaxRate(item));
        currItem.setTaxAdded(calculator.calculateItemTaxes(currItem));

            //this will get done in another step, from the controller, add to basket - taxedItems.add(currentI);
        return currItem;
    }

    //create basketed itemList from itemList
    public List<BasketedItem> addTaxValuesToItems(List<Item> items) throws FileNotFoundException {

        List<BasketedItem> taxedItems = new ArrayList<>();

        for (Item i : items) {

            //calls method above for addingTaxValuesTo individual basekted item            
            BasketedItem currentI = addValuesToBasketedItem(i);

            taxedItems.add(currentI);
        }
        return taxedItems;
    }

    // checks taxrate for exemptionrate  based on lookup table
    public int checkSalesTaxRate(Item item) throws FileNotFoundException, NullPointerException {
        salesTaxMap = taxFileToMem.loadTaxes();
        
        int rate;

        if (item == null || salesTaxMap.get(item.getItemName())==null) {
            item.setItemName("not found");
            rate = salesTaxMap.get(item.getItemName());
        } else {
            rate = salesTaxMap.get(item.getItemName());
        }

        
        return rate;
    }

    //checks if imported and assigns tax 
    public int checkImportTaxRate(Item item) {

        int importRate;

        if (item.getImportStatus().matches("imported")) {

            item.setImportProduct(true);
            importRate = 5;
        } else {
            item.setImportProduct(false);
            importRate = 0;
        }

        return importRate;
    }

}
