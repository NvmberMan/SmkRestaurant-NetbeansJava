/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smkrestaurant;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smkrestaurant.Form.*;
/**
 *
 * @author User
 */
public class MenuModel {
   Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public void showData(DefaultTableModel dtm) throws ClassNotFoundException, SQLException{

            conn =  new Koneksi().connect();
            String sql = "SELECT * FROM msmenu";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Object[] data = {
                    "",
                    rs.getString("id"),
                    rs.getString("name"), 
                    rs.getString("price"),
                    rs.getString("carbo"),
                    rs.getString("protein")
                    
                };
                
                dtm.addRow(data);
            }
            rs.close();
            conn.close();
        
        
    }
    
}
