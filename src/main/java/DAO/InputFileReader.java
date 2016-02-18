/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Basket;
import DTO.BasketedItem;
import DTO.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msssd
 */
public class InputFileReader implements ItemDao {

    List<Item> itemList = new ArrayList<>();

    public boolean checkFileExists(String fileName) {
        File checkFile = new File(fileName);
        return checkFile.exists();
    }

    //this method is for reading the items from the file and creating an in memory ArrayList of item object
    @Override
    public List<Item> readFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = null;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                LinkedList<String> lineToList = parseLine(currentLine);

                int quantity;
                double price;
                try {
                    quantity = Integer.parseInt(lineToList.removeFirst());
                    price = Double.parseDouble(lineToList.removeLast());
                } catch (Exception e) {

                    quantity = 0;
                    price = 0;
                    System.out.println("We were not able to find a quantity and/or price for this item.\nThe value of your cart will be nil.");
                }

                String itemName = cleanUpItemName(lineToList);

                //below is a value I'm using to replace the string value immediately below
                boolean importProduct = isImportItem(currentLine);
                //this is an old method I'm supporting at the moment, but will eventually remove once I've changed the method in BIDao
                String importStatus = "";
                if (currentLine.contains("imported")) {
                    importStatus = "imported";
                }

                Item currentItem = new Item(quantity, importStatus, itemName, price);

                currentItem.setQuantity(quantity);
                currentItem.setImportStatus(importStatus);
                currentItem.setItemName(itemName);
                currentItem.setPrice(price);
                currentItem.setImportProduct(importProduct);

