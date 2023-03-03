/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smkrestaurant;
import java.sql.*;
/**
 *
 * @author User
 */
public class Koneksi {
      
    private final  String JDBC_URL = "com.mysql.cj.jdbc.Driver";
    private final String DB_NAME = "smkrestaurant";
    private final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;
    private final String USER = "root";
    private final String PASS ="";
    
//    Connection
    Connection conn;
    
    public Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_URL);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        System.out.println("Koneksi sukses");
        return conn;
    }
}
