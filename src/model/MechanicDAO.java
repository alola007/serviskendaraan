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
public class MechanicDAO {

    public int insert(Mechanic mechanic) throws SQLException {

        String sql = "insert into mekanik (no_mekanik, nama, alamat, telepon, jk) values (?, ?, ?, ?, ?);";

        pst = con.prepareStatement(sql);
        pst.setString(1, String.valueOf(mechanic.getNom()));
        pst.setString(2, mechanic.getNama());
        pst.setString(3, mechanic.getAlamat());
        pst.setString(4, mechanic.getNotelp());
        pst.setString(5, String.valueOf(mechanic.getGender()));

//        System.out.println(pst);
        int result = pst.executeUpdate();
        pst.close();
//        System.out.println(String.valueOf(result) + " Spareparts Berhasil Ditambah.");

        return result;
    }

    public int delete(Mechanic mechanic) throws SQLException {
        String sql = "Delete from mekanik "
                + "where no_mekanik=?;";
        pst = con.prepareStatement(sql);
        pst.setString(1, String.valueOf(mechanic.getNom()));

        int result = pst.executeUpdate();
        pst.close();
//        System.out.println(String.valueOf(result) + " Data Spareparts Berhasil di Ubah.");
        return result;
    }
}