                itemList.add(currentItem);

            }

            sc.close();
            //System.out.println("Basket for " + fileName + " loaded successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("No file found for " + fileName + ".\nPlease check the file name and make sure that the file \nis located in the top level of the project directory. ");
        }

        return itemList;

    }

    public List<Item> readFromFileIntoArray(String fileName) throws FileNotFoundException {
        Scanner sc = null;

        //REFACTOR plans for this method:
        
        //check file exists
        
        //separate into line
        
        //convert lines into items
        
        //calculate import tax
        
        //create cart
        try {
            sc = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] tokenArray = currentLine.split("\\s");
//                LinkedList<String> lineToList = parseLine(currentLine);

                int quantity;
                double price;
                try {
                    int arrLength = tokenArray.length;
                    quantity = Integer.parseInt(tokenArray[0]);
                    price = Double.parseDouble(tokenArray[arrLength - 1]);
                } catch (Exception e) {
//                    
                    quantity = 0;
                    price = 0;
                    System.out.println("We were not able to find a quantity and/or price for this item.\nThe value of your cart will be nil.");
                }

            //could also call and pass in STring[] methods here...
                StringBuilder intermediaryString = new StringBuilder();

                for (int i = 1; i < tokenArray.length - 2; i++) {
                    intermediaryString.append(tokenArray[i]);
                }

            //could also keep as a String[] here and call methods to:
                //1)checkImport 
                //2)get rid of word "imported" in array
                String itemName = intermediaryString.toString();

                //below is a value I'm using to replace the string value immediately below
                boolean importProduct = isImportItem(currentLine);
                //this is an old method I'm supporting at the moment, but will eventually remove once I've changed the method in BIDao
                String importStatus = "";

                if (currentLine.contains("imported")) {
                    importStatus = "imported";
                }

                Item currentItem = new Item(quantity, importStatus, itemName, price);

                currentItem.setQuantity(quantity);
                currentItem.setImportStatus(importStatus);
                currentItem.setItemName(itemName);
                currentItem.setPrice(price);
                currentItem.setImportProduct(importProduct);

                itemList.add(currentItem);

            }

            sc.close();
            //System.out.println("Basket for " + fileName + " loaded successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("No file found for " + fileName + ".\nPlease check the file name and make sure that the file \nis located in the top level of the project directory. ");
        }

        return itemList;

    }

    //parsing method that keeps the array vs. converting to a LinkedList
    public boolean checkArrayForImport(String[] origArray) {

        String str = "imported";

        boolean containsImported = false;

        for (String s : origArray) {
            if (str.equalsIgnoreCase(s)) {
                containsImported = true;
                break; // No need to look further.
            }
        }

        return containsImported;
    }

    //parsing method that keeps the array vs. converting to a LinkedList
    public String[] parsedArray(String[] origArray) {

        String[] cleanArray = origArray;
        String str = "imported";

        for (String s : origArray) {
            if (str.equalsIgnoreCase(s)) {
                List<String> stringList = Arrays.asList(origArray);
                int importIndex = stringList.indexOf(str);
                stringList.remove(importIndex);
                cleanArray = stringList.toArray(new String[0]);
                break; // No need to look further.
            }
        }

        return cleanArray;
    }

    //these are utility methods for more flexibly reading in the line from file
    public LinkedList<String> parseLine(String line) {

        String[] tokens = line.split(" ");
        LinkedList<String> listTokens = new LinkedList<>();
        String currentToken;

        for (int i = 0; i < tokens.length; i++) {
            currentToken = tokens[i];
            listTokens.add(currentToken);
        }
        return listTokens;
    }

    public boolean isImportItem(String remainingString) {
        boolean importedItem = false;

        if (remainingString.contains("imported")) {
            importedItem = true;
        }
        return importedItem;
    }

    public boolean isImportItem(LinkedList listOfStringTokens) {
        boolean importedItem = false;

        if (listOfStringTokens.contains("imported")) {
            importedItem = true;
        }
        return importedItem;
    }

    public String cleanUpItemName(LinkedList<String> listOfStringTokens) {

        StringBuilder itemName = new StringBuilder();

        if (listOfStringTokens.contains("imported")) {

            int i = listOfStringTokens.indexOf("imported");
            listOfStringTokens.remove(i);
            listOfStringTokens.removeLast();//ostensibly "at" - be sure to have pulled head/tail and stored

            for (String s : listOfStringTokens) {
                itemName.append(s);
                itemName.append(" ");
            }
            itemName.deleteCharAt(itemName.length() - 1);
            return itemName.toString();

        } else {

            listOfStringTokens.removeLast();

            for (String s : listOfStringTokens) {
                itemName.append(s);
                itemName.append(" ");
            }
            itemName.deleteCharAt(itemName.length() - 1);

        }
        return itemName.toString();
    }

 

}//end of class

//     @Override 
//    public Item createItem(Item item) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//     
//    @Override
//    public Item getItem(int itemId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//
//    @Override
//    public List<Item> getItems() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void updateItem(Item item) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void deleteItem(int itemId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//OLD:
//  @Override
//    public List<Item> readItemsFromFile(String fileName) throws FileNotFoundException {
//
//        Scanner sc = null;
//
//        try {
//            sc = new Scanner(new BufferedReader(new FileReader(fileName)));
//
//            while (sc.hasNextLine()) {
//
//                String currentLine = sc.nextLine();
//
//                String[] currentToken = currentLine.split(",");
//
//                int quantity = Integer.parseInt(currentToken[0]);
//                String importStatus = currentToken[1];
//                String itemName = currentToken[2];
//                double price = Double.parseDouble(currentToken[3]);
//
//                Item currentItem = new Item(quantity, importStatus, itemName, price);
//
//                currentItem.setQuantity(quantity);
//                currentItem.setImportStatus(importStatus);
//                currentItem.setItemName(itemName);
//                currentItem.setPrice(price);
//
//                itemList.add(currentItem);
//
//            }
//
//            sc.close();
//            System.out.println("Basket for " + fileName + " loaded successfully.");
//
//        } catch (FileNotFoundException e) {
//
//            System.out.println("\n No file found called " + fileName);
//        }
//
//        return itemList;
//
//    }
