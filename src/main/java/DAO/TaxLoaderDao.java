/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 *
 * @author msssd
 */
public interface TaxLoaderDao {
    
     public HashMap loadTaxes() throws FileNotFoundException;
}
