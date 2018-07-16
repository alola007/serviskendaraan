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
 * @author Alololo
 */
public class SparepartsDAO {

    public int insert(Spareparts spareparts) throws SQLException {

        String sql = "insert into spareparts (kode_spare, nama_spare, harga_spare) values (?, ?, ?);";

        pst = con.prepareStatement(sql);
        pst.setString(1, spareparts.getKode());
        pst.setString(2, spareparts.getNama());
        pst.setString(3, String.valueOf(spareparts.getHarga()));

//        System.out.println(pst);
        int result = pst.executeUpdate();
        pst.close();
        System.out.println(String.valueOf(result) + " Spareparts Berhasil Ditambah.");

        return result;
    }

    public int update(Spareparts spareparts) throws SQLException {
        String sql = "UPDATE spareparts "
                + "set nama_spare=?, harga_spare=? "
                + "WHERE kode_spare=?;";

        pst = con.prepareStatement(sql);
        pst.setString(1, spareparts.getNama());
        pst.setString(2, String.valueOf(spareparts.getHarga()));
        pst.setString(3, spareparts.getKode());

        int result = pst.executeUpdate();
        pst.close();
        System.out.println(String.valueOf(result) + " Data Spareparts Berhasil di Ubah.");
        return result;
    }
    
    public int delete (Spareparts spareparts) throws SQLException{
        String sql = "Delete from spareparts "
                + "where kode_spare=?;";
        pst = con.prepareStatement(sql);
        pst.setString(1, spareparts.getKode());
        
        int result = pst.executeUpdate();
        pst.close();
        System.out.println(String.valueOf(result) + " Data Spareparts Berhasil di Ubah.");
        return result;
    }
}
