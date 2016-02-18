/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author msssd
 */
public class TaxLoaderDaoImpl implements TaxLoaderDao {

    final String TAX_LOOKUP = "TaxCategoryLookup.txt";
    private HashMap<String, Integer> salesTaxMap;

    //constructor
    public TaxLoaderDaoImpl() {
        salesTaxMap = new HashMap<>(); 
    }

    @Override
    public HashMap loadTaxes() throws FileNotFoundException {
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader(TAX_LOOKUP)));
        
        while (sc.hasNextLine()){
            
            String currentLine = sc.nextLine();
            
            String[] tokenArray = currentLine.split(",");
            
            String currentItem = tokenArray[0];
            String currentExRate = tokenArray[1];
            
            int currItemSalesTax = Integer.parseInt(currentExRate);
                
            salesTaxMap.put(currentItem, currItemSalesTax);
            
        }

        return salesTaxMap;
    }
    
  

}
