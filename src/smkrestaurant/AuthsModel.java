/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smkrestaurant;

import java.sql.*;
import javax.swing.JOptionPane;
import smkrestaurant.Form.*;
/**
 *
 * @author User
 */
public class AuthsModel {
         Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public void login(String email,String pass,LoginForm lf) 
       throws ClassNotFoundException, SQLException{
//      isi objek conn untuk mendapatkan koneksi dengan database
        conn = new Koneksi().connect();
//        buatlah sql query untuk menampilkan data user berdasarkan kondisi username dan password
        String query = "SELECT * FROM msemployee "
                + "WHERE email=? and password=?";
        
//        membaca string query dan passing data pada statement (?) 1 dan 2 
        pst = conn.prepareStatement(query);
        pst.setString(1, email);
        pst.setString(2, pass);
//        jalankan query dan simpan pada resultset
        rs = pst.executeQuery();
//        jika data user available
        if(rs.next()){
            System.out.println("Login berhasil");
//            JOptionPane.showMessageDialog(null, "Login berhasil");
            System.out.println("email:"+
                    rs.getString("email"));
            System.out.println("password:"+
                    rs.getString("password"));
            
            lf.dispose();
            
            //active
            if("admin".equals(rs.getString("position")))
            {
                AdminForm page = new AdminForm();
                page.setVisible(true);
                page.setLocationRelativeTo(null);
                page.welcomeText.setText("Welcome, " + rs.getString("name"));

            }else
            {
                CashierForm page = new CashierForm();
                page.setVisible(true);
                page.setLocationRelativeTo(null);
                page.welcomeText.setText("Welcome, " + rs.getString("name"));

            }
            
        }else{
              JOptionPane.showMessageDialog(null, "Login gagal"); 
            System.out.println("Login gagal , data tidak ada");
        }
    } 
}
