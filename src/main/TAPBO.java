/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import tapbo.HomePage;

/**
 *
 * @author ALOLA
 */
public class TAPBO {

    static TAPBO instance;
    public static Connection con;
    public static Statement stat;
    public static ResultSet rs;
    public static PreparedStatement pst;
    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/serviskendaraan", "root", "");
            stat = con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        new HomePage()
                .setVisible(true);
    }
}
