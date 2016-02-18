
import Controllers.TaxCalcController;
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msssd
 */
public class App {
    
    public static void main(String[] args) throws FileNotFoundException {
        TaxCalcController controller = new TaxCalcController();
        controller.run();
    }
    
    
    
}
