package OLD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BusinessLogic.TaxCalculator;
import Controllers.TaxCalcController;
import DAO.BIDao;
import DAO.BasketDaoMemImpl;
import DAO.InputFileReader;
import DAO.TaxLoaderDaoImpl;
import DTO.Basket;
import DTO.BasketedItem;
import DTO.Item;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author msssd
 */
public class OLD_UnitTestsForDelimitedFile_onlyUseForCommaDelimitedFiles {

    private BIDao basketedItemDao = new BIDao();
    private InputFileReader itemDao = new InputFileReader();
    private TaxLoaderDaoImpl taxLoader = new TaxLoaderDaoImpl();
    private BasketDaoMemImpl basketDao = new BasketDaoMemImpl();
    private TaxCalculator calculator = new TaxCalculator();

    public OLD_UnitTestsForDelimitedFile_onlyUseForCommaDelimitedFiles() {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//
//    @Test
//    public void createItemTest() throws FileNotFoundException {
//        String file = "cart01.txt";
//        ItemDaoFileImpl itemDaoTestObj = new ItemDaoFileImpl();
//        List<Item> testList = itemDaoTestObj.readItemsFromFile(file);
//        Boolean result = testList.isEmpty();
//        Assert.assertFalse(result);
//    }
//
//    @Test
//    public void createBasketedItemFromItemTest() {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        BasketedItem bItem = new BasketedItem(testItem);
//        Assert.assertEquals("book", bItem.getItem().getItemName());
//    }
//
//    @Test
//    public void checkImportTaxRateCheckerMethod() {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        int rateResultOnItem = basketedItemDao.checkImportTaxRate(testItem);
//        Assert.assertEquals(5, rateResultOnItem);
//    }
//
//    @Test
//    public void checkImportTaxRateCheckerMethodNonImport() {
//        Item testItem = new Item(1, "book", " ", 9.75);
//        int rateResultOnItem = basketedItemDao.checkImportTaxRate(testItem);
//        Assert.assertEquals(0, rateResultOnItem);
//    }
//
//    @Test
//    public void checkImportTaxRateOnBasketedItem() throws FileNotFoundException {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        BasketedItem bItem = basketedItemDao.addValuesToBasketedItem(testItem); 
//        int resultingRate = bItem.getImportTaxRate();
//        Assert.assertEquals(5, resultingRate); 
//    }
//
//    @Test
//    public void checkSalesTaxRateOnBasketedItem() throws FileNotFoundException {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        BasketedItem bItem = basketedItemDao.addValuesToBasketedItem(testItem);
//        int salesTaxRateResult = bItem.getSalesTaxRate();
//        Assert.assertEquals(0, salesTaxRateResult);
//    }
//
//    @Test
//    public void checkTaxAddedOnBasketedItem() throws FileNotFoundException {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        BasketedItem bItem = basketedItemDao.addValuesToBasketedItem(testItem);
//        double salesTaxResult = calculator.calculateItemTaxes(bItem);
//        Assert.assertEquals(.50, salesTaxResult, 0);
//    }
//
//    @Test
//    public void checkTaxAddedOnBasketedItemWithSalesTax() throws FileNotFoundException {
//        Item testItem = new Item(1, "music CD", "", 8.41);
//        Map<String, Integer> salesTaxMap = taxLoader.loadTaxes();
//        BasketedItem bItem = basketedItemDao.addValuesToBasketedItem(testItem);
//        double salesTaxResult = calculator.calculateItemTaxes(bItem);
//        Assert.assertEquals(.85, salesTaxResult, 0);
//    }
//
//    @Test
//    public void checkItemTaxInBasketList() throws FileNotFoundException {
//        String file = "cart01.txt";
//        List<Item> testList = itemDao.readItemsFromFile(file);
//        List<BasketedItem> basketedItems = basketedItemDao.addTaxValuesToItems(testList);
//        BasketedItem testBItem = basketedItems.get(1);
//        double salesTaxOnCd = testBItem.getTaxAdded();
//        Assert.assertEquals(1.50, salesTaxOnCd, 0);
//    }
//
//    @Test
//    public void testPricePlusTaxAddedPerItemMethod() throws FileNotFoundException {
//        Item testItem = new Item(1, "book", "imported", 9.75);
//        BasketedItem bItem = basketedItemDao.addValuesToBasketedItem(testItem);
//        double salesTaxResult = calculator.pricePlusTax(bItem);
//        Assert.assertEquals(10.25, salesTaxResult, 0);
//    }
//
//    @Test
//    public void testTotalTaxFromBasketedItemsMethod() throws FileNotFoundException {
//        String file = "cart02.txt";
//        List<Item> testList = itemDao.readItemsFromFile(file);
//        List<BasketedItem> bList = basketedItemDao.addTaxValuesToItems(testList);
//        double totalTaxForBasket = calculator.basketTaxTotal(bList);
//        Assert.assertEquals(7.65, totalTaxForBasket, 0);
//    }
//
//    @Test
//    public void testGrandTotalFromBasketMethod() throws FileNotFoundException {
//        String file = "cart02.txt";
//        List<Item> testList = itemDao.readItemsFromFile(file);
//        List<BasketedItem> bList = basketedItemDao.addTaxValuesToItems(testList);
//        double basketTotalResult = calculator.calculateShoppingBasketTotal(bList);
//        Assert.assertEquals(65.15, basketTotalResult, 0);
//    }
//
//    @Test
//    public void createBasketFromBasketedItemsAndItemsList() throws FileNotFoundException {
//        String file = "cart01.txt";
//        List<Item> testList = itemDao.readItemsFromFile(file);
//        List<BasketedItem> listOfTaxedItems = basketedItemDao.addTaxValuesToItems(testList);
//        Basket finalBasket = basketDao.calculateBasket(listOfTaxedItems);
//        int numOfItems = finalBasket.getBasketedItems().size();
//        double basketTotal = finalBasket.getBasketTotal();
//        Assert.assertTrue(numOfItems==3 && basketTotal==29.83);
//    }

    //delete after running....
//    @Test //not really an automated test--depends on users view of console
//    public void testOutputToConsole() throws FileNotFoundException {
//        String file = "cart03.txt";
//        List<Item> testList = itemDao.readItemsFromFile(file);
//        List<BasketedItem> listOfTaxedItems = basketedItemDao.addTaxValuesToItems(testList);
//        Basket finalBasket = basketDao.calculateBasket(listOfTaxedItems);
//        basketDao.printBasketToConsole(finalBasket);
//        Assert.assertTrue(true);
//    }
    
    //test for new input parser method
    
//    @Test
//    public void testParse(){
//        String testString = "1 imported box of chocolates at 10.00";
//        LinkedList<String> testLL = itemDao.parseLine(testString);
//        String first = testLL.removeFirst();
//        String last = testLL.removeLast();
//        String remainder = Arrays.toString(testLL.toArray());
//        Assert.assertEquals("1", first);
//        Assert.assertEquals("10.00", last);
//    }
//    
//    @Test
//    public void testImportedQuery(){
//        String testString = "1 imported box of chocolates at 10.00";
//        LinkedList<String> testLL = itemDao.parseLine(testString);
//        String first = testLL.removeFirst();
//        String last = testLL.removeLast();
//        String remainder = Arrays.toString(testLL.toArray());
//        boolean importTest = itemDao.isImportItem(remainder);
//        Assert.assertTrue(importTest);
//    }
//    
//    @Test
//    public void testImportIfinLLAndSetBool(){
//        String testString = "1 imported box of chocolates at 10.00";
//        LinkedList<String> testLL = itemDao.parseLine(testString);
//        boolean importTest = itemDao.isImportItem(testLL);
//        Assert.assertTrue(importTest);
//    
//    }
    
    @Test 
    public void removeImportedFromLLConcatString(){
        String testString = "1 imported box of chocolates at 10.00";
        LinkedList<String> testLL = itemDao.parseLine(testString);
        String first = testLL.removeFirst();
        String last = testLL.removeLast();
        String itemName = itemDao.cleanUpItemName(testLL);
        Assert.assertEquals("box of chocolates", itemName);
    }
    
    @Test
    public void createItemTestForNewReadFromFileMethod() throws FileNotFoundException {
        String file = "input3.txt";
        InputFileReader itemDaoTestObj = new InputFileReader();
        List<Item> testList = itemDaoTestObj.readFromFile(file);
        Boolean result = testList.isEmpty();
        Assert.assertFalse(result);
    }
    
}
