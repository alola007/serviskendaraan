/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import static main.TAPBO.con;
import static main.TAPBO.pst;

/**
 *
 * @author ALOLA
 */
public class AntrianDAO {

    public int insert(Antrian antrian) throws SQLException {

        String sql = "insert into antrian (nama, no_polisi, no_stnk) values (?, ?, ?);";

        pst = con.prepareStatement(sql);
        pst.setString(1, antrian.getNama());
        pst.setString(2, antrian.getNoPol());
        pst.setString(3, antrian.getNoStnk());

//        System.out.println(pst);
        int result = pst.executeUpdate();
        pst.close();
//        System.out.println(String.valueOf(result) + " Spareparts Berhasil Ditambah.");

        return result;
    }
    
    public int delete (Antrian antrian) throws SQLException{
        String sql = "Delete from antrian "
                + "where nama=?;";
        pst = con.prepareStatement(sql);
        pst.setString(1, antrian.getNama());
        
        int result = pst.executeUpdate();
        pst.close();
//        System.out.println(String.valueOf(result) + " Data Spareparts Berhasil di Ubah.");
        return result;
    }
}
