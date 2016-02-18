/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author msssd
 */
public interface ItemDao {
    
    public List<Item> readFromFile(String fileName) throws FileNotFoundException;
    
//    public Item getItem(int itemId);
//    public Item createItem(Item item);
//    
//    public List<Item> getItems();
//    
//    public void updateItem(Item item);
//    public void deleteItem(int itemId);
//    
    //public void writeReceipt(String fileName); //think it might be better to do this from the basketclass
    
}
