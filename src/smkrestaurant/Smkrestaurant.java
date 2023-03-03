/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smkrestaurant;

import java.sql.SQLException;
import smkrestaurant.Form.*;

/**
 *
 * @author User
 */
public class Smkrestaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        new Koneksi().connect();
        
        LoginForm form = new LoginForm();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
    }
    
}
