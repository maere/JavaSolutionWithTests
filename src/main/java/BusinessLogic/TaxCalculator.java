/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DTO.BasketedItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

/**
 *
 * @author msssd
 */
public class TaxCalculator {

    //calculates final tax on item, called from BIDao class
    public double calculateItemTaxes(BasketedItem bItem) {

        double itemTax;
        int itemRate = bItem.getSalesTaxRate() + bItem.getImportTaxRate();
        double itemPrice = bItem.getItem().getPrice();

        itemTax = (itemRate * itemPrice) / 100;
        //itemTax returned will need to get assigned to a variable and passed in as value in method below....
        BigDecimal finalTax = roundIncrement(BigDecimal.valueOf(itemTax), BigDecimal.valueOf(0.05), RoundingMode.UP);

        double basketItemTax = finalTax.doubleValue();

        return basketItemTax;
    }

    //static allows it to be used without having to instantiate anything
    public static BigDecimal roundIncrement(BigDecimal value, BigDecimal increment,
            RoundingMode roundingMode) {
        if (increment.signum() == 0) {
            // prevent division by 0
            return value;
        } else {
            BigDecimal divided = value.divide(increment, 0, roundingMode);
            BigDecimal result = divided.multiply(increment);
            return result;
        }
    }

    //calculate price+tax for an individual basketItem
    public double pricePlusTax(BasketedItem bItem) {

        double itemPriceWithTax = bItem.getTaxAdded() + bItem.getItem().getPrice();
        return itemPriceWithTax;
    }

    //calculate total tax for basket from all items in basketeditem list
    public double basketTaxTotal(List<BasketedItem> bList) {

        double thisItemTax;
        double basketTax = 0;

        for (BasketedItem i : bList) {

            thisItemTax = i.getTaxAdded();
            basketTax = basketTax + thisItemTax;

        }
        return basketTax;
    }

    //calculate total cost for basket
    public double calculateShoppingBasketTotal(List<BasketedItem> bList) {

        double cartTotal = 0;
        double basketGrandTotal = 0;

        for (BasketedItem i : bList) {
            //double currentItemWithTax = bList.
            double itemPriceWithTax = pricePlusTax(i);

            cartTotal = cartTotal + itemPriceWithTax;

            BigDecimal finalTotal = roundIncrement(BigDecimal.valueOf(cartTotal), BigDecimal.valueOf(0.01), RoundingMode.HALF_UP);

            basketGrandTotal = finalTotal.doubleValue();
        }

        return basketGrandTotal;
    }

   
}


