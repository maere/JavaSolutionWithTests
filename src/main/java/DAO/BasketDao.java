/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Basket;
import DTO.BasketedItem;
import DTO.Item;
import java.util.List;

/**
 *
 * @author msssd
 */
public interface BasketDao {
    
    public Basket calculateBasket(List<BasketedItem> basketedItems);
//    public Basket getBasket(String basketId);
//    public void updateBasket(Basket basket);
//    public void deleteBasket(String basketId);
    
  
}
